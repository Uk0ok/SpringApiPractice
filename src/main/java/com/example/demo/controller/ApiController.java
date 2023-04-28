package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
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

	@ResponseBody
	@RequestMapping(value = "/download", method = RequestMethod.POST)
	public void download(@RequestBody String elementId) {
		System.out.println("download Api Start ... ");
		apiService.downlaod(elementId);
		System.out.println("End download Api ... ");
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete() {
		
		return "/api/delete";
	}

	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public void delete(@RequestBody String elementId) {
		System.out.println("delete Api Start ... ");
		apiService.delete(elementId);
		System.out.println("End delete Api ... ");
	}
}
