package br.com.otavioluism.controller;


import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/firstController")
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

}
