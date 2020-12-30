package helloword;

import org.junit.Test;

public class HelloWorldTest
{
	@Test
	public void testSayHello()
	{
		String inputPath = "/rkit/cloud/tmp_data/new_result_001.mp4";
		System.out.println(inputPath.split("/")[2]);
	}
}
