package hello.springmvc.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.util.Strftime;
import org.apache.tomcat.jni.Local;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
public class RequestHeaderController {
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request, HttpServletResponse response, HttpMethod httpMethod, Local local, @RequestHeader MultiValueMap<String, String> headerMap,
                          ){

    }
}
