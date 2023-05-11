/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import model.Agendamento;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Victor Hugo
 */
public class AgendamentoDAOTest {
     
    private AgendamentoDAO agendamentoDAO;
    private Connection conexao;
    private Agendamento agendamento;
    private int idAgendamento;
    
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
    public void testCadastrarAgendamento() throws Exception {
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
            agendamentoAux.setIDAgendamento(rs.getInt("id_agendamento"));
            agendamentoAux.setTipo(rs.getString("id_tipo"));
            agendamentoAux.setNome(rs.getString("representante"));
            agendamentoAux.setDescricao(rs.getString("descricao"));
            agendamentoAux.setEstado(rs.getString("estado"));
            agendamentoAux.setPrioridade(rs.getString("prioridade"));
            agendamentoAux.setData(rs.getString("data"));
            agendamentoAux.setHorario(rs.getString("horario"));
        }
        
        idAgendamento = agendamentoAux.getIDAgendamento();

        //Verificação
        assertEquals(agendamento.getTipo().trim(), agendamentoAux.getTipo().trim());
        assertEquals(agendamento.getNome().trim(), agendamentoAux.getNome().trim());
        assertEquals(agendamento.getDescricao().trim(), agendamentoAux.getDescricao().trim());
        assertEquals(agendamento.getEstado().trim(), agendamentoAux.getEstado().trim());
        assertEquals(agendamento.getPrioridade().trim(), agendamentoAux.getPrioridade().trim());
        assertEquals(agendamento.getData().trim(), agendamentoAux.getData().trim());
        assertEquals(agendamento.getHorario().trim(), agendamentoAux.getHorario().trim());
        
