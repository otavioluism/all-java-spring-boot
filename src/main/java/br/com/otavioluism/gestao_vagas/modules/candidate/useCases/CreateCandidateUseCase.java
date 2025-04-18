package br.com.otavioluism.gestao_vagas.modules.candidate.useCases;

import br.com.otavioluism.gestao_vagas.exceptions.UserFoundException;
import br.com.otavioluism.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.otavioluism.gestao_vagas.modules.candidate.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidateEntity){
        this.candidateRepository.findByUsernameOrEmail(candidateEntity.getUsername(), candidateEntity.getEmail()).ifPresent(
                (user) -> {
                    throw new UserFoundException();
                }
        );

        return this.candidateRepository.save(candidateEntity);
    }
}
