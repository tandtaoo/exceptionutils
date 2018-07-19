package com.chashaotao.exceptionutils;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.Loader;
import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;

import com.chashaotao.exceptionutils.error.ParameterException;

public class ExceptionInfoBaseTest {

	/**
	 * 测试ExceptionInfoBase类是否可以将Exception错误中的信息
	 * 提取出来，并且显示在控制台
	 * @throws ParameterException
	 */
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
			System.out.println("==================1");
		}
	}

	/**
	 * 测试ExceptionInfoBase类是否可以将Exception错误中的信息
	 * 提取出来，并且显示在控制台，并且用log4j输出到文件
	 * @throws ParameterException
	 */
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
			System.out.println("==================2");
			logger.info(stackTraceInfo);
		}
	}

	/**
	 * 测试ExceptionInfoBase的getStackTrace方法，传入非法参数是否报错
	 * @throws ParameterException
	 */
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
			System.out.println("==================3");
			logger.info(stackTraceInfo);
		}
	}
}
