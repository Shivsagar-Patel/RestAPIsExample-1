package com.ssi.Service;

import org.springframework.stereotype.Service;

@Service
public class SampleService {
	public String getServerTime()
	{
		return new java.util.Date().toString();
	}

}
