package com.tcl.helloworld.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUitls
{
	public static String read(File file)
	{
		try
		{
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"gbk"));
			
			String buf ;
			StringBuffer sb = new StringBuffer();
			while ((buf = br.readLine())!= null)
			{
				sb.append(buf);
			}
			br.close();
			return sb.toString();
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
}
