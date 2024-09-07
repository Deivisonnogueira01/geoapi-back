package com.geobrapi.api.controller;

import com.geobrapi.domain.Cidade;
import com.geobrapi.domain.request.FiltroCidadeRequest;
import com.geobrapi.security.JWTUtil;
import com.geobrapi.services.CidadeService;
import com.geobrapi.specifications.CidadeSpec;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    private final CidadeService cidadeService;
    private final JWTUtil jwtUtil;


    public CidadeController(CidadeService cidadeService, JWTUtil jwtUtil) {
        this.cidadeService = cidadeService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cidade> getById(@PathVariable("id") long id, HttpServletRequest request) {
        Cidade cidade = this.cidadeService.consultarCidadePorId(id).get();
        return ResponseEntity.ok(cidade);
    }


    @GetMapping("")
    public ResponseEntity<List<Cidade>> buscar(@ModelAttribute FiltroCidadeRequest filtroCidadeRequestRequest) {
        Specification<Cidade> spec = CidadeSpec.filterBy(filtroCidadeRequestRequest);
        List<Cidade> cidades = this.cidadeService.buscar(spec);
        return ResponseEntity.ok(cidades);
    }

}