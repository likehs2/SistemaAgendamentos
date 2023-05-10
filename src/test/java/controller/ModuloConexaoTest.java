/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

/**
 *
 * @author Victor Hugo
 */
public class ModuloConexaoTest {
    
    @Test
    public void ConnectionShouldNotBeNull() {
        Connection conexao = ModuloConexao.conector();
        assertNotNull(conexao, "Conexao should not be null");
    }
}
