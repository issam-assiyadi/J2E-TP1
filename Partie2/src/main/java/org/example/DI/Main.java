package org.example.DI;

import org.example.DI.BeanFactoryImpl;
import org.example.DI.DIContainer;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        DIContainer container = new DIContainer(new HashMap<>());
        container.setBeanFactory(new BeanFactoryImpl(container));
        container.writeBeansFromXML("src/main/resources/test.xml");

        ServiceA serviceA = (ServiceA) container.getBeans().get("serviceA");
        ServiceB serviceB = (ServiceB) container.getBeans().get("serviceB");

        System.out.println(serviceB.getC());
    }
}
