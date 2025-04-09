package br.com.otavioluism.ioc_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/componente")
public class MeuControllerComponent {

    @Autowired
    MeuComponente meuComponente; // Autowired faz uma injenção de dependência como se fosse fazer o new MeuComponente na classe, porém o spring que faz por baixo

    @GetMapping("/")
    public String chamandoComponenteController(){
        return meuComponente.chamarComponente();
    }
}
