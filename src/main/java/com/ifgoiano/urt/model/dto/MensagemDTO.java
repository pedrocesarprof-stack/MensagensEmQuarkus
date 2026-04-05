package com.ifgoiano.urt.model.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class MensagemDTO {
    private Long id;
    private String remetende;
    private String conteudo;
    private LocalDateTime timestamp;
}
