package com.chashaotao.exceptionutils.error;

public class ParameterException extends Exception{
	private static final long serialVersionUID = -9090148263893200140L;
	
	public static final String PARAM_ERROR = "参数错误";
	
	public ParameterException()
	{
		super(ParameterException.PARAM_ERROR);
	}
	
	public ParameterException(String msg)
	{
		super(msg);
	}
}
