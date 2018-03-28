/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordemoedas;

import java.util.LinkedHashMap;

/**
 *
 * @author 09700844633
 */
public class GerenciadorDeUsuarios {
    
    private LinkedHashMap<String, String> usuarios;
    
    private static GerenciadorDeUsuarios instance = new GerenciadorDeUsuarios();
    
    public static GerenciadorDeUsuarios getInstance() {
        return instance;
    }
    
    private GerenciadorDeUsuarios() {
        
        usuarios = new LinkedHashMap<String, String>();
        
    }
    
    
    
}
