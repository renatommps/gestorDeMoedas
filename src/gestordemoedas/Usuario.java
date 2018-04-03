/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestordemoedas;

import gestordemoedas.Identificable;
import gestordemoedas.Wallet;
import java.io.Serializable;

/**
 *
 * @author Rafael
 */
public class Usuario implements Serializable, Identificable {
    
    private String nome;
    private String senha;
    private Wallet carteira;
    
    public Usuario(String _nome, String _senha) {
        nome = _nome;
        senha = _senha;
        carteira = new Wallet();
    }
    
    public String getID() {
        return nome;
    }
    public String getNome() {
        return nome;
    }
    public String getSenha() {
        return senha;
    }
    public Wallet getCarteira() {
        return carteira;
    }
    
}
