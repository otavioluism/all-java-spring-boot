package br.com.otavioluism.gestao_vagas.modules.candidate.controllers;

import br.com.otavioluism.gestao_vagas.exceptions.UserFoundException;
import br.com.otavioluism.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.otavioluism.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.otavioluism.gestao_vagas.modules.useCases.CreateCandidateUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CreateCandidateUseCase createCandidateUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var response =  this.createCandidateUseCase.execute(candidateEntity);
            return ResponseEntity.ok().body(response);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

}
