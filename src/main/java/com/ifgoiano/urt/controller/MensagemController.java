package com.ifgoiano.urt.controller;

import com.ifgoiano.urt.model.dto.MensagemDTO;
import com.ifgoiano.urt.service.MensagemService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Path("/mensagens")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequiredArgsConstructor
public class MensagemController {

    private final MensagemService mensagemService;

    @POST
    public Response criar(MensagemDTO dto) {
        MensagemDTO criada = mensagemService.salvarMensagem(dto);
        return Response.status(Response.Status.CREATED).entity(criada).build();
    }

    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") Long id) {
        try {
            MensagemDTO mensagem = mensagemService.buscarPorId(id);
            return Response.ok(mensagem).build();
        } catch (RuntimeException ex) {
            throw new NotFoundException(ex.getMessage());
        }
    }

    @GET
    public Response listar() {
        List<MensagemDTO> mensagens = mensagemService.buscarTodasMensagens();
        return Response.ok(mensagens).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") Long id) {
        try {
            MensagemDTO deletada = mensagemService.deletarMensagem(id);
            return Response.ok(deletada).build();
        } catch (RuntimeException ex) {
            throw new NotFoundException(ex.getMessage());
        }
    }
}