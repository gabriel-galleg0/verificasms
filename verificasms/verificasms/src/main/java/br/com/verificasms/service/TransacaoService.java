/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.verificasms.service;
import br.com.verificasms.model.Transacao;
import br.com.verificasms.model.Usuario;
import br.com.verificasms.repository.TransacaoRepository;
import br.com.verificasms.repository.UsuarioRepository;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author gabri
 */
@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Transacao realizarTransacao(Long remetenteId, Long destinatarioId, Double valor) {
        Usuario remetente = usuarioRepository.findById(remetenteId)
                .orElseThrow(() -> new IllegalArgumentException("Remetente não encontrado: ID = " + remetenteId));
        Usuario destinatario = usuarioRepository.findById(destinatarioId)
                .orElseThrow(() -> new IllegalArgumentException("Destinatário não encontrado: ID = " + destinatarioId));

        if (destinatario.isSuspeito()) {
           
            System.out.println("⚠️ Atenção: o destinatário tem denúncias registradas.");
        }

        Transacao transacao = new Transacao();
        transacao.setRemetente(remetente);
        transacao.setDestinatario(destinatario);
        transacao.setValor(valor);
        transacao.setDataHora(LocalDateTime.now());

        return transacaoRepository.save(transacao);
    }
}

