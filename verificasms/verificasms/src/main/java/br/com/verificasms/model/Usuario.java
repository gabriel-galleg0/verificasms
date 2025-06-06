/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.verificasms.model;
import jakarta.persistence.*;
import java.util.List;
/**
 *
 * @author gabri
 */
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;

    @OneToMany(mappedBy = "denunciado")
    private List<Flag> flags;

    public boolean isSuspeito() {
        return flags != null && !flags.isEmpty();}
        
    public Long getId() { return id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Flag> getFlags() { return flags; }
    public void setFlags(List<Flag> flags) { this.flags = flags; }

    
}

