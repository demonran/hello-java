package com.hellojava.json;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.springframework.core.MethodParameter;

public class Main
{
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException,
			IOException, NoSuchMethodException {
//		ObjectMapper mapper = new ObjectMapper();
//		TypeFactory typeFactory = mapper.getTypeFactory();
//		List<Map<String,String>> list = mapper.readValue(
//				Main.class.getClassLoader().getResourceAsStream("sample.json"), typeFactory.constructCollectionType(List.class,typeFactory.constructMapType(Map.class, String.class, Object.class) ));
//		System.out.println(list);
//		for (Map jsonNode : list)
//		{
//
//			// jsonNode.
//			// jsonNode.put("a", 111);
//			System.out.println(jsonNode.get("probs"));
//		}

//		Type genericInterface = StringList.class.getSuperclass().getGenericInterfaces()[0];
//		System.out.println(genericInterface instanceof ParameterizedType);
//		System.out.println(((ParameterizedType)genericInterface).getActualTypeArguments()[0].getClass());
//		System.out.println(list.getClass() instanceof Class);


		StringList list = new StringList();
		Method method = StringList.class.getMethod("onMessage", Message.class);
		Type[] genericParameterTypes = method.getGenericParameterTypes();
		for (Type type : genericParameterTypes) {
			System.out.println(type instanceof Class);
			System.out.println(((ParameterizedType)type).getActualTypeArguments()[0]);
		}


	}

	public static class StringList {



		public void onMessage(Message<Object> message) {

		}

	}

	public static class Message<T> {
		T data;
	}


}
