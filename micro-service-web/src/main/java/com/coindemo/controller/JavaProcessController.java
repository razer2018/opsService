package com.coindemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coindemo.common.model.ResponseData;
import com.coindemo.common.utils.ResponseUtil;
import com.coindemo.model.JavaProcess;
import com.coindemo.service.JavaProcessService;

@RestController
@RequestMapping("/ops")
public class JavaProcessController {
	
	@Autowired
	private JavaProcessService javaProcessService;
	
	@RequestMapping(value = "/getPid/{sysCode}", method = RequestMethod.GET)
	public ResponseData<JavaProcess> getPid(@PathVariable("sysCode") String sysCode) {
		JavaProcess pid = javaProcessService.getPid(sysCode);
		return ResponseUtil.wrapData(pid);
	}
	
	@RequestMapping(value = "/jstack", method = RequestMethod.GET)
	public String getjstack() {
		String jstack = javaProcessService.getjstack();
		return jstack;
	}
	
}
