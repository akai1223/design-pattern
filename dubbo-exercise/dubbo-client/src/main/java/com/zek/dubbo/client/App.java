package com.zek.dubbo.client;

import com.zek.dubbo.api.IHelloDubbo;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-client.xml");

        IHelloDubbo iHelloDubbo = (IHelloDubbo) context.getBean("iHelloDubbo");

        System.out.println(iHelloDubbo.sayHello("zek"));
    }
}
