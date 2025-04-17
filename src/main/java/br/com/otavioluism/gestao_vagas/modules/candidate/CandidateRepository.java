package br.com.otavioluism.gestao_vagas.modules.candidate;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;


public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {
    Optional<CandidateEntity> findByUsernameOrEmail(String username, String email); // JPA é inteligente para saber que o metodo é de busca so olhando pelo findById, lembrando que se usar And ele precisa dos dois campos
}
