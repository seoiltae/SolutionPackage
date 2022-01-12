package com.project.solutionpackage.model;

import lombok.Data;

@Data
public class Insert_DB_UserInfo_Model {

    /**
     * [클래스 설명]
     * 1. insert 포맷 형태 정의 클래스
     * 2. controller 에서 사용한다
     * */

    private String idx;
    private String name;
    private String sex;
    private String age;
    private String dept;
    private String phone;
    private String addr;
    private String rank;
    private String marri;
    private String famlly;
    private String hobby;

}
