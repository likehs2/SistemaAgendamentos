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
    public void logarTest() {
        try {
            obj.logar("Tom", "Tom");
        } catch(Exception e) {
            System.out.println("Test Failed");
        }     
    }
}
