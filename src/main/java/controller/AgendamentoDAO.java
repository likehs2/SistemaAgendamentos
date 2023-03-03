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
public class AgendamentoDAO {

    protected Agendamento agendamento = new Agendamento();

    PreparedStatement pst;
    ResultSet rs;

    public void cadastrarAgendamento(Agendamento agendamento, Connection conexao) {
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

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public List<Agendamento> Read(Connection conexao) {
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



    public List<Agendamento> Consultacli(Connection conexao, int IDagendamento) {
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



    public List<Agendamento> ConsultacliNome(Connection conexao, String Buscar) {
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

    public void alterarAgendamento(Connection conexao, Agendamento agendamentotoedit, int aux) {
        String sql = "update agendamento set representante = ?, horario = ?, data = ?, prioridade = ?, descricao = ?, estado = ?, id_tipo = ?  where id_agendamento = ?";
        try {
            pst = conexao.prepareStatement(sql);
            //pst.setString(1, jTextField_idven.getText());
            pst.setString(1, agendamentotoedit.getNome());
            System.out.println("1");
            pst.setString(2, agendamentotoedit.getHorario());
            System.out.println("2");
            pst.setString(3, agendamentotoedit.getData());
            System.out.println("3");
            pst.setString(4, agendamentotoedit.getPrioridade());
            System.out.println("4");
            pst.setString(5, agendamentotoedit.getDescricao());
            System.out.println("5");
            pst.setString(6, agendamentotoedit.getEstado());
            System.out.println("6");
            pst.setString(7, agendamentotoedit.getTipo());
            System.out.println("7");
            pst.setInt(8, aux);
            System.out.println("8");
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