        //Deleção de agendamento de teste
        pst = conexao.prepareStatement("delete from agendamento where id_agendamento = ?");
        pst.setInt(1, idAgendamento);
        pst.executeUpdate();
    }
    
    @Test
    public void testConsultacli() throws Exception {
        agendamentoDAO = new AgendamentoDAO();
        agendamento = new Agendamento();
        conexao = agendamentoDAO.conector();
        agendamento.setTipo("Teste");
        agendamento.setNome("Victor");
        agendamento.setDescricao("teste testConsultacli #1547893");
        agendamento.setEstado("Em andamento");
        agendamento.setPrioridade("Normal");
        agendamento.setData("07/01/2024");
        agendamento.setHorario("09:30");
        agendamentoDAO.cadastrarAgendamento(agendamento);
        
        PreparedStatement pst = conexao.prepareStatement("select * from agendamento where id_tipo = ? and descricao = ?");
        pst.setString(1, agendamento.getTipo());
        pst.setString(2, agendamento.getDescricao());
        ResultSet rs = pst.executeQuery();
        
        Agendamento agendamentoAux = new Agendamento(); 
        while (rs.next()) {
            agendamentoAux.setIDAgendamento(rs.getInt("id_agendamento"));
            agendamentoAux.setTipo(rs.getString("id_tipo"));
            agendamentoAux.setNome(rs.getString("representante"));
            agendamentoAux.setDescricao(rs.getString("descricao"));
            agendamentoAux.setEstado(rs.getString("estado"));
            agendamentoAux.setPrioridade(rs.getString("prioridade"));
            agendamentoAux.setData(rs.getString("data"));
            agendamentoAux.setHorario(rs.getString("horario"));
        }
        
        idAgendamento = agendamentoAux.getIDAgendamento();
        
        //Chamada do método Consultacli
        List<Agendamento> agendamentoTest = agendamentoDAO.Consultacli(idAgendamento);
        
        assertNotEquals(0, agendamentoTest.get(0).getIDAgendamento());
        
        //Verificação
        assertEquals(agendamento.getTipo().trim(), agendamentoTest.get(0).getTipo().trim());
        assertEquals(agendamento.getNome().trim(), agendamentoTest.get(0).getNome().trim());
        assertEquals(agendamento.getDescricao().trim(), agendamentoTest.get(0).getDescricao().trim());
        assertEquals(agendamento.getEstado().trim(), agendamentoTest.get(0).getEstado().trim());
        assertEquals(agendamento.getPrioridade().trim(), agendamentoTest.get(0).getPrioridade().trim());
        assertEquals(agendamento.getData().trim(), agendamentoTest.get(0).getData().trim());
        assertEquals(agendamento.getHorario().trim(), agendamentoTest.get(0).getHorario().trim());
        
        //Deleção de agendamento de teste
        pst = conexao.prepareStatement("delete from agendamento where id_agendamento = ?");
        pst.setInt(1, idAgendamento);
        pst.executeUpdate();
    }
    
    @Test
    public void testConsultacliNome() throws Exception {
        agendamentoDAO = new AgendamentoDAO();
        agendamento = new Agendamento();
        conexao = agendamentoDAO.conector();
        agendamento.setTipo("Teste");
        agendamento.setNome("Victor");
        agendamento.setDescricao("teste testConsultacliNome #89743024");
        agendamento.setEstado("Em andamento");
        agendamento.setPrioridade("Normal");
        agendamento.setData("07/01/2024");
        agendamento.setHorario("09:30");
        agendamentoDAO.cadastrarAgendamento(agendamento);
        
        PreparedStatement pst = conexao.prepareStatement("select * from agendamento where id_tipo = ? and descricao = ?");
        pst.setString(1, agendamento.getTipo());
        pst.setString(2, agendamento.getDescricao());
        ResultSet rs = pst.executeQuery();
        
        Agendamento agendamentoAux = new Agendamento(); 
        while (rs.next()) {
            agendamentoAux.setIDAgendamento(rs.getInt("id_agendamento"));
            agendamentoAux.setTipo(rs.getString("id_tipo"));
            agendamentoAux.setNome(rs.getString("representante"));
            agendamentoAux.setDescricao(rs.getString("descricao"));
            agendamentoAux.setEstado(rs.getString("estado"));
            agendamentoAux.setPrioridade(rs.getString("prioridade"));
            agendamentoAux.setData(rs.getString("data"));
            agendamentoAux.setHorario(rs.getString("horario"));
        }
        
        //Chamada do método Consultacli
        List<Agendamento> agendamentoTest = agendamentoDAO.ConsultacliNome(agendamentoAux.getData());
        
        assertNotEquals(null, agendamentoTest.get(0).getData());
        idAgendamento = agendamentoTest.get(0).getIDAgendamento();
        
        //Verificação
        assertEquals(agendamento.getTipo().trim(), agendamentoTest.get(0).getTipo().trim());
        assertEquals(agendamento.getNome().trim(), agendamentoTest.get(0).getNome().trim());
        assertEquals(agendamento.getDescricao().trim(), agendamentoTest.get(0).getDescricao().trim());
        assertEquals(agendamento.getEstado().trim(), agendamentoTest.get(0).getEstado().trim());
        assertEquals(agendamento.getPrioridade().trim(), agendamentoTest.get(0).getPrioridade().trim());
        assertEquals(agendamento.getData().trim(), agendamentoTest.get(0).getData().trim());
        assertEquals(agendamento.getHorario().trim(), agendamentoTest.get(0).getHorario().trim());
        
        //Deleção de agendamento de teste
        pst = conexao.prepareStatement("delete from agendamento where id_agendamento = ?");
        pst.setInt(1, idAgendamento);
        pst.executeUpdate();
    }
    
    @Test
    public void testAlterarAgendamento() throws Exception {
        agendamentoDAO = new AgendamentoDAO();
        conexao = agendamentoDAO.conector();
        agendamento = new Agendamento();
        agendamento.setTipo("Teste");
        agendamento.setNome("Victor");
        agendamento.setDescricao("teste testAlterarAgendamento #69812430");
        agendamento.setEstado("Aberto");
        agendamento.setPrioridade("Media");
        agendamento.setData("05/03/2023");
        agendamento.setHorario("11:45");
        agendamentoDAO.cadastrarAgendamento(agendamento);
        
        PreparedStatement pst = conexao.prepareStatement("select * from agendamento where id_tipo = ? and descricao = ?");
        pst.setString(1, agendamento.getTipo());
        pst.setString(2, agendamento.getDescricao());
        ResultSet rs = pst.executeQuery();
        
        Agendamento agendamentoAux = new Agendamento(); 
        while (rs.next()) {
            agendamentoAux.setIDAgendamento(rs.getInt("id_agendamento"));
            agendamentoAux.setTipo(rs.getString("id_tipo"));
            agendamentoAux.setNome(rs.getString("representante"));
            agendamentoAux.setDescricao(rs.getString("descricao"));
            agendamentoAux.setEstado(rs.getString("estado"));
            agendamentoAux.setPrioridade(rs.getString("prioridade"));
            agendamentoAux.setData(rs.getString("data"));
            agendamentoAux.setHorario(rs.getString("horario"));
        }
        
        //Criação de novo objeto p/ alteração
        Agendamento novoAgendamento = new Agendamento();
        novoAgendamento.setTipo("NovoTeste");
        novoAgendamento.setNome("NovoVictor");
        novoAgendamento.setDescricao("teste testAlterarAgendamento #69812430");
        novoAgendamento.setEstado("Aberto");
        novoAgendamento.setPrioridade("Media");
        novoAgendamento.setData("05/03/2023");
        novoAgendamento.setHorario("11:45");
        
        idAgendamento = agendamentoAux.getIDAgendamento();
        
        //Chamada do método alterarAgendamento
        agendamentoDAO.alterarAgendamento(novoAgendamento, idAgendamento);
        
        assertNotEquals(null, agendamentoAux.getData());
        
        
        List<Agendamento> agendamentoAtualizado = agendamentoDAO.Consultacli(idAgendamento);
        
        //Verificação
        assertEquals(novoAgendamento.getTipo().trim(), agendamentoAtualizado.get(0).getTipo().trim());
        assertEquals(novoAgendamento.getNome().trim(), agendamentoAtualizado.get(0).getNome().trim());
        assertEquals(novoAgendamento.getDescricao().trim(), agendamentoAtualizado.get(0).getDescricao().trim());
        assertEquals(novoAgendamento.getEstado().trim(), agendamentoAtualizado.get(0).getEstado().trim());
        assertEquals(novoAgendamento.getPrioridade().trim(), agendamentoAtualizado.get(0).getPrioridade().trim());
        assertEquals(novoAgendamento.getData().trim(), agendamentoAtualizado.get(0).getData().trim());
        assertEquals(novoAgendamento.getHorario().trim(), agendamentoAtualizado.get(0).getHorario().trim());
        
        //Deleção de agendamento de teste
        pst = conexao.prepareStatement("delete from agendamento where id_agendamento = ?");
        pst.setInt(1, idAgendamento);
        pst.executeUpdate();
    }
    
    @Test
    public void testExcluiAgendamento() throws Exception {
        agendamentoDAO = new AgendamentoDAO();
        conexao = agendamentoDAO.conector();
        agendamento = new Agendamento();
        agendamento.setTipo("Teste");
        agendamento.setNome("Victor");
        agendamento.setDescricao("teste testExcluiAgendamento #71269348");
        agendamento.setEstado("Aberto");
        agendamento.setPrioridade("Media");
        agendamento.setData("05/03/2023");
        agendamento.setHorario("11:45");
        agendamentoDAO.cadastrarAgendamento(agendamento);
        
        PreparedStatement pst = conexao.prepareStatement("select * from agendamento where id_tipo = ? and descricao = ?");
        pst.setString(1, agendamento.getTipo());
        pst.setString(2, agendamento.getDescricao());
        ResultSet rs = pst.executeQuery();
        
        Agendamento agendamentoAux = new Agendamento(); 
        while (rs.next()) {
            agendamentoAux.setIDAgendamento(rs.getInt("id_agendamento"));
            agendamentoAux.setTipo(rs.getString("id_tipo"));
            agendamentoAux.setNome(rs.getString("representante"));
            agendamentoAux.setDescricao(rs.getString("descricao"));
            agendamentoAux.setEstado(rs.getString("estado"));
            agendamentoAux.setPrioridade(rs.getString("prioridade"));
            agendamentoAux.setData(rs.getString("data"));
            agendamentoAux.setHorario(rs.getString("horario"));
        }
        
        idAgendamento = agendamentoAux.getIDAgendamento();
        
        agendamentoDAO.excluiAgendamento(idAgendamento);
        
        pst = conexao.prepareStatement("select * from agendamento where id_agendamento = ?");
        pst.setInt(1, idAgendamento);
        rs = pst.executeQuery();
        
        //Verificação(se o agendamento foi excluido)
        assertEquals(false, rs.next());
        
    }
}

