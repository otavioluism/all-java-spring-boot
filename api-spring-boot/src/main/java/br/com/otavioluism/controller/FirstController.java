package br.com.otavioluism.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/primeiroController")
public class FirstController {

    @GetMapping("/primeiroMetodo/{ID}")
    public String firstFunctionController(@PathVariable(name = "ID") String id) {
        return "O parâmetro é " + id;
    }

    @GetMapping("/metodoComQueryParams")
    public String metodoComQueryParams(@RequestParam(name = "teste") String id){
        return "O paramétro com metodoComQueryParams é " + id;
    }

    @GetMapping("/metodoComQueryParams2")
    public String metodoComQueryParams(@RequestParam Map<String, String> allParams){
        System.out.println(allParams);
        return "O paramétro com metodoComQueryParams2 é " + allParams.entrySet();
    }

    @PostMapping("/metodoComQueryBody")
    public String metodoComBodyParams(@RequestBody Object body) {
        return "Parametro com bodyParams é " + body;
    }

    @PostMapping("/metodoComQueryBody2")
    public String metodoComBodyParams(@RequestBody User user) {
        return "Parametro com o valor do bodyParams é " + user.username;
    }

    record User(String username){}

    @PostMapping("/metodoComHeaders")
    public String metodoComQueryHeader(@RequestHeader(name = "name") String name) {
        return "Parâmetro com o valor de headers é " + name;
    }

    @PostMapping("/metodoComHeaders2")
    public String metodoComQueryHeader(@RequestHeader Map<String, String> allHeaders) {
        System.out.println(allHeaders.entrySet());
        return "Parâmetro com o valor de headers é " + allHeaders.entrySet();
    }

    @GetMapping("/metodoComResponseEntity/{id}")
    public ResponseEntity<Object> metodoComResponseEntity(@PathVariable(name = "id") Integer id) {
        User user = new User("otavio teste");

        if (id > 5) {
            return ResponseEntity.status(HttpStatus.CREATED).body(user);
        }

        return ResponseEntity.badRequest().body("O número é menor do que 5");
    }
}
