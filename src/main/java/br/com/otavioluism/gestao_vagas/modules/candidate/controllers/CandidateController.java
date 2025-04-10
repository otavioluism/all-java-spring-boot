package br.com.otavioluism.gestao_vagas.modules.candidate.controllers;

import br.com.otavioluism.gestao_vagas.modules.candidate.CandidateEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @PostMapping("/")
    public void create(@Valid @RequestBody CandidateEntity candidateEntity) {
        System.out.println(candidateEntity);
    }

}
