package com.singleton.model.simple;

/**
 * <p>
 * Consumer of a simple proxy class.
 * </p>
 *
 * @author Dustin Singleton
 */
@SuppressWarnings({ "javadoc" })
public class Consumer
{
    public static void main(String[] args)
    {
        Person person = SimplePersonProxyCreator.createProxyPerson();

        System.out.println(person.getName());
        System.out.println(person.getHairColor());
    }
}
