package com.singleton.consumption;

import org.junit.Test;

import com.singleton.model.Person;

public class PersonProxyCreatorTest {
	@Test
	public void test() { 
		Person person = PersonProxyCreator.createProxyPerson();
		
		System.out.println(person.getName());
		System.out.println(person.getHairColor());
	}
}
