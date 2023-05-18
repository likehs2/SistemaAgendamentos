/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 *
 */
public class JanelaLoginTest {
    JanelaLogin obj = new JanelaLogin();
 
    @Test
    public void logarTestTrue() {
        String response = obj.logar("Tom", "Tom"); 
        
        assertEquals("login realizado com sucesso", response);
    }
    
    @Test
    public void logarTestFalse() {
        String response = obj.logar("Tom", "SenhaErrada");
        
        assertEquals("usuario e/ou senha invalido", response);
    }
}
