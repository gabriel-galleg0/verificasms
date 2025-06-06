/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.verificasms.repository;
import br.com.verificasms.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author gabri
 */


public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    
}

