package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.ApiService;
import com.example.demo.vo.ApiVO;

/**
 * @packageName : com.java.example.vo
 * @fileName : ApiController.java
 * @author : uk0ok
 * @version : 1.0
 * @date : 2023.04.26
 * @description : Api 하위 메뉴 컨트롤러
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022.04.26        uk0ok            최초 생성
 */
@Controller
@RequestMapping(value = "/api")
public class ApiController {
	@Autowired
    ApiService apiService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create() {

		return "/api/create";
	}

	@ResponseBody
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void create(@RequestParam(value = "file") MultipartFile file , @ModelAttribute ApiVO apiVo) {

		System.out.println("createApi Start ... ");
		apiService.create(file, apiVo);
		System.out.println("End createApi ... ");
	}

	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public String download() {
		
		return "/api/download";
	}

	@RequestMapping(value = "/download", method = RequestMethod.POST)
	public void download(String elementId) {
		
		System.out.println("downloadApi Start ... ");
		apiService.downlaod(elementId);
		System.out.println("End downloadApi ... ");
	}
}
