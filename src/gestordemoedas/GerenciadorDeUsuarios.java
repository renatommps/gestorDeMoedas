package gestordemoedas;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;


public class GerenciadorDeUsuarios {
    
    private static GerenciadorDeUsuarios instance = new GerenciadorDeUsuarios();
    
    public static GerenciadorDeUsuarios getInstance() {
        return instance;
    }
    
    private Usuario usuarioAtual;
    
    private GerenciadorDeUsuarios() {
    }
    
    public Usuario getUsuarioAtual() {
        return usuarioAtual;
    }
    
    public List<Usuario> carregarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        List<Object> objs = FileManager.getInstance().readAllObjects("usuarios");
        objs.forEach((o) -> {
            usuarios.add((Usuario) o);
        });
        return usuarios;
    }
    
    public void salvarUsuario(Usuario u) {
        FileManager.getInstance().writeObject(u, "usuarios");
    }
    
    public boolean autenticar(String usuario, String senha) {
        List<Usuario> usuarios = carregarUsuarios();
        Usuario match = null;
        boolean ret = false;
        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(usuario)) {
                match = u;
            }
        }
        if (match == null) {
            match = new Usuario(usuario, senha);
            salvarUsuario(match);
            usuarioAtual = match;
            ret = true;
        } else if (match.getSenha().equalsIgnoreCase(senha)) {
            usuarioAtual = match;
            ret = true;
        }
        return ret;
    }
     
}
