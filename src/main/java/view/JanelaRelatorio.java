/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AgendamentoDAO;
import controller.ModuloConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Agendamento;

/**
 *
 *
 */
public class JanelaRelatorio extends javax.swing.JFrame {
    protected static JanelaRelatorio janelarelatorioUnico;
    AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
    Agendamento agendamento = new Agendamento();
    int aux = 0;
    Connection conexao = null;
    PreparedStatement pst;
    ResultSet rs;

    public JanelaRelatorio() {
        initComponents();
        conexao = ModuloConexao.conector();
        if (conexao != null) {
            jLabel_statuscli.setText("Conectado ao banco ");
        } else {
            jLabel_statuscli.setText("Não conectado ao banco");
        }
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public static JanelaRelatorio getJanelaRelatorio() {
        if (getJanelarelatorioUnico() == null) {
            setJanelarelatorioUnico(new JanelaRelatorio());
        }

        return getJanelarelatorioUnico();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_relatorio = new javax.swing.JTable();
        jLabel_statuscli = new javax.swing.JLabel();
        jLabel_idrelatorio = new javax.swing.JLabel();
        jTextField_idrelatorio = new javax.swing.JTextField();
        jButton_idrelatorio = new javax.swing.JButton();
        jLabel_datarelatorio = new javax.swing.JLabel();
        jTextField_datarelatorio = new javax.swing.JTextField();
        jButton_datarelatorio = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jTable_relatorio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Data", "Horario", "Prioridade", "Estado", "Descricao", "ID"
            }
        ));
        jScrollPane1.setViewportView(jTable_relatorio);

        jLabel_idrelatorio.setText("ID:");

        jButton_idrelatorio.setText("Consultar ID");
        jButton_idrelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_idrelatorioMouseClicked(evt);
            }
        });

        jLabel_datarelatorio.setText("Data:");

        jButton_datarelatorio.setText("Consultar Data");
        jButton_datarelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_datarelatorioMouseClicked(evt);
            }
        });

        jButton1.setText("Sair");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("Consultar Agendamentos");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel_statuscli)
                        .addGap(22, 404, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel_datarelatorio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel_idrelatorio)
                                .addGap(26, 26, 26)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField_idrelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField_datarelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton_datarelatorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_idrelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_idrelatorio)
                    .addComponent(jTextField_idrelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_idrelatorio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel_datarelatorio)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField_datarelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton_datarelatorio)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabel_statuscli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
               // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void jButton_idrelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_idrelatorioMouseClicked
        ConsultaAgendamento();
    }//GEN-LAST:event_jButton_idrelatorioMouseClicked

    private void jButton_datarelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_datarelatorioMouseClicked
        ConsultaAgendamentoNome();
    }//GEN-LAST:event_jButton_datarelatorioMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        lerAgendamento();
    }//GEN-LAST:event_jButton2MouseClicked

    public void lerAgendamento() {
        AgendamentoDAO agendamentodao1 = new AgendamentoDAO();
        List<Agendamento> agendamentoU = agendamentodao1.Read();
        DefaultTableModel modelo = (DefaultTableModel) jTable_relatorio.getModel();
        modelo.setNumRows(0);
        for (Agendamento c : agendamentoU) {
            modelo.addRow(new Object[]{
                c.getNome(),
                c.getData(),
                c.getHorario(),
                c.getPrioridade(),
                c.getEstado(),
                c.getDescricao(),
                c.getIDAgendamento()

            });
        }
    }

    public void ConsultaAgendamento() {
        AgendamentoDAO agendamentodao1 = new AgendamentoDAO();
        try {
            int IDagendamento = Integer.parseInt(jTextField_idrelatorio.getText());
            List<Agendamento> agendamentoU = agendamentodao1.Consultacli(IDagendamento);
            DefaultTableModel modelo = (DefaultTableModel) jTable_relatorio.getModel();
            modelo.setNumRows(0);
            for (Agendamento c : agendamentoU) {
                modelo.addRow(new Object[]{
                    c.getNome(),
                    c.getData(),
                    c.getHorario(),
                    c.getPrioridade(),
                    c.getEstado(),
                    c.getDescricao(),
                    c.getIDAgendamento()
                });
            }
        } catch (NumberFormatException n) {
            lerAgendamento();
        }

    }

    public void ConsultaAgendamentoNome() {
        AgendamentoDAO controllerven1 = new AgendamentoDAO();
        try {
            String Buscar = jTextField_datarelatorio.getText();
            List<Agendamento> agendamentoU = controllerven1.ConsultacliNome(Buscar);
            DefaultTableModel modelo = (DefaultTableModel) jTable_relatorio.getModel();
            modelo.setNumRows(0);
            for (Agendamento c : agendamentoU) {
                modelo.addRow(new Object[]{
                    c.getNome(),
                    c.getData(),
                    c.getHorario(),
                    c.getPrioridade(),
                    c.getEstado(),
                    c.getDescricao(),
                    c.getIDAgendamento()
                });
            }
        } catch (NumberFormatException n) {
            lerAgendamento();
        }

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaRelatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaRelatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_datarelatorio;
    private javax.swing.JButton jButton_idrelatorio;
    private javax.swing.JLabel jLabel_datarelatorio;
    private javax.swing.JLabel jLabel_idrelatorio;
    private javax.swing.JLabel jLabel_statuscli;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_relatorio;
    private javax.swing.JTextField jTextField_datarelatorio;
    private javax.swing.JTextField jTextField_idrelatorio;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the janelarelatorioUnico
     */
    public static JanelaRelatorio getJanelarelatorioUnico() {
        return janelarelatorioUnico;
    }

    /**
     * @param aJanelarelatorioUnico the janelarelatorioUnico to set
     */
    public static void setJanelarelatorioUnico(JanelaRelatorio aJanelarelatorioUnico) {
        janelarelatorioUnico = aJanelarelatorioUnico;
    }
}
