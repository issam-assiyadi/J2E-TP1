package org.example.DI;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;


public class BeanFactoryImpl implements BeanFactory {
    DIContainer container;

    public BeanFactoryImpl(DIContainer container) {
        this.container = container;
    }

    @Override
    public Object createBean(Bean bean) {
        try {
            Class<?> beanClass = Class.forName(bean.getClassName());
            Object[] args = resolveConstructorArgs(bean.getConstructorArgs());
            Object instance = createInstance(beanClass,args);
            System.out.println(bean);
            if (bean.getProperties() != null && !bean.getProperties().isEmpty() ){
                for(Property property : bean.getProperties()){
                    Field field = beanClass.getDeclaredField(property.getName());
                    System.out.println("Feild:" + field.getType());
                    field.setAccessible(true);
                    Object propertyValue = container.getBeans().get(property.getRef());
                    field.set(instance,propertyValue);
                }
            }
            return instance;
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    private Object[] resolveConstructorArgs(List<ConstructorArg> constructorArgs){
        if (constructorArgs == null || constructorArgs.isEmpty()){
            return new Object[0];
        }
        return constructorArgs.stream()
                .map(arg -> container.getBeans().get(arg.getRef()))
                .toArray();
    }
    private Object createInstance(Class<?> beanClass, Object[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Constructor<?>[] constructors = beanClass.getConstructors();
        for(Constructor<?> constructor : constructors){
            if (constructor.getParameters().length == args.length){
                return constructor.newInstance(args);
            }
        }
        return beanClass.newInstance();
    }
}
