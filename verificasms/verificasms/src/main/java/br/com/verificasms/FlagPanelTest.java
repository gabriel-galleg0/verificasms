package br.com.verificasms;

import javax.swing.*;


public class FlagPanelTest {
    public static void main(String[] args) {
        Sessao.logarAutomaticamente();
        
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Teste do FlagPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setContentPane(new TransacaoPanel(frame));
            frame.setLocationRelativeTo(null); // centraliza
            frame.setVisible(true);
        });
    }
}
