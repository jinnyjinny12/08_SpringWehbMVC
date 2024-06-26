package com.ohgiraffers.chap01requestmapping;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/*
* 클래스 레벨에 @RequestMapping 어노테이션 사용이 가능하다
* 클레스 레벨에 url을 공통 부분을 이용해 설정하고 나면 매번 핸드럴 메소드에 url의 중복되는 내용은 작성되지 않아도 된다
* 이 때 와일드 카드를 이용해서 조금 더 포괄적인 url 패턴을 설정할 수 있다.
* */

//classMappingTestController
//controller: 사용자가 요청을 하면 그걸 처리해줌 이걸 스프링측에서 관리를 함?
// 하나의 객체 -> 우리는 그걸 빈이라고 부름, 빈의 이름을 명시함
// RestController는 http://localhost:8000/orders 이렇게 쓰면 hellow 뜸


// 리퀘스트 어노테이션은 네임을 생략할 수 있다
@Controller
@RequestMapping("/orders/*")
public class ClassMappingTestController {

    @GetMapping("/resgist")
    public String resgistOrder(Model model){
        model.addAttribute("message","get 방식의 주문 등록용 핸들로 메소드를 호출함");
        return "mappingResult";
    }

    // 여러 개의 패턴 매핑
    // value 속성이 중괄호를 이용해 매핑할 url을 나열한다
    @RequestMapping(value = {"modify","delete"}, method = RequestMethod.POST)
    public String modifyAndDelete(Model model){
        model.addAttribute("message","post방식의 주문 정보 수정과 주문 정보 삭제 공통 처리용 핸들러 메소드 호출함");
        return "mappingResult";
    }

}
