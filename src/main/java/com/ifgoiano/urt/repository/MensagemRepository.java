package com.ifgoiano.urt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ifgoiano.urt.model.entities.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {
}
