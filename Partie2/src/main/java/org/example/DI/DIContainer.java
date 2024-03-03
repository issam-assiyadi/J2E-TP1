package org.example.DI;

import java.io.File;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class DIContainer {
    private Map<String,Object> beans;
    private BeanFactory beanFactory;

    public DIContainer(Map<String, Object> beans) {
        this.beans = beans;
    }

    public void writeBeansFromXML(String xmlPath) {
        try {

            File file = new File(xmlPath);
            JAXBContext jaxbContext = JAXBContext.newInstance(BeanConfig.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            BeanConfig beanConfig = (BeanConfig) jaxbUnmarshaller.unmarshal(file);
            for(Bean bean : beanConfig.getBeans()){
                System.out.println(bean.getClassName());
            }

            for(Bean bean : beanConfig.getBeans()){
               register(bean.getId(),beanFactory.createBean(bean));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Map<String, Object> getBeans() {
        return beans;
    }

    public void register(String beanId, Object bean) {
        beans.put(beanId, bean);
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
}
