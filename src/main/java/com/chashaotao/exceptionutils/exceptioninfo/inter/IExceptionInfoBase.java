package com.chashaotao.exceptionutils.exceptioninfo.inter;

import com.chashaotao.exceptionutils.error.ParameterException;

public interface IExceptionInfoBase {
	public String getStackTrace(Exception e) throws ParameterException;
}
