package com.hellojava.json;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;




public class TestRederFromIS
{
	public static void main(String[] args) throws JsonProcessingException, FileNotFoundException, IOException
	{
		TestRederFromIS test = new TestRederFromIS();
		
		test.testJson();
		
	}
	
	private void testJson() throws JsonGenerationException, JsonMappingException, IOException
	{
		List<Dog> persons = createPersions();
		ObjectMapper mapper = new ObjectMapper();
		String  jsonString = mapper.writeValueAsString(persons);
		System.out.println(jsonString);
		List<Dog> persons1 = mapper.readValue(jsonString, new TypeReference<List<Dog>>()
		{});
		System.out.println(persons1.get(0) instanceof Dog);
	}
	
	private List<Dog> createPersions()
	{
		List<Dog> persons = new ArrayList<Dog>();
		Dog p1 = new Dog();
//		Person p2 = new Person("zhang1",21);
//		Person p3 = new Person("zhang3",31);
		persons.add(p1);
//		persons.add(p2);
//		persons.add(p3);
		return persons;
	}
	@JsonIgnoreProperties(ignoreUnknown = true)
	class Person {
		private String name;
		private int age;
		
		
//		public Person(String name, int age)
//		{
//			this.name = name;
//			this.age = age;
//		}
		public String getName()
		{
			return name;
		}
		public void setName(String name)
		{
			this.name = name;
		}
		public int getAge()
		{
			return age;
		}
		public void setAge(int age)
		{
			this.age = age;
		}
		
	}
}
