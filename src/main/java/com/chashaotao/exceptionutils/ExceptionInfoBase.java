/*
 * 
 */
package com.chashaotao.exceptionutils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.chashaotao.exceptionutils.error.ParameterException;
import com.chashaotao.exceptionutils.exceptioninfo.inter.IExceptionInfoBase;

public class ExceptionInfoBase implements IExceptionInfoBase{

	/**
	 * 用来提取异常对象中的异常信息，并且返回
	 * 
	 * @param e 需要提取的异常对象
	 * @return 返回异常信息
	 * @exception ParameterException 如果传入的参数不是Exception类型将抛出
	 */
	public String getStackTrace(Exception e) throws ParameterException
	{
		if (e instanceof Exception)
		{
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintStream s = new PrintStream(baos);
			e.printStackTrace(s);
			return baos.toString();
		}
		else
		{
			throw new ParameterException(ParameterException.PARAM_ERROR);
		}
	}

}
