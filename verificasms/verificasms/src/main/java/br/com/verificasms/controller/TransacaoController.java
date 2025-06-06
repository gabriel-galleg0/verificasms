/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.verificasms.controller;

import br.com.verificasms.model.Transacao;
import br.com.verificasms.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author gabri
 */
@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<Transacao> realizarTransacao(
            @RequestParam Long remetenteId,
            @RequestParam Long destinatarioId,
            @RequestParam Double valor) {

        Transacao transacao = transacaoService.realizarTransacao(remetenteId, destinatarioId, valor);
        return ResponseEntity.ok(transacao);
    }
}

