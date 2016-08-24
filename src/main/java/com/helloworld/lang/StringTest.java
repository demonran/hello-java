package com.helloworld.lang;

public class StringTest
{
	public static void main(String[] args)
	{
		String org = "C:/dispatcher_test/tmpDir/1430270948472_fab7c8d4-3c4b-4e3c-b7e2-59b2c2fe6dc7/hls/index.m3u8";
		String regex = "C:/dispatcher_test/tmpDir/1430270948472_fab7c8d4-3c4b-4e3c-b7e2-59b2c2fe6dc7/hls/";
		String replacement = "/rstudio-ali/test1/hls/";
		System.out.println(org.replaceFirst(regex, replacement));
	}
}
