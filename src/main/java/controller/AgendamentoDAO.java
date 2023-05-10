/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Agendamento;

/**
 *
 * 
 */
public class AgendamentoDAO extends ModuloConexao{

    Connection conexao = conector();
    protected Agendamento agendamento = new Agendamento();

    PreparedStatement pst;
    ResultSet rs;

    public void cadastrarAgendamento(Agendamento agendamento) {
        String sql = "insert into agendamento (id_tipo,representante,descricao,estado,prioridade,data,horario)VALUES(?,?,?,?,?,?,?);";
        try {
            pst = conexao.prepareStatement(sql);
            //pst.setString(1, jTextField_idven.getText());

            pst.setString(1, agendamento.getTipo());
            pst.setString(2, agendamento.getNome());
            pst.setString(3, agendamento.getDescricao());
            pst.setString(4, agendamento.getEstado());
            pst.setString(5, agendamento.getPrioridade());
            pst.setString(6, agendamento.getData());
            pst.setString(7, agendamento.getHorario());
            pst.executeUpdate();
            pst.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public List<Agendamento> Read() {
        try {
            List<Agendamento> agendamento1 = new ArrayList<>();

            String cmdsql = "select * from agendamento";

            PreparedStatement stmt = conexao.prepareStatement(cmdsql);

            rs = stmt.executeQuery();

            while (rs.next()) {

                Agendamento c = new Agendamento();

                c.setIDAgendamento(rs.getInt("id_agendamento"));
                c.setNome(rs.getString("representante"));
                c.setData(rs.getString("data"));
                c.setHorario(rs.getString("horario"));
                c.setPrioridade(rs.getString("prioridade"));
                c.setEstado(rs.getString("estado"));
                c.setDescricao(rs.getString("descricao"));
                c.setTipo(rs.getString("id_tipo"));

                agendamento1.add(c);
            }
            return agendamento1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public List<Agendamento> Consultacli(int IDagendamento) {
        try {
            List<Agendamento> agendamento1 = new ArrayList<>();
            String cmdsql = "select * from agendamento where id_agendamento = ?";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setInt(1, IDagendamento);

            rs = stmt.executeQuery();
            while (rs.next()) {

                Agendamento c = new Agendamento();
                c.setIDAgendamento(rs.getInt("id_agendamento"));
                c.setNome(rs.getString("representante"));
                c.setData(rs.getString("data"));
                c.setHorario(rs.getString("horario"));
                c.setPrioridade(rs.getString("prioridade"));
                c.setEstado(rs.getString("estado"));
                c.setDescricao(rs.getString("descricao"));
                c.setTipo(rs.getString("id_tipo"));

                agendamento1.add(c);
            }
            return agendamento1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public List<Agendamento> ConsultacliNome(String Buscar) {
        try {
            List<Agendamento> agendamento1 = new ArrayList<>();
            String cmdsql = "select * from agendamento where LOWER(data) LIKE LOWER(?)";
            PreparedStatement stmt = conexao.prepareStatement(cmdsql);
            stmt.setString(1, Buscar);

            rs = stmt.executeQuery();
            while (rs.next()) {

                Agendamento c = new Agendamento();
                c.setIDAgendamento(rs.getInt("id_agendamento"));
                c.setNome(rs.getString("representante"));
                c.setData(rs.getString("data"));
                c.setHorario(rs.getString("horario"));
                c.setPrioridade(rs.getString("prioridade"));
                c.setEstado(rs.getString("estado"));
                c.setDescricao(rs.getString("descricao"));
                c.setTipo(rs.getString("id_tipo"));

                agendamento1.add(c);
            }
            return agendamento1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void alterarAgendamento(Agendamento agendamentotoedit, int aux) {
        String sql = "update agendamento set representante = ?, horario = ?, data = ?, prioridade = ?, descricao = ?, estado = ?, id_tipo = ?  where id_agendamento = ?";
        try {
            pst = conexao.prepareStatement(sql);
            //pst.setString(1, jTextField_idven.getText());
            pst.setString(1, agendamentotoedit.getNome());
            pst.setString(2, agendamentotoedit.getHorario());
            pst.setString(3, agendamentotoedit.getData());
            pst.setString(4, agendamentotoedit.getPrioridade());
            pst.setString(5, agendamentotoedit.getDescricao());
            pst.setString(6, agendamentotoedit.getEstado());
            pst.setString(7, agendamentotoedit.getTipo());
            
            pst.setInt(8, aux);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Alterado com sucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void excluiAgendamento(Connection conexao, int IDAgendamento) {
        String sql = "delete from agendamento where id_agendamento = ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setInt(1, IDAgendamento);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "OBJETO EXCLUIDO");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
