package com.geobrapi.api.controller;

import com.geobrapi.api.exception.EstadoException;
import com.geobrapi.domain.dtos.EstadoDTO;
import com.geobrapi.security.JWTUtil;
import com.geobrapi.services.EstadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/estados")
public class EstadoController {

    private final EstadoService service;
    private final JWTUtil jwtUtil;

    @Autowired
    public EstadoController(EstadoService service, JWTUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }


    @GetMapping
    public ResponseEntity<List<EstadoDTO>> consultaEstado(HttpServletRequest request) {

        try {

            String token = request.getHeader(HttpHeaders.AUTHORIZATION).substring(7);
            jwtUtil.tokenValido(token);

            List<EstadoDTO> estadosDTO = service.getIdNomeEstados();

            return ResponseEntity.ok(estadosDTO);

        } catch (Exception e) {
            log.error("Não foi Possivel acessar os Estados cadastrados", e);
            throw new EstadoException("Não foi possivel consultar os estados ");
        }

    }


}
