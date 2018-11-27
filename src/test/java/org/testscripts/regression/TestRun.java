package org.testscripts.regression;

import org.generic.GenericFunctions;

public class TestRun 
{

	public static void main(String[] args)
	{
	String numb = GenericFunctions.testDataIncrementer("./TestData/lessonPlan.txt");
	System.out.println(numb);
	}
}
