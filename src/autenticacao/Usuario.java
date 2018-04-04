package autenticacao;

import gerenciadordearquivos.Identificable;
import gestordemoedas.model.Wallet;
import java.io.Serializable;


public class Usuario implements Serializable, Identificable {
    
    private final String nome;
    private final String senha;
    private final Wallet carteira;
    
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
