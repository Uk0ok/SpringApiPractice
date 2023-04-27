package com.example.demo.service;

import org.springframework.web.multipart.MultipartFile;

import com.example.demo.vo.ApiVO;

/**
 * @packageName : com.java.example.vo
 * @fileName : ApiService.java
 * @author : uk0ok
 * @version : 1.0
 * @date : 2023.04.26
 * @description : Api 서비스 interface
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022.04.26        uk0ok            최초 생성
 */
public interface ApiService {
	public String create(MultipartFile file, ApiVO apiVo);
	public String downlaod(String elementId);
}
