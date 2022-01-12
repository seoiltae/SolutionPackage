package com.project.solutionpackage.controller;

import com.project.solutionpackage.model.Insert_DB_UserInfo_Model;
import com.project.solutionpackage.model.Return_DB_Json_Model;
import com.project.solutionpackage.service.DBService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

// 로그
@SuppressWarnings("ALL")
@Slf4j
//log.debug("[response] : {}", new Return_DB_Json_Model("T", dbService.date()));

// rest 방식 컨트롤러 / Controller = view 연결
@RestController
public class DBApiController {

    /**
     * [클래스 설명]
     * 1. api 호출 경로 및 리턴 데이터 반환 실시
     * 2. 실제로 api 호출 (req) 및 반환 (res) 이루어지는 클래스
     * */


    // [service 설정 : 로직 연결 위함]
    // [로직 : 사용자 API 호출 >> 컨트롤러에서 서비스 호출 >> 서비스에서 DB Mapper 호출]
    @Autowired
    private DBService dbService;


    // [root 경로 지정]
    /*@GetMapping("/")
    public JsonModel root() {
        return new JsonModel(0, "루트페이지 입니다.");
    }*/


    // [get : Map 방식]
    // [경로 지정 : http://localhost:7000/date]
    // [input : 서비스에서 설정한 파라미터 개수와 같아야합니다]
    // [output : 모델에서 설정한 return 타입으로 결과를 반환합니다]
    @GetMapping("/date")
    public Return_DB_Json_Model date() {
        System.out.println();
        System.out.println("[DBApiController] : [date]");
        System.out.println("");

        System.out.println("");
        System.out.println("[DBApiController] : [date]");
        System.out.println("[response] : " + new Return_DB_Json_Model("T", dbService.date()));
        System.out.println("");
        return new Return_DB_Json_Model("T", dbService.date());
    }


    // [post : Map 방식]
    // [경로 지정 : http://localhost:7000/userInfo?idx=5]
    // [input : 서비스에서 설정한 파라미터 개수와 같아야합니다]
    // [output : 조회된 데이터를 json 형식 string값으로 반환합니다]
    @PostMapping("/userInfo")
    public String userInfo(@RequestParam Map<String, String> param) {
        System.out.println("");
        System.out.println("[DBApiController] : [userInfo]");
        System.out.println("[request keySet] : " + String.valueOf(param.keySet()));
        System.out.println("[request idx] : " + String.valueOf(param.get("idx")));
        System.out.println("");

        // 리턴 값 데이터 정의
        String idx = param.get("idx");
        String result = String.valueOf(dbService.userInfo(idx));
        result = result.replaceAll("[=]", ":"); //json 형식으로 변환

        System.out.println("");
        System.out.println("[DBApiController] : [userInfo]");
        System.out.println("[response] : " + String.valueOf(result));
        System.out.println("");
        return result;
    }


    // [post : Map 방식]
    // [경로 지정 : http://localhost:7000/userInfoList?dept=백제&idx=5]
    // [input : 서비스에서 설정한 파라미터 개수와 같아야합니다]
    // [output : 조회된 데이터를 json 형식 string값으로 반환합니다]
    @PostMapping("/userInfoList")
    public String userInfoList(@RequestParam Map<String, String> param) {
        System.out.println("");
        System.out.println("[DBApiController] : [userInfoList]");
        System.out.println("[request keySet] : " + String.valueOf(param.keySet()));
        System.out.println("[request dept] : " + String.valueOf(param.get("dept")));
        System.out.println("[request idx] : " + String.valueOf(param.get("idx")));
        System.out.println("");

        // 리턴 값 데이터 정의
        String dept = param.get("dept");
        int idx = Integer.parseInt(param.get("idx"));
        String result = String.valueOf(dbService.userInfoList(dept, idx));
        result = result.replaceAll("[=]", ":"); //json 형식으로 변환

        System.out.println("");
        System.out.println("[DBApiController] : [userInfoList]");
        System.out.println("[response] : " + String.valueOf(result));
        System.out.println("");
        return result;
    }


    // [post : Map 방식]

    // [경로 지정 : http://localhost:7000/insertUser?idx=61&name=towk&sex=m&age=28&dept=개발부&phone=01012345678&addr=서울&rank=연구원&marri=x&familly=5&hobby=코딩]
    // [input : 서비스에서 설정한 파라미터 개수와 같아야합니다]
    // [output : 모델에서 설정한 return 타입으로 결과를 반환합니다]
    @PostMapping("/insertUser")
    public Return_DB_Json_Model insertUser(Insert_DB_UserInfo_Model user) {
        System.out.println("");
        System.out.println("[DBApiController] : [insertUser]");
        System.out.println("[request idx] : " + String.valueOf(user.getIdx()));
        System.out.println("[request name] : " + String.valueOf(user.getName()));
        System.out.println("[request sex] : " + String.valueOf(user.getSex()));
        System.out.println("[request age] : " + String.valueOf(user.getAge()));
        System.out.println("[request dept] : " + String.valueOf(user.getDept()));
        System.out.println("[request phone] : " + String.valueOf(user.getPhone()));
        System.out.println("[request addr] : " + String.valueOf(user.getAddr()));
        System.out.println("[request rank] : " + String.valueOf(user.getRank()));
        System.out.println("[request marri] : " + String.valueOf(user.getMarri()));
        System.out.println("[request familly] : " + String.valueOf(user.getFamlly()));
        System.out.println("[request hobby] : " + String.valueOf(user.getHobby()));
        System.out.println("");

        if (dbService.insertUser(user) > 0) {
            System.out.println("");
            System.out.println("[DBApiController] : [insertUser]");
            System.out.println("[response] : " + new Return_DB_Json_Model("T", "Success"));
            System.out.println("");
            return new Return_DB_Json_Model("T", "Success"); //정상 삽입 완료 시 상태값 반환
        } else {
            System.out.println("");
            System.out.println("[DBApiController] : [insertUser]");
            System.out.println("[response] : " + new Return_DB_Json_Model("F", "Failed"));
            System.out.println("");
            return new Return_DB_Json_Model("F", "Failed"); //삽입 실패 시 상태값 반환
        }
    }


