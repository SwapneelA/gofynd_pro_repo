package com.gofynd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoginController {
	@RequestMapping(value="/get")
	public ModelAndView getUploadPage()
	{
		return new ModelAndView("uploadFile");
	}
}
