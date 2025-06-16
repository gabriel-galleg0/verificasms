/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.verificasms.controller;
import br.com.verificasms.model.Flag;
import br.com.verificasms.service.FlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 *
 * @author gabri
 */

@RestController
@RequestMapping("/flag")
public class FlagController {
    
    
    @Autowired
    private final FlagService service;
   
    public FlagController(FlagService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Flag> criar(@RequestBody Flag flag) {
        return ResponseEntity.ok(service.salvar(flag));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flag> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
}
