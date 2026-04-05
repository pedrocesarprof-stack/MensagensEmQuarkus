package com.ifgoiano.urt.model.dto;

import io.smallrye.common.constraint.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class MensagemDTO {
    private Long id;

    @NotNull
    private String remetente;

    @NotNull
    private String conteudo;

    private LocalDateTime timestamp;
}
