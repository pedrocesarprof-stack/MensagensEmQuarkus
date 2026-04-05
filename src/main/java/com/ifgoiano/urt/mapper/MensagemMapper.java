package com.ifgoiano.urt.mapper;

import com.ifgoiano.urt.model.dto.MensagemDTO;
import com.ifgoiano.urt.model.entities.Mensagem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "quarkus")
public interface MensagemMapper {
	MensagemDTO toDto(Mensagem mensagem);

	Mensagem toEntity(MensagemDTO mensagemDTO);
}
