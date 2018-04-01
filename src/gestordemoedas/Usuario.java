/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordemoedas;

import java.io.Serializable;

/**
 *
 * @author Rafael
 */
public class Usuario implements Serializable {
    
    private String nome;
    private String senha;
    
    public Usuario(String _nome, String _senha) {
        nome = _nome;
        senha = _senha;
    }
    
    public String getNome() {
        return nome;
    }
    public String getSenha() {
        return senha;
    }
    
}
