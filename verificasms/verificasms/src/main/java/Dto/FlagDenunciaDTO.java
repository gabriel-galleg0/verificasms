/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dto;

/**
 *
 * @author gabri
 */
public class FlagDenunciaDTO {
     private Long denuncianteId;
    private Long denunciadoId;
    private String motivo;

    
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
}
