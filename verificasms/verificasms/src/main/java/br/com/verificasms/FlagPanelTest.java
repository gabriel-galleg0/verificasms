package br.com.verificasms;

import javax.swing.*;


public class FlagPanelTest {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Teste do FlagPanel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);
            frame.setContentPane(new FlagPanel());
            frame.setLocationRelativeTo(null); // centraliza
            frame.setVisible(true);
        });
    }
}
