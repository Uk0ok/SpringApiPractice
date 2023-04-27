package com.example.demo.vo;

import lombok.Data;

/**
 * @packageName   : com.java.example.vo
 * @fileName      : ApiVO.java
 * @author        : uk0ok
 * @version       : 1.0
 * @date          : 2023.04.26
 * @description   : api에 사용하기 위한 VO
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022.04.26        uk0ok            최초 생성
 */
@Data
public class ApiVO {
	private String description;
    private String cClassId;
    private String userClass;
    private String eClassId;
}
