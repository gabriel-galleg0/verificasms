/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.verificasms.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
/**
 *
 * @author gabri
 */
@Entity
public class Flag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario denunciado;

    @ManyToOne
    private Usuario denunciante;

    private String motivo;
    private LocalDateTime dataHora = LocalDateTime.now();
    
    public Long getId(){return id; }
    public Usuario getDenunciado() { return denunciado; }
    public void setDenunciado(Usuario denunciado) { this.denunciado = denunciado; }

    public Usuario getDenunciante() { return denunciante; }
    public void setDenunciante(Usuario denunciante) { this.denunciante = denunciante; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public LocalDateTime getDataHora() { return dataHora; }
    public void setDataHora(LocalDateTime dataHora) { this.dataHora = dataHora; }
}

