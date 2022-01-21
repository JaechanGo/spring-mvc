package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
@Controller
public class RequestParamController {

    @RequestMapping ("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("usesrName = {} , age= {}",username,age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
        @RequestParam("username") String Mname,
        @RequestParam("age") int Mage){
        log.info("username = {} , age= {}",Mname,Mage);
        return "ok";
    }


    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age){
        log.info("username = {} , age= {}",username,age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username,int age){
        log.info("username = {} , age= {}",username,age);
        return "ok";
    }

    /**
     * @RequestParam.required
     * /request-param -> username이 없으므로 예외
     *
     * 주의!
     * /request-param?username= -> 빈문자로 통과
     *
     * 주의!
     * /request-param
     * int age -> null을 int에 입력하는 것은 불가능, 따라서 Integer 변경해야 함(또는 다음에 나오는
    defaultValue 사용)
     */
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age) { //int 는 안됨 null이
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guset") String username,
            @RequestParam(required = false, defaultValue = "123") int age) { //int 는 안됨 null이

        log.info("username={}, age={}", username, age);
        return "ok";
    }


    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam(required = false,defaultValue = "hello") Map<String,String> map) { //int 는 안됨 null이

        log.info("username={}, age={}",map.get("username"),map.get("age"));
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/model-arribute-v1")
    public String modelAttributeV1(@RequestParam String username,@RequestParam int age){
        HelloData helloData = new HelloData();
        helloData.setAge(12);
        helloData.setUsername("kim");

        log.info("username = {} / age = {}",helloData.getUsername(),helloData.getAge());
        log.info("Hello Data = {}",helloData);
        return "ok";
    }
}
