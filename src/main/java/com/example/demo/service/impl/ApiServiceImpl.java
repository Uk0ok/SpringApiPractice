package com.example.demo.service.impl;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.service.ApiService;
import com.example.demo.vo.ApiVO;
import com.example.demo.vo.XtormVO;
import com.windfire.apis.asysConnectData;
import com.windfire.apis.asys.asysUsrElement;

/**
 * @packageName : com.java.example.vo
 * @fileName : ApiServiceImpl.java
 * @author : uk0ok
 * @version : 1.0
 * @date : 2023.04.26
 * @description : Api 서비스 구현
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022.04.26        uk0ok            최초 생성
 */
@Service
public class ApiServiceImpl implements ApiService{
    private asysConnectData conn = null;

	@Value("${xtorm.engineIp}")
    private String hostName;
    
    @Value("${xtorm.enginePort}")
    private int port;
    
    @Value("${xtorm.description}")
    private String description;
    
    @Value("${xtorm.engineId}")
    private String id;
    
    @Value("${xtorm.enginePw}")
    private String password;

	@Value("${xtorm.gateway}")
	private String gateway;

	@Autowired
	XtormVO xtormVO;
	ApiVO apiVO;

	@Override
	public String create(MultipartFile file, ApiVO apiVo) {
		asysConnectData conn = new asysConnectData(hostName, port, description, id, password);

		int count = apiVo.getCreateNumber();
		System.out.println("count : " + count);
        String result = "";
        asysUsrElement uePage = null;
        InputStream fileStream = null;
        
        for (int i = 0; i < count; i++) {
            uePage = new asysUsrElement(conn);
            uePage.m_descr = apiVo.getDescription();
            uePage.m_cClassId = apiVo.getCClassId();
            uePage.m_userSClass = apiVo.getUserClass();
            uePage.m_eClassId = apiVo.getEClassId();
            
            try {
                fileStream = file.getInputStream();
                int ret = uePage.create(gateway, fileStream, "", "");
                if (ret != 0) {
                    result = "Error, create stream, " + uePage.getLastError();
                }
                else { 
                    result = "Success, create stream, " + uePage.m_elementId;
                }
                System.out.println(result);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fileStream.close();
                    disconn();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return result;
	}

	@Override
	public String downlaod(String elementId) {
		asysConnectData conn = new asysConnectData(hostName, port, description, id, password);
		String result = "";
		asysUsrElement uePage = new asysUsrElement(conn);
		uePage.m_elementId = gateway + "::" + elementId + "::IMAGE ";
		int ret = uePage.getContent("temp/" + elementId);
		
		if (ret != 0) {
			result = "Error, download failed, " + uePage.getLastError();
		} else {
			result = "Success, download normal, " +  uePage.m_elementId;
		}
		System.out.println(result);
		disconn();
		
		return result;
	}

    @Override
    public String delete(String elementId) {
        asysConnectData conn = new asysConnectData(hostName, port, description, id, password);
		String result = "";
		asysUsrElement uePage = new asysUsrElement(conn);
        uePage.m_elementId = gateway + "::" + elementId + "::IMAGE ";
        int ret = uePage.delete();

        if (ret != 0) {
            result = "Error, delete failed, " + uePage.getLastError();
		} else {
            result = "Success, delete normal, " + uePage.m_elementId;
		}
        System.out.println(result);
        disconn();

        return result;
    }

	public void disconn() {
        if (conn != null) {
			conn.close();
			conn = null;
		}
    }
}
