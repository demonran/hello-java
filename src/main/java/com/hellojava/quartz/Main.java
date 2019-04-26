package com.hellojava.quartz;

public class Main {
	
	public static void main(String[] args) throws InterruptedException {
		new ScheduleManager().initialize();;
		
		Thread.sleep(300000);
	}
}
