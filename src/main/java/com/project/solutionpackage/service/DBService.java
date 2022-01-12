package com.project.solutionpackage.service;

import com.project.solutionpackage.mapper.DBMapper;
import com.project.solutionpackage.model.Insert_DB_UserInfo_Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DBService {

    /**
     * [클래스 설명]
     * 1. DBMapper 인터페이스 호출 및 controller 에 반환 할 리턴 값 정의
     * 2. controller 에서 사용한다
     * */

    // [DBMapper 인터페이스 설정 : db 데이터 참조 [DBMapper.xml]]
    @Autowired
    private DBMapper dbMapper;


    // [DBMapper 인터페이스 지정 >> DBApiController 리턴 값 지정]
    public String date() {
        return dbMapper.date(); //컨트롤러에 리턴 실시
    }


    // [DBMapper 인터페이스 지정 >> DBApiController 리턴 값 지정]
    public List<Map<String, Object>> userInfo(String idx) {
        List<Map<String, Object>> result = dbMapper.userInfo(idx);
        return result; //컨트롤러에 리턴 실시
    }


    // [DBMapper 인터페이스 지정 >> DBApiController 리턴 값 지정]
    public List<Map<String, Object>> userInfoList(String dept, int idx) {
        List<Map<String, Object>> result = dbMapper.userInfoList(dept, idx);
        return result; //컨트롤러에 리턴 실시
    }


    // [DBMapper 인터페이스 지정 >> DBApiController 리턴 값 지정]
    public int insertUser(Insert_DB_UserInfo_Model user) {
        return dbMapper.insertUser(user); //컨트롤러에 리턴 실시
    }


    // [DBMapper 인터페이스 지정 >> DBApiController 리턴 값 지정]
    public int updateUser(int idx, String name) {
        return dbMapper.updateUser(idx, name); //컨트롤러에 리턴 실시
    }


    // [DBMapper 인터페이스 지정 >> DBApiController 리턴 값 지정]
    public int deleteUser(String name) {
        return dbMapper.deleteUser(name); //컨트롤러에 리턴 실시
    }


    // [DBMapper 인터페이스 지정 >> DBApiController 리턴 값 지정]
    public Map userProcedure(String dept) {
        Map map = new HashMap<>();
        map.put("dept", dept);
        dbMapper.userProcedure(map);
        return map; //컨트롤러에 리턴 실시
    }

}