    // [post : Map 방식]
    // [경로 지정 : http://localhost:7000/updateUser?idx=100&name=towk]
    // [input : 서비스에서 설정한 파라미터 개수와 같아야합니다]
    // [output : 모델에서 설정한 return 타입으로 결과를 반환합니다]
    @PostMapping("/updateUser")
    public Return_DB_Json_Model updateUser(@RequestParam Map<String, String> param) {
        System.out.println("");
        System.out.println("[DBApiController] : [updateUser]");
        System.out.println("[request keySet] : " + String.valueOf(param.keySet()));
        System.out.println("[request idx] : " + String.valueOf(param.get("idx")));
        System.out.println("[request name] : " + String.valueOf(param.get("name")));
        System.out.println("");

        if (dbService.updateUser(Integer.parseInt(param.get("idx")), param.get("name")) > 0) {
            System.out.println("");
            System.out.println("[DBApiController] : [updateUser]");
            System.out.println("[response] : " + new Return_DB_Json_Model("T", "Success"));
            System.out.println("");
            return new Return_DB_Json_Model("T", "Success"); //정상 수정 완료 시 상태값 반환
        } else {
            System.out.println("");
            System.out.println("[DBApiController] : [updateUser]");
            System.out.println("[response] : " + new Return_DB_Json_Model("F", "Failed"));
            System.out.println("");
            return new Return_DB_Json_Model("F", "Failed"); //수정 실패 시 상태값 반환
        }
    }


    // [post : Map 방식]
    // [경로 지정 : http://localhost:7000/deleteUser?name=twok]
    // [input : 서비스에서 설정한 파라미터 개수와 같아야합니다]
    // [output : 모델에서 설정한 return 타입으로 결과를 반환합니다]
    @PostMapping("/deleteUser")
    public Return_DB_Json_Model deleteUser(@RequestParam Map<String, String> param) {
        System.out.println("");
        System.out.println("[DBApiController] : [deleteUser]");
        System.out.println("[request keySet] : " + String.valueOf(param.keySet()));
        System.out.println("[request name] : " + String.valueOf(param.get("name")));
        System.out.println("");

        if (dbService.deleteUser(param.get("name")) > 0) {
            System.out.println("");
            System.out.println("[DBApiController] : [deleteUser]");
            System.out.println("[response] : " + new Return_DB_Json_Model("T", "Success"));
            System.out.println("");
            return new Return_DB_Json_Model("T", "Success"); //정상 수정 완료 시 상태값 반환
        } else {
            System.out.println("");
            System.out.println("[DBApiController] : [deleteUser]");
            System.out.println("[response] : " + new Return_DB_Json_Model("F", "Failed"));
            System.out.println("");
            return new Return_DB_Json_Model("F", "Failed"); //수정 실패 시 상태값 반환
        }
    }


    // [post : Map 방식]
    // [경로 지정 : http://localhost:7000/userProcedure?dept=백제]
    // [input : 서비스에서 설정한 파라미터 개수와 같아야합니다]
    // [output : 조회된 데이터를 json 형식 string값으로 반환합니다]
    @PostMapping("/userProcedure")
    public String userProcedure(@RequestParam Map<String, String> param) {
        System.out.println("");
        System.out.println("[DBApiController] : [userProcedure]");
        System.out.println("[request keySet] : " + String.valueOf(param.keySet()));
        System.out.println("[request dept] : " + String.valueOf(param.get("dept")));
        System.out.println("");

        // 리턴 값 데이터 정의
        String dept = param.get("dept");
        Map map = dbService.userProcedure(dept);

        System.out.println("");
        System.out.println("[DBApiController] : [userProcedure]");
        System.out.println("[Map keySet] : " + String.valueOf(map.keySet()));
        System.out.println("[Map msg] : " + String.valueOf(map.get("msg")));
        System.out.println("[Map cur] : " + String.valueOf(map.get("cur")));
        System.out.println("");
        String O_MSG = String.valueOf(map.get("msg"));
        String O_CURSOR = String.valueOf(map.get("cur"));

        String result = String.valueOf(O_CURSOR);
        result = result.replaceAll("[=]", ":"); //json 형식으로 변환
        System.out.println("");
        System.out.println("[DBApiController] : [userProcedure]");
        System.out.println("[response] : " + String.valueOf(result));
        System.out.println("");
        return result;
    }

}
