package com.singleton.model.arguments;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

@SuppressWarnings({ "javadoc", "nls" })
public class ArgumentPersonProxyCreator
{
    public static Person createProxyPerson(String name, Map<Person.RelativeType, String> relatives)
    {
        PersonHandler handler = new PersonHandler(name, relatives);

        return (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class<?>[] { Person.class }, handler);
    }

    private static class PersonHandler implements InvocationHandler
    {
        private final String name;
        private final Map<Person.RelativeType, String> relatives;

        public PersonHandler(String name, Map<Person.RelativeType, String> relatives)
        {
            this.name = name;
            this.relatives = relatives;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
        {
            switch (method.getName())
            {
                case "getName":
                    return name;
                case "getRelativeName":
                    return getRelativeName(args);

            }

            return null;
        }

        private Object getRelativeName(Object[] args)
        {
            if (args.length != 1)
            {
                return null; // or throw error?
            }
            
            Person.RelativeType relativeType = (Person.RelativeType) args[0];
            return relatives.get(relativeType);
        }
    }
}