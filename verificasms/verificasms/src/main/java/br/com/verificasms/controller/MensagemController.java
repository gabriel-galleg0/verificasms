/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.verificasms.controller;
import br.com.verificasms.model.Mensagem;
import br.com.verificasms.service.MensagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author gabri
 */

@RestController
@RequestMapping("/api/mensagens")
public class MensagemController {
       private final MensagemService service;

    public MensagemController(MensagemService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Mensagem> criar(@RequestBody Mensagem mensagem) {
        return ResponseEntity.ok(service.salvar(mensagem));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mensagem> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
}
