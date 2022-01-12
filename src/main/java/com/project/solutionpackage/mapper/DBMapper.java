package com.project.solutionpackage.mapper;

import com.project.solutionpackage.model.Insert_DB_UserInfo_Model;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface DBMapper {

    /**
     * [클래스 설명]
     * 1. DBMapper.xml 쿼리 조회 결과 >> DB 데이터를 담을 그릇
     * 2. service 에서 참조해서 사용한다
     * */


    // [DBMapper.xml 쿼리에서 선언한 변수 개수 및 타입에 맞게 파라미터 선언]
    String date(); // 리턴값으로 string 사용 [출력]


    // [DBMapper.xml 쿼리에서 선언한 변수 개수 및 타입에 맞게 파라미터 선언]
    List<Map<String, Object>> userInfo(String idx); // 리턴값으로 List 사용 [출력]


    // [DBMapper.xml 쿼리에서 선언한 변수 개수 및 타입에 맞게 파라미터 선언]
    List<Map<String, Object>> userInfoList(String dept, int idx); // 리턴값으로 List 사용 [출력]


    // [DBMapper.xml 쿼리에서 선언한 변수 개수 및 타입에 맞게 파라미터 선언]
    int insertUser(Insert_DB_UserInfo_Model user); // 리턴값으로 int 사용 [상태값 확인 성공, 실패 여부]


    // [DBMapper.xml 쿼리에서 선언한 변수 개수 및 타입에 맞게 파라미터 선언]
    int updateUser(int idx, String name); // 리턴값으로 int 사용 [상태값 확인 성공, 실패 여부]


    // [DBMapper.xml 쿼리에서 선언한 변수 개수 및 타입에 맞게 파라미터 선언]
    int deleteUser(String name); // 리턴값으로 int 사용 [상태값 확인 성공, 실패 여부]


    // [DBMapper.xml 쿼리에서 선언한 변수 개수 및 타입에 맞게 파라미터 선언]
    void userProcedure(Map map); // void 설정

}
