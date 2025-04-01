package br.com.otavioluism.api_spring_boot;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firstController")
public class FirstController {

    @GetMapping("/")
    public String firstFunctionController() {
        return "Hello bati aqui na api agora!";
    }

}
