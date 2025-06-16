/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.verificasms.service;


import Dto.FlagResponseDTO;
import br.com.verificasms.model.Flag;
import br.com.verificasms.model.Usuario;
import br.com.verificasms.repository.FlagRepository;
import br.com.verificasms.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
    
    public List<FlagResponseDTO> buscarPorMotivoParcial(String motivo) {
    List<Flag> flags = flagRepository.findByMotivoContainingIgnoreCase(motivo);
    return flags.stream().map(FlagResponseDTO::new).collect(Collectors.toList());
}
    
    
    
    public List<FlagResponseDTO> buscarCincoAposId(Long id) {
    List<Flag> todas = flagRepository.findAllByOrderByIdAsc();

    int startIndex = -1;
    for (int i = 0; i < todas.size(); i++) {
        if (todas.get(i).getId().equals(id)) {
            startIndex = i;
            break;
        }
    }

    if (startIndex == -1) return Collections.emptyList();

    List<Flag> sublista = todas.subList(startIndex, Math.min(startIndex + 5, todas.size()));
    return sublista.stream().map(FlagResponseDTO::new).collect(Collectors.toList());
}
}

