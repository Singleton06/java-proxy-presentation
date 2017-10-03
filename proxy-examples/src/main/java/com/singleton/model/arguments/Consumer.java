package com.singleton.model.arguments;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({ "javadoc", "nls" })
public class Consumer
{
    public static void main(String[] args)
    {
        Map<Person.RelativeType, String> relatives = new HashMap<>();
        relatives.put(Person.RelativeType.MOTHER, "Debbie");
        relatives.put(Person.RelativeType.SPOUSE, "Jennifer");
        
        Person p = ArgumentPersonProxyCreator.createProxyPerson("Dustin", relatives);
        
        System.out.println("Spouse: " + p.getRelativeName(Person.RelativeType.SPOUSE));
        System.out.println("Mother: " + p.getRelativeName(Person.RelativeType.MOTHER));
    }
}
