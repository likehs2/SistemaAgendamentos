/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import static org.mockito.Mockito.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Agendamento;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author PICHAU
 */
public class AgendamentoDAOTest {
     
    private AgendamentoDAO agendamentoDAO;

    @Mock
    private Connection conexao;
            
    @Mock
    private Agendamento agendamento;

    @Mock
    private PreparedStatement pst;

    @Mock
    private ResultSet rs;
    
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        agendamentoDAO = new AgendamentoDAO();
    }
    
    @Test
    public void testRead() throws SQLException {
        AgendamentoDAO dao = new AgendamentoDAO();
        List<Agendamento> agendamentos = dao.Read();

        assertNotNull(agendamentos);
        
        Agendamento agendamento1 = agendamentos.get(0);
        assertEquals("Profissional".trim(), agendamento1.getTipo().trim());
        assertEquals("sander".trim(), agendamento1.getNome().trim());
        assertEquals("10/06/2022".trim(), agendamento1.getData().trim());
        assertEquals("08:58".trim(), agendamento1.getHorario().trim());
        assertEquals("Normal".trim(), agendamento1.getPrioridade().trim());
        assertEquals("Aberto".trim(), agendamento1.getEstado().trim());
        assertEquals("teste".trim(), agendamento1.getDescricao().trim());
        
        Agendamento agendamento2 = agendamentos.get(1);
        assertEquals("Profissional".trim(), agendamento2.getTipo().trim());
        assertEquals("Sanderson".trim(), agendamento2.getNome().trim());
        assertEquals("15/06/2022".trim(), agendamento2.getData().trim());
        assertEquals("10:30".trim(), agendamento2.getHorario().trim());
        assertEquals("Normal".trim(), agendamento2.getPrioridade().trim());
        assertEquals("Aberto".trim(), agendamento2.getEstado().trim());
        assertEquals("Teste 2".trim(), agendamento2.getDescricao().trim());
    }

//    @Test
//    public void testRead() throws SQLException {
//        agendamento = new Agendamento();
//        List<Agendamento> agendamentosEsperados = new ArrayList<>();
//        agendamento.setIDAgendamento(1);
//        agendamento.setNome("Filomeno");
//        agendamento.setData("18/02/2023");
//        agendamento.setHorario("10:00");
//        agendamento.setPrioridade("Urgente");
//        agendamento.setEstado("Em andamento");
//        agendamento.setDescricao("Lorem ipsum");
//        agendamento.setTipo("Pessoal");
//        
//        agendamentosEsperados.add(agendamento);
//
//        when(conexao.prepareStatement(any(String.class))).thenReturn(pst);
//        when(pst.executeQuery()).thenReturn(rs);
//        when(rs.next()).thenReturn(true).thenReturn(false);
//        when(rs.getInt("id_agendamento")).thenReturn(1);
//        when(rs.getString("representante")).thenReturn("Filomeno");
//        when(rs.getString("data")).thenReturn("18/02/2023");
//        when(rs.getString("horario")).thenReturn("10:00");
//        when(rs.getString("prioridade")).thenReturn("Urgente");
//        when(rs.getString("estado")).thenReturn("Em andamento");
//        when(rs.getString("descricao")).thenReturn("Lorem ipsum");
//        when(rs.getString("id_tipo")).thenReturn("Pessoal");
//
//        List<Agendamento> agendamentos = agendamentoDAO.Read(conexao);
//
//        verify(conexao, times(1)).prepareStatement(any(String.class));
//        verify(pst, times(1)).executeQuery();
//        verify(rs, times(2)).next();
//        verify(rs, times(1)).getInt("id_agendamento");
//        verify(rs, times(1)).getString("representante");
//        verify(rs, times(1)).getString("data");
//        verify(rs, times(1)).getString("horario");
//        verify(rs, times(1)).getString("prioridade");
//        verify(rs, times(1)).getString("estado");
//        verify(rs, times(1)).getString("descricao");
//        verify(rs, times(1)).getString("id_tipo");
//
//        assertEquals(agendamentosEsperados, agendamentos);
//    }

//    @Test
//    public void testCadastrarAgendamento() throws SQLException {
//
//        String cmdsql = "insert into agendamento (id_tipo,representante,descricao,estado,prioridade,data,horario)VALUES(?,?,?,?,?,?,?);";
//
//        Connection conexao = mock(Connection.class);
//
//        when(agendamento.getTipo()).thenReturn("Tipo de Agendamento");
//        when(agendamento.getNome()).thenReturn("Nome do Representante");
//        when(agendamento.getDescricao()).thenReturn("Descrição do Agendamento");
//        when(agendamento.getEstado()).thenReturn("Estado do Agendamento");
//        when(agendamento.getPrioridade()).thenReturn("Prioridade do Agendamento");
//        when(agendamento.getData()).thenReturn("Data do Agendamento");
//        when(agendamento.getHorario()).thenReturn("Horário do Agendamento");
//
//        when(conexao.prepareStatement(cmdsql)).thenReturn(pst);
//        when(pst.executeUpdate()).thenReturn(1);
//
//        agendamentoDAO.cadastrarAgendamento(agendamento, conexao);
//
//        verify(pst, times(1)).executeUpdate();
//        verify(conexao, times(1)).prepareStatement(cmdsql);
//    }
}
