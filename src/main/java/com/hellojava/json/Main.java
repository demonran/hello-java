package com.hellojava.json;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class Main
{
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException,
			IOException
	{
		ObjectMapper mapper = new ObjectMapper();
		TypeFactory typeFactory = mapper.getTypeFactory();
		List<Map<String,String>> list = mapper.readValue(
				Main.class.getClassLoader().getResourceAsStream("sample.json"), typeFactory.constructCollectionType(List.class,typeFactory.constructMapType(Map.class, String.class, Object.class) ));
		System.out.println(list);
		for (Map jsonNode : list)
		{	
			
			// jsonNode.
			// jsonNode.put("a", 111);
			System.out.println(jsonNode.get("probs"));
		}
	}
}
