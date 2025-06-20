/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package br.com.verificasms;

import br.com.verificasms.model.Usuario;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author gabri
 */
public class DenunciaPanel extends javax.swing.JPanel {

    private Usuario denunciado;
    private JFrame frame;

    public DenunciaPanel(JFrame frame, Usuario denunciado) {
        initComponents();
        this.frame = frame;
        this.denunciado = denunciado;
        flagLabel.setText(denunciado.getNome());
    }

   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        flagLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        motivoField = new javax.swing.JTextField();
        enviarDenunciaBtn = new javax.swing.JButton();

        flagLabel.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        flagLabel.setText("jLabel1");

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Qual motivo da denuncia para o usuário:");

        motivoField.setText("jTextField1");

        enviarDenunciaBtn.setText("jButton1");
        enviarDenunciaBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarDenunciaBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(enviarDenunciaBtn)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(motivoField)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(flagLabel)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(flagLabel)
                .addGap(64, 64, 64)
                .addComponent(motivoField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(enviarDenunciaBtn)
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void enviarDenunciaBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarDenunciaBtnActionPerformed
      try {
            URL url = new URL("http://localhost:8080/flags");
            HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
            conexao.setRequestMethod("POST");
            conexao.setDoOutput(true);
            conexao.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            String motivo = motivoField.getText();
            String parametros = "idUsuarioDenunciante=" + Sessao.getUsuarioLogado().getId()
                              + "&idUsuarioDenunciado=" + denunciado.getId()
                              + "&motivo=" + URLEncoder.encode(motivo, "UTF-8");

            OutputStream os = conexao.getOutputStream();
            os.write(parametros.getBytes("UTF-8"));
            os.flush();
            os.close();

            if (conexao.getResponseCode() == 201 || conexao.getResponseCode() == 200) {
                JOptionPane.showMessageDialog(this, "Denúncia enviada com sucesso.");
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao enviar denúncia.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao enviar denúncia.");
        }
    
    }//GEN-LAST:event_enviarDenunciaBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton enviarDenunciaBtn;
    private javax.swing.JLabel flagLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField motivoField;
    // End of variables declaration//GEN-END:variables

}