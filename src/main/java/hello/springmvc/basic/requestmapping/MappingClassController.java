package hello.springmvc.basic.requestmapping;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mapping/users")
public class MappingClassController {

    @GetMapping
    public String user(){
        return "get user";
    }

    @PostMapping
    public String addUser(){
        return "post user";
    }

    @GetMapping("/{userId}")
    public String findUser(@PathVariable String userId){
        return ("Get Id="+userId);
    }

    @PatchMapping("/{userId}")
    public String updateUser(@PathVariable String userId){
        return "updateUser user{}"+userId;
    }

    @DeleteMapping("/{userId}")
    public String DelUser(@PathVariable String userId){
        return "DelUser user{}"+userId;
    }
}
