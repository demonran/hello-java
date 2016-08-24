package com.helloworld;

import java.util.Random;



public class HelloWorld  {
	
	
	public static void main(String[] args) {
		
		Random random = new Random();
		short s =(short)random.nextInt();
		
		System.out.println(s);
		byte[] arr = new byte[2];
		arr[0] = (byte)(s>>8 & 0xff);
		arr[1] = (byte)(s & 0xff);
		
		System.out.println(Integer.toBinaryString(s));
		System.out.println(Integer.toBinaryString(arr[0])+Integer.toBinaryString(arr[1]));
		
		System.out.println((arr[0] <<8 )| (arr[1] & 0xff));
	}


}
