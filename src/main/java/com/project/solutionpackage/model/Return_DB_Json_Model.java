package com.project.solutionpackage.model;

import lombok.Data;

@Data
public class Return_DB_Json_Model {

    /**
     * [클래스 설명]
     * 1. 최종적으로 반환할 데이터 포맷 형태 정의 클래스
     * 2. controller 에서 사용한다
     * */

    // [현재 date 확인]
    private String state;
    private String message;

    public Return_DB_Json_Model(String state, String message) {
        this.state = state;
        this.message = message;
    }

}
