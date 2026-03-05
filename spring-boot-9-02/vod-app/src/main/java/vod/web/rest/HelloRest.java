package vod.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRest {

    @GetMapping("/hello")
    String sayHello() { return "Hey Universe!"; }
}