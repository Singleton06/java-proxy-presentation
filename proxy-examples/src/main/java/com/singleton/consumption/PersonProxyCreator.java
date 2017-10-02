package com.singleton.consumption;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.singleton.model.Person;

/**
 * <p>
 *
 * </p>
 *
 * @author Dustin Singleton
 */
public class PersonProxyCreator
{
    private static final PersonHandler handler = new PersonHandler();

    public static Person createProxyPerson()
    {
        Person person = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[] { Person.class },
                handler);
        return person;
    }

    private static class PersonHandler implements InvocationHandler
    {
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
        {
            switch (method.getName())
            {
                case "getName":
                    return "Dustin";
                case "getHairColor":
                    return "Brown";
            }

            return null;
        }
    }
}
