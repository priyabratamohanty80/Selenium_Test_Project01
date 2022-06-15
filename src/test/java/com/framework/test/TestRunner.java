package com.framework.test;

import org.testng.TestNG;

public class TestRunner {
	
	static TestNG testNg;
	
	public static void main(String[] args)
	{
		testNg = new TestNG();
		
		testNg.setTestClasses(new Class[] {TC_01.class});
		testNg.run();
	}

}
