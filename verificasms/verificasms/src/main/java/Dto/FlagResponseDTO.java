package Dto;

import br.com.verificasms.model.Flag;
import java.time.LocalDateTime;

public class FlagResponseDTO {
    private Long id;
    private Long denuncianteId;
    private Long denunciadoId;
    private String motivo;
    private LocalDateTime dataHora;
    
    
    public FlagResponseDTO(){
}

    public FlagResponseDTO(Flag flag) {
        this.id = flag.getId();
        this.motivo = flag.getMotivo();
    }
     
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDenuncianteId() {
        return denuncianteId;
    }

    public void setDenuncianteId(Long denuncianteId) {
        this.denuncianteId = denuncianteId;
    }

    public Long getDenunciadoId() {
        return denunciadoId;
    }

    public void setDenunciadoId(Long denunciadoId) {
        this.denunciadoId = denunciadoId;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
