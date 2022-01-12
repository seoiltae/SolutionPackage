package com.project.solutionpackage.controller;

import com.project.solutionpackage.model.Return_DB_Json_Model;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Map;

// rest 방식 컨트롤러 / Controller = view 연결
@Controller
public class ThymeLeafController {

    /**
     * [클래스 설명]
     * 1. thymeleaf 타임리프 view 지정 부분 (html 지정)
     * */


    // [get 방식 : 일반 호출 방식]
    // [경로 지정 : http://localhost:7000/testThymeleafOne]
    // [get 로직 : pTag 라는 key에 hello 값을 담아서 testThymeleaf.html로 리턴합니다]
    // [html 로직 : testThymeleaf.html은 리턴 받은 pTag key 값을 불러와서 데이터를 표시해줍니다]
    @GetMapping("/testThymeleafOne")
    public String testThymeleafOne(Model model){
        System.out.println("");
     //   System.out.println("[DBApiController] : [testThymeleafOne]");
        System.out.println("");

        //html에 반환할 key, value 지정 실시
        model.addAttribute("pTag", "hello");
        return "testThymeleaf"; //testThymeleaf.html 호출
    }


    // [get 방식 : 파라미터 받는 방식]
    // [경로 지정 : http://localhost:7000/testThymeleafTwo?name=투케이]
    // [get 로직 : pTag 라는 key에 파라미터 값으로 들어온 데이터를 넣어서 testThymeleaf.html로 리턴합니다]
    // [html 로직 : testThymeleaf.html은 리턴 받은 pTag key 값을 불러와서 데이터를 표시해줍니다]
    @GetMapping("/testThymeleafTwo")
    public String testThymeleafTwo(@RequestParam Map<String, String> param, Model model){
        //input으로 들어온 파라미터 데이터 확인 실시
        System.out.println("");
        System.out.println("[DBApiController] : [testThymeleafTwo]");
        System.out.println("[request keySet] : " + String.valueOf(param.keySet()));
        System.out.println("[request name] : " + String.valueOf(param.get("name")));
        System.out.println("");

        //html에 반환할 key, value 지정 실시
        model.addAttribute("pTag", String.valueOf(param.get("name"))); //일반 key, value
        return "testThymeleaf"; //testThymeleaf.html 호출
    }


    // [get 방식 : 파라미터 받은 후 객체 매핑 방식]
    // [경로 지정 : http://localhost:7000/testThymeleafThree?idx=1&name=투케이]
    // [get 로직 : pTag 라는 key에 파라미터 값으로 들어온 데이터를 model 객체에 매핑해 testThymeleaf.html로 리턴합니다]
    // [html 로직 : testThymeleaf.html은 리턴 받은 pTag key 값을 불러와서 데이터를 표시해줍니다]
    @GetMapping("/testThymeleafThree")
    public String testThymeleafThree(@RequestParam Map<String, String> param, Model model){
        //input으로 들어온 파라미터 데이터 확인 실시
        System.out.println("");
        System.out.println("[DBApiController] : [testThymeleafThree]");
        System.out.println("[request keySet] : " + String.valueOf(param.keySet()));
        System.out.println("[request idx] : " + String.valueOf(param.get("idx")));
        System.out.println("[request name] : " + String.valueOf(param.get("name")));
        System.out.println("");

        //html에 객체 지정 실시
        String idx = String.valueOf(param.get("idx"));
        String name = String.valueOf(param.get("name"));

        Return_DB_Json_Model return_db_json_model = new Return_DB_Json_Model(idx, name); //모델 객체에 데이터 지정

        model.addAttribute("pTag", return_db_json_model); //value 값에 객체를 지정
        return "testThymeleaf"; //testThymeleaf.html 호출
    }

}
