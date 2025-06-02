/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.verificasms.repository;
import br.com.verificasms.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
/**
 *
 * @author gabri
 */
public interface MensagemRepository extends JpaRepository<Mensagem, Long>{
    List<Mensagem> findByConteudoContainingIgnoreCase(String conteudo);
}