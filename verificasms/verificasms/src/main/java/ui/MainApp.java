/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;
import javax.swing.*;
import br.com.verificasms.TransacaoPanel;
/**
 *
 * @author gabri
 */



public class MainApp {

    public static void main(String[] args) {
        // Interface visual
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        JFrame frame = new JFrame("VerificaSMS - Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Transação", new TransacaoPanel());

        // Por enquanto, apenas rascunho da aba Denúncia
        JPanel denuncia = new JPanel();
        denuncia.add(new JLabel("Painel de denúncia em desenvolvimento..."));
        tabs.addTab("Denúncia", denuncia);

        frame.add(tabs);
        frame.setVisible(true);
    }
}

