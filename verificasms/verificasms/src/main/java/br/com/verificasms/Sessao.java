/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.verificasms;

import br.com.verificasms.model.Usuario;

/**
 *
 * @author gabri
 */
public class Sessao {
     private static Usuario usuarioLogado;

    public static void logarAutomaticamente() {
    
        usuarioLogado = new Usuario();
        usuarioLogado.setId(7L);
        usuarioLogado.setNome("Usuário Padrão");
        usuarioLogado.setEmail("usuario@teste.com");
    }

    public static Usuario getUsuarioLogado() {
        return usuarioLogado;
    }
}
