package com.singleton.model.simple;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * <p>
 * Simple {@link Person} proxy that always returns the same values.
 * </p>
 *
 * @author Dustin Singleton
 */
@SuppressWarnings({ "javadoc", "nls" })
public class SimplePersonProxyCreator
{
    private static final PersonHandler handler = new PersonHandler();

    public static Person createProxyPerson()
    {
        return (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[] { Person.class }, handler);
    }

    private static class PersonHandler implements InvocationHandler
    {
        @Override
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
