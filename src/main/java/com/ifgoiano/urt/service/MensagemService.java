package com.ifgoiano.urt.service;

import com.ifgoiano.urt.mapper.MensagemMapper;
import com.ifgoiano.urt.model.dto.MensagemDTO;
import com.ifgoiano.urt.model.entities.Mensagem;
import com.ifgoiano.urt.repository.MensagemRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MensagemService {

    private final MensagemRepository repository;
    private final MensagemMapper mensagemMapper;

    @Transactional
    public MensagemDTO salvarMensagem(MensagemDTO mensagemDTO) {
        Mensagem entidade = mensagemMapper.toEntity(mensagemDTO);
        Mensagem salva = repository.save(entidade);
        return mensagemMapper.toDto(salva);
    }

    @Transactional
    public MensagemDTO deletarMensagem(Long id) {

        Mensagem mensagemOriginal = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mensagem não encontrada com id: " + id));

        MensagemDTO mensagemDtoDeletada = mensagemMapper.toDto(mensagemOriginal);

        repository.delete(mensagemOriginal);

        return mensagemDtoDeletada;
    }

    public MensagemDTO buscarPorId(Long id){
        MensagemDTO mensagemDTO = repository.findById(id)
                .map(mensagemMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Mensagem não encontrada com id: " + id));

        return mensagemDTO;
    }

    public List<MensagemDTO> buscarTodasMensagens() {
        return mensagemMapper.toDtoList(repository.findAll());
    }
}