package br.com.otavioluism.ioc_di;

import org.springframework.stereotype.Service;

@Service
public class MeuComponente {

    public String chamarComponente(){
        return "Chamando meu componente";
    }
}
