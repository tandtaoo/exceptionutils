package com.chashaotao.exceptionutils;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.Loader;
import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

import com.chashaotao.exceptionutils.error.ParameterException;

public class ExceptionInfoBaseTest {

	@Test
	public void testGetStackTrace() throws ParameterException 
	{
		try
		{
			int x1 = 1 / 0;
		}
		catch(Exception e)
		{
			ExceptionInfoBase eib = new ExceptionInfoBase();
			String stackTraceInfo = eib.getStackTrace(e);
			int index = stackTraceInfo.indexOf("by zero");
			assertTrue("is string", index > 0);
			System.out.println(stackTraceInfo);
		}
	}

	@Test
	public void testGetStackTrace2() throws ParameterException 
	{
		try
		{
			int x1 = 1 / 0;
		}
		catch(ArithmeticException e)
		{
			Logger logger = Logger.getLogger(ExceptionInfoBaseTest.class);
			ExceptionInfoBase eib = new ExceptionInfoBase();
			String stackTraceInfo = eib.getStackTrace(e);
			int index = stackTraceInfo.indexOf("by zero");
			assertTrue("is string", index > 0);
			System.out.println(stackTraceInfo);
			logger.info(stackTraceInfo);
		}
	}

	@Test(expected = ParameterException.class)
	public void testGetStackTraceErrorParam() throws ParameterException 
	{
		try
		{
			int x1 = 1 / 0;
		}
		catch(ArithmeticException e)
		{
			Logger logger = Logger.getLogger(ExceptionInfoBaseTest.class);
			ExceptionInfoBase eib = new ExceptionInfoBase();
			String stackTraceInfo = eib.getStackTrace(null);
			int index = stackTraceInfo.indexOf("by zero");
			assertTrue("is string", index > 0);
			System.out.println(stackTraceInfo);
			logger.info(stackTraceInfo);
		}
	}
}
