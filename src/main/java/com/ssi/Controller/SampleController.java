package com.ssi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssi.Service.SampleService;

@RestController
public class SampleController {
	
	@Autowired
	private SampleService sampleService;
	
	@RequestMapping(value="/now")
//	@ResponseBody it is an old approach
	public String getCurretDateAndTime()
	{
		return sampleService.getServerTime();
	}

}
