/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Agendamento;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Victor Hugo
 */
public class AgendamentoDAOTest {
     
    private AgendamentoDAO agendamentoDAO;
    private Connection conexao;
    private Agendamento agendamento;
    
    @Test
    public void testRead() throws SQLException {
        agendamentoDAO = new AgendamentoDAO();
        List<Agendamento> agendamentos = agendamentoDAO.Read();

        assertNotNull(agendamentos);
        
        Agendamento agendamento1 = agendamentos.get(0);
        assertEquals("Profissional".trim(), agendamento1.getTipo().trim());
        assertEquals("sander".trim(), agendamento1.getNome().trim());
        assertEquals("10/06/2022".trim(), agendamento1.getData().trim());
        assertEquals("08:58".trim(), agendamento1.getHorario().trim());
        assertEquals("Normal".trim(), agendamento1.getPrioridade().trim());
        assertEquals("Aberto".trim(), agendamento1.getEstado().trim());
        assertEquals("teste".trim(), agendamento1.getDescricao().trim());
        
        //Verificação
        Agendamento agendamento2 = agendamentos.get(1);
        assertEquals("Profissional".trim(), agendamento2.getTipo().trim());
        assertEquals("Sanderson".trim(), agendamento2.getNome().trim());
        assertEquals("15/06/2022".trim(), agendamento2.getData().trim());
        assertEquals("10:30".trim(), agendamento2.getHorario().trim());
        assertEquals("Normal".trim(), agendamento2.getPrioridade().trim());
        assertEquals("Aberto".trim(), agendamento2.getEstado().trim());
        assertEquals("Teste 2".trim(), agendamento2.getDescricao().trim());
    }

    @Test
    public void testCadastrarAgendamento() throws SQLException {
        agendamentoDAO = new AgendamentoDAO();
        conexao = agendamentoDAO.conector();
        agendamento = new Agendamento();
        agendamento.setTipo("Teste");
        agendamento.setNome("Victor");
        agendamento.setDescricao("teste testCadastrarAgedamento #05968741");
        agendamento.setEstado("Aberto");
        agendamento.setPrioridade("Media");
        agendamento.setData("10/08/2024");
        agendamento.setHorario("21:00");

        agendamentoDAO.cadastrarAgendamento(agendamento);

        PreparedStatement pst = conexao.prepareStatement("select * from agendamento where id_tipo = ? and descricao = ?");
        pst.setString(1, agendamento.getTipo());
        pst.setString(2, agendamento.getDescricao());
        ResultSet rs = pst.executeQuery();
        Agendamento agendamentoAux = new Agendamento();    
        while (rs.next()) {
            agendamentoAux.setTipo(rs.getString("id_tipo"));
            agendamentoAux.setNome(rs.getString("representante"));
            agendamentoAux.setDescricao(rs.getString("descricao"));
            agendamentoAux.setEstado(rs.getString("estado"));
            agendamentoAux.setPrioridade(rs.getString("prioridade"));
            agendamentoAux.setData(rs.getString("data"));
            agendamentoAux.setHorario(rs.getString("horario"));
        }

        //Verificação
        assertEquals(agendamento.getTipo().trim(), agendamentoAux.getTipo().trim());
        assertEquals(agendamento.getNome().trim(), agendamentoAux.getNome().trim());
        assertEquals(agendamento.getDescricao().trim(), agendamentoAux.getDescricao().trim());
        assertEquals(agendamento.getEstado().trim(), agendamentoAux.getEstado().trim());
        assertEquals(agendamento.getPrioridade().trim(), agendamentoAux.getPrioridade().trim());
        assertEquals(agendamento.getData().trim(), agendamentoAux.getData().trim());
        assertEquals(agendamento.getHorario().trim(), agendamentoAux.getHorario().trim());
        
        //Deleção de agendamento de teste
        pst = conexao.prepareStatement("delete from agendamento where id_tipo = ? and descricao = ?");
        pst.setString(1, agendamento.getTipo());
        pst.setString(2, agendamento.getDescricao());
        pst.executeUpdate();
    }
}

