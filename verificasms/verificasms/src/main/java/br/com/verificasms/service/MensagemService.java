/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.verificasms.service;
import br.com.verificasms.model.Mensagem;
import br.com.verificasms.repository.MensagemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
/**
 *
 * @author gabri
 */
public class MensagemService {
     private final MensagemRepository repository;

    public MensagemService(MensagemRepository repository) {
        this.repository = repository;
    }

    public Mensagem salvar(Mensagem mensagem) {
        return repository.save(mensagem);
    }

    public Optional<Mensagem> buscarPorId(Long id) {
        return repository.findById(id);
    }
}
