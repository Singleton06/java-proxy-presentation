package com.singleton.model.dynamic;

/**
 * <p>
 * Consumer of a simple proxy class.
 * </p>
 *
 * @author Dustin Singleton
 */
@SuppressWarnings({ "javadoc", "nls" })
public class Consumer
{
    public static void main(String[] args)
    {
        Person person = DynamicPersonProxyCreator.createProxyPerson("Dustin", "Brown");
        Person person2 = DynamicPersonProxyCreator.createProxyPerson("Jennifer", "Brown");

        System.out.println(person.getName());
        System.out.println(person.getHairColor());
        System.out.println(person2.getName());
        System.out.println(person2.getHairColor());
    }
}
