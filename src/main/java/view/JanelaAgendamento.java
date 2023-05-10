package view;

import controller.AgendamentoDAO;
import controller.ModuloConexao;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Agendamento;

/**
 *
 * 
 */
public class JanelaAgendamento extends javax.swing.JFrame {

    private static JanelaAgendamento janelaagendamentoUnico;
    AgendamentoDAO agendamentoDAO = new AgendamentoDAO();
    Agendamento agendamento = new Agendamento();
    int aux = 0;
    Connection conexao = null;
    PreparedStatement pst;
    ResultSet rs;

    public JanelaAgendamento() {
        initComponents();
        conexao = ModuloConexao.conector();
        /*
        if (conexao != null) {
            jLabel_statuscli.setText("Conectado ao banco ");
        } else {
            jLabel_statuscli.setText("Não conectado ao banco");
        }
        */
    }

    public static JanelaAgendamento getJanelaAgendamento() {
        if (janelaagendamentoUnico == null) {
            janelaagendamentoUnico = new JanelaAgendamento();
        }

        return janelaagendamentoUnico;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel_statuscli = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel_descricao = new javax.swing.JLabel();
        jTextField_descricao = new javax.swing.JTextField();
        jLabel_nomecli = new javax.swing.JLabel();
        jTextField_nome = new javax.swing.JTextField();
        jTextField_horario = new javax.swing.JTextField();
        jTextField_data = new javax.swing.JTextField();
        jLabel_idadecli = new javax.swing.JLabel();
        jLabel_emailcli = new javax.swing.JLabel();
        jLabel_estado = new javax.swing.JLabel();
        jLabel_tipo = new javax.swing.JLabel();
        jLabel_prioridade = new javax.swing.JLabel();
        jComboBox_estado = new javax.swing.JComboBox<>();
        jComboBox_tipo = new javax.swing.JComboBox<>();
        jComboBox_prioridade = new javax.swing.JComboBox<>();
        jButton_alterarcli = new javax.swing.JButton();
        jButton_excluircli = new javax.swing.JButton();
        jButton_inserircli = new javax.swing.JButton();
        jButton_saircli = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_agendamento = new javax.swing.JTable();
        jButton_consultarcli = new javax.swing.JButton();
        jButton_buscar = new javax.swing.JButton();
        jLabel_id = new javax.swing.JLabel();
        jLabel_buscar = new javax.swing.JLabel();
        jTextField_id = new javax.swing.JTextField();
        jTextField_buscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel_descricao.setText("Descricao");

        jTextField_descricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_descricaoActionPerformed(evt);
            }
        });

        jLabel_nomecli.setText("Representante");

        jLabel_idadecli.setText("Horario");

        jLabel_emailcli.setText("Data");

        jLabel_estado.setText("Estado:");

        jLabel_tipo.setText("Tipo:");

        jLabel_prioridade.setText("Prioridade:");

        jComboBox_estado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aberto", "Em andamento", "Fechada" }));

        jComboBox_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Profissional", "Academico", "Pessoal" }));

        jComboBox_prioridade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Normal", "Baixa", "Alta", "Urgente" }));

        jButton_alterarcli.setText("Alterar");
        jButton_alterarcli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_alterarcliMouseClicked(evt);
            }
        });

        jButton_excluircli.setText("Excluir");
        jButton_excluircli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_excluircliMouseClicked(evt);
            }
        });

        jButton_inserircli.setText("Inserir");
        jButton_inserircli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_inserircliMouseClicked(evt);
            }
        });

        jButton_saircli.setText("Sair");
        jButton_saircli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_saircliMouseClicked(evt);
            }
        });

        jTable_agendamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nome", "Data", "Horario", "Prioridade", "Estado", "Descricao", "ID"
            }
        ));
        jTable_agendamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_agendamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_agendamento);

        jButton_consultarcli.setText("Consultar ID");
        jButton_consultarcli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_consultarcliMouseClicked(evt);
            }
        });

        jButton_buscar.setText("Consultar Data");
        jButton_buscar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton_buscarMouseClicked(evt);
            }
        });

        jLabel_id.setText("ID: ");

        jLabel_buscar.setText("Buscar:");

        jTextField_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_idActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\sfcvi\\OneDrive\\Documentos\\NetBeansProjects\\OficinaAgenda\\salvar.png")); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\sfcvi\\OneDrive\\Documentos\\NetBeansProjects\\OficinaAgenda\\excluir.png")); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\sfcvi\\OneDrive\\Documentos\\NetBeansProjects\\OficinaAgenda\\alterar.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_tipo)
                            .addComponent(jLabel_prioridade)
                            .addComponent(jLabel_estado))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox_prioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_id, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel_buscar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField_id)
                            .addComponent(jTextField_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton_buscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton_consultarcli, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(78, 78, 78))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel_emailcli)
                                    .addComponent(jLabel_nomecli)
                                    .addComponent(jLabel_idadecli)
                                    .addComponent(jLabel_descricao)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton_inserircli)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(17, 17, 17)
                                        .addComponent(jTextField_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_horario, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_data, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButton_alterarcli)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton_excluircli)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton_saircli))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_descricao)
                            .addComponent(jTextField_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_nomecli))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_horario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_idadecli))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel_emailcli))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel_estado)
                            .addComponent(jComboBox_estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_consultarcli)
                            .addComponent(jLabel_id)
                            .addComponent(jTextField_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton_buscar)
                            .addComponent(jLabel_buscar)
                            .addComponent(jTextField_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_tipo)
                    .addComponent(jComboBox_tipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox_prioridade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel_prioridade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_saircli)
                        .addGap(68, 68, 68))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jButton_inserircli)
                            .addComponent(jButton_alterarcli)
                            .addComponent(jLabel4)
                            .addComponent(jButton_excluircli)
                            .addComponent(jLabel3))
                        .addGap(29, 29, 29))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel_statuscli))
                .addGap(1003, 1003, 1003))
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel_statuscli)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_consultarcliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_consultarcliMouseClicked
        ConsultaAgendamento();
    }//GEN-LAST:event_jButton_consultarcliMouseClicked


    private void jButton_inserircliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_inserircliMouseClicked
        Agendamento agendamento = new Agendamento();
        try {
            agendamento.setDescricao(jTextField_descricao.getText());
            agendamento.setNome(jTextField_nome.getText());
            agendamento.setHorario(jTextField_horario.getText());
            agendamento.setData(jTextField_data.getText());
            agendamento.setTipo(jComboBox_tipo.getSelectedItem().toString());
            agendamento.setEstado(jComboBox_estado.getSelectedItem().toString());
            agendamento.setPrioridade(jComboBox_prioridade.getSelectedItem().toString());
            agendamentoDAO.cadastrarAgendamento(agendamento);
            JOptionPane.showMessageDialog(null, "cadastro realizado com sucesso");
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(null, "ERRO AO CADASTRAR:" + e);
        }
        lerAgendamento();
        limparagendamento();

    }//GEN-LAST:event_jButton_inserircliMouseClicked

    private void jButton_alterarcliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_alterarcliMouseClicked
        try {
            Agendamento agendamentotoedit = new Agendamento();
            agendamentotoedit.setDescricao(jTextField_descricao.getText());
            agendamentotoedit.setNome(jTextField_nome.getText());
            agendamentotoedit.setHorario(jTextField_horario.getText());
            agendamentotoedit.setData(jTextField_data.getText());
            agendamentotoedit.setTipo(jComboBox_tipo.getSelectedItem().toString());
            agendamentotoedit.setEstado(jComboBox_estado.getSelectedItem().toString());
            agendamentotoedit.setPrioridade(jComboBox_prioridade.getSelectedItem().toString());
            int aux = Integer.parseInt(jTextField_id.getText());
            agendamentoDAO.alterarAgendamento(agendamentotoedit, aux);

        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "ERRO AO ALTERAR:" + n);
        }
        lerAgendamento();
        limparagendamento();

    }//GEN-LAST:event_jButton_alterarcliMouseClicked

    private void jButton_excluircliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_excluircliMouseClicked
        try {
            int IDAgendamento = Integer.parseInt(jTextField_id.getText());
            agendamentoDAO.excluiAgendamento(IDAgendamento);

        } catch (NumberFormatException n) {
            JOptionPane.showMessageDialog(null, "ERRO AO EXCLUIR:" + n);
        }
        lerAgendamento();
        limparagendamento();
    }//GEN-LAST:event_jButton_excluircliMouseClicked

    private void jButton_saircliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_saircliMouseClicked
        dispose();
    }//GEN-LAST:event_jButton_saircliMouseClicked

    private void jTextField_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_idActionPerformed

    private void jTable_agendamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_agendamentoMouseClicked
        String nome = (String) jTable_agendamento.getValueAt(jTable_agendamento.getSelectedRow(), 0);
        String data = (String) jTable_agendamento.getValueAt(jTable_agendamento.getSelectedRow(), 1);
        String horario = (String) jTable_agendamento.getValueAt(jTable_agendamento.getSelectedRow(), 2);
        String descricao = (String) jTable_agendamento.getValueAt(jTable_agendamento.getSelectedRow(), 5);
        int id = (Integer) jTable_agendamento.getValueAt(jTable_agendamento.getSelectedRow(), 6);
        jTextField_nome.setText(nome);
        jTextField_data.setText(data);
        jTextField_horario.setText(horario);
        jTextField_descricao.setText(descricao);
        jTextField_id.setText(Integer.toString(id));
    }//GEN-LAST:event_jTable_agendamentoMouseClicked

    private void jButton_buscarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_buscarMouseClicked
        ConsultaAgendamentoNome();
    }//GEN-LAST:event_jButton_buscarMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        lerAgendamento();
    }//GEN-LAST:event_formWindowOpened

    private void jTextField_descricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_descricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_descricaoActionPerformed

    public void lerAgendamento() {
        AgendamentoDAO agendamentodao1 = new AgendamentoDAO();
        List<Agendamento> agendamentoU = agendamentodao1.Read();
        DefaultTableModel modelo = (DefaultTableModel) jTable_agendamento.getModel();
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
            int IDagendamento = Integer.parseInt(jTextField_id.getText());
            List<Agendamento> agendamentoU = agendamentodao1.Consultacli(IDagendamento);
            DefaultTableModel modelo = (DefaultTableModel) jTable_agendamento.getModel();
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
            String Buscar = jTextField_buscar.getText();
            List<Agendamento> agendamentoU = controllerven1.ConsultacliNome( Buscar);
            DefaultTableModel modelo = (DefaultTableModel) jTable_agendamento.getModel();
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

    public void limparagendamento() {
        jTextField_nome.setText("");
        jTextField_horario.setText("");
        jTextField_id.setText("");
        jTextField_data.setText("");
        jTextField_descricao.setText("");
        jTextField_id.setText("");
        jTextField_buscar.setText("");
        

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
            java.util.logging.Logger.getLogger(JanelaAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaAgendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaAgendamento().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_alterarcli;
    private javax.swing.JButton jButton_buscar;
    private javax.swing.JButton jButton_consultarcli;
    private javax.swing.JButton jButton_excluircli;
    private javax.swing.JButton jButton_inserircli;
    private javax.swing.JButton jButton_saircli;
    private javax.swing.JComboBox<String> jComboBox_estado;
    private javax.swing.JComboBox<String> jComboBox_prioridade;
    private javax.swing.JComboBox<String> jComboBox_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel_buscar;
    private javax.swing.JLabel jLabel_descricao;
    private javax.swing.JLabel jLabel_emailcli;
    private javax.swing.JLabel jLabel_estado;
    private javax.swing.JLabel jLabel_id;
    private javax.swing.JLabel jLabel_idadecli;
    private javax.swing.JLabel jLabel_nomecli;
    private javax.swing.JLabel jLabel_prioridade;
    private javax.swing.JLabel jLabel_statuscli;
    private javax.swing.JLabel jLabel_tipo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_agendamento;
    private javax.swing.JTextField jTextField_buscar;
    private javax.swing.JTextField jTextField_data;
    private javax.swing.JTextField jTextField_descricao;
    private javax.swing.JTextField jTextField_horario;
    private javax.swing.JTextField jTextField_id;
    private javax.swing.JTextField jTextField_nome;
    // End of variables declaration//GEN-END:variables
}
