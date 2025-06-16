/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.verificasms.service;


import br.com.verificasms.model.Flag;
import br.com.verificasms.model.Usuario;
import br.com.verificasms.repository.FlagRepository;
import br.com.verificasms.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;
/**
 *
 * @author gabri
 */
@Service
public class FlagService {

    @Autowired
    private FlagRepository flagRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    
     public Optional<Flag> buscarPorId(Long id) {
        return flagRepository.findById(id);
    }
     
    public Flag salvar(Flag flag){
        return flagRepository.save(flag);
    }

    public Flag denunciarUsuario(Long denuncianteId, Long denunciadoId, String motivo) {
        Usuario denunciante = usuarioRepository.findById(denuncianteId).orElseThrow();
        Usuario denunciado = usuarioRepository.findById(denunciadoId).orElseThrow();

        Flag flag = new Flag();
        flag.setDenunciante(denunciante);
        flag.setDenunciado(denunciado);
        flag.setMotivo(motivo);

        return flagRepository.save(flag);
        
    }
}

