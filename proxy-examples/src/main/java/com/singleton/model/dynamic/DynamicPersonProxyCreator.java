package com.singleton.model.dynamic;

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
public class DynamicPersonProxyCreator
{
    public static Person createProxyPerson(String name, String hairColor)
    {
        PersonHandler handler = new PersonHandler(name, hairColor);

        return (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[] { Person.class }, handler);
    }

    private static class PersonHandler implements InvocationHandler
    {
        private final String name;
        private final String hairColor;
        
        public PersonHandler(String name, String hairColor)
        {
            this.name = name;
            this.hairColor = hairColor;
        }
        
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
        {
            switch (method.getName())
            {
                case "getName":
                    return name;
                case "getHairColor":
                    return hairColor;
            }

            return null;
        }
    }
}
