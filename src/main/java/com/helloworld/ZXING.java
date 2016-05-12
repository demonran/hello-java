package com.tcl.helloworld;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class ZXING
{
	public static void main(String[] args) throws NotFoundException
	{
File file = new File("D://qrcodeImage.png");  
		
		BufferedImage image = null;
		
		try
		{
			image = ImageIO.read(file);
			
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LuminanceSource source = new BufferedImageLuminanceSource(image);
		
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
		
		Hashtable<DecodeHintType, String> hints = new Hashtable<DecodeHintType, String>();  
		  
        hints.put(DecodeHintType.CHARACTER_SET, "GBK");  
		
		 Result result = new MultiFormatReader().decode(bitmap,hints);  
		
		 System.out.println(new Date(result.getTimestamp()));
		
	}
}
