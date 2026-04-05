package com.ifgoiano.urt.mapper;

import com.ifgoiano.urt.model.dto.MensagemDTO;
import com.ifgoiano.urt.model.entities.Mensagem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "cdi")
public interface MensagemMapper {

    MensagemDTO toDto(Mensagem mensagem);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "timestamp", ignore = true)
    Mensagem toEntity(MensagemDTO dto);

    List<MensagemDTO> toDtoList(List<Mensagem> mensagens);
}