package com.iemr.admin.utils.exception;

public class SwyMedException extends Exception
{
	private static final long serialVersionUID = 1L;
	private String message = null;

	public SwyMedException(String message, Throwable cause)
	{
		super(message);
		this.message = message;
		super.setStackTrace(cause.getStackTrace());
	}

	public SwyMedException(String message)
	{
		super(message);
		this.message = message;
	}

	public String toString()
	{
		return this.message;
	}

	public String getMessage()
	{
		return this.message;
	}
}
