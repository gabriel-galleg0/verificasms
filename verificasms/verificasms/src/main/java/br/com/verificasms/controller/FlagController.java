package br.com.verificasms.controller;

import Dto.FlagDenunciaDTO;
import Dto.FlagResponseDTO;
import br.com.verificasms.model.Flag;
import br.com.verificasms.model.Usuario;
import br.com.verificasms.repository.FlagRepository;
import br.com.verificasms.repository.UsuarioRepository;
import br.com.verificasms.service.FlagService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlagController {

    @Autowired
    private FlagRepository flagRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;
    private final FlagService flagService;
    
     public FlagController(FlagService flagService) {
        this.flagService = flagService;
    }

    @PostMapping("/flag")
    public ResponseEntity<?> criarFlag(@RequestBody FlagDenunciaDTO dto) {
        Usuario denunciante = usuarioRepository.findById(dto.getDenuncianteId()).orElse(null);
        Usuario denunciado = usuarioRepository.findById(dto.getDenunciadoId()).orElse(null);

        if (denunciante == null || denunciado == null) {
            return ResponseEntity.badRequest().body("Denunciante ou Denunciado não encontrados.");
        }

        Flag flag = new Flag();
        flag.setDenunciante(denunciante);
        flag.setDenunciado(denunciado);
        flag.setMotivo(dto.getMotivo());

        Flag savedFlag = flagRepository.save(flag);

        FlagResponseDTO response = new FlagResponseDTO();
        response.setId(savedFlag.getId());
        response.setDenuncianteId(savedFlag.getDenunciante().getId());
        response.setDenunciadoId(savedFlag.getDenunciado().getId());
        response.setMotivo(savedFlag.getMotivo());
        response.setDataHora(savedFlag.getDataHora());

        return ResponseEntity.ok(response);
    }
    @GetMapping("/flags/busca")
    public ResponseEntity<List<FlagResponseDTO>> buscarPorMotivo(@RequestParam String motivo) {
    List<FlagResponseDTO> resultados = flagService.buscarPorMotivoParcial(motivo);
    return ResponseEntity.ok(resultados);
}

    
    
    @GetMapping("/flags/buscaid")
    public ResponseEntity<List<FlagResponseDTO>> buscarCincoAposId(@RequestParam Long id) {
    List<FlagResponseDTO> fila = flagService.buscarCincoAposId(id);
    return ResponseEntity.ok(fila);
}
    
    
}
