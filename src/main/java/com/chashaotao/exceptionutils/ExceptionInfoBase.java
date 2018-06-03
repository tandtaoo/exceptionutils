package com.chashaotao.exceptionutils;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.chashaotao.exceptionutils.error.ParameterException;
import com.chashaotao.exceptionutils.exceptioninfo.inter.IExceptionInfoBase;

public class ExceptionInfoBase implements IExceptionInfoBase{

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
