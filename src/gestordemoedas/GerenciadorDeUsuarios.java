package gestordemoedas;

import java.util.ArrayList;
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
    
    public Usuario procurarUsuario(String id) {
        Usuario match = (Usuario) FileManager.getInstance().readObject(id, "usuarios");
        return match;
    }
    
    public void salvarUsuario(Usuario u) {
        FileManager.getInstance().writeObject(u, "usuarios");
    }
    
    public boolean autenticar(String usuario, String senha) {
        Usuario match = null;
        boolean ret = false;
//        List<Usuario> usuarios = carregarUsuarios();
//        for (Usuario u : usuarios) {
//            if (u.getID().equalsIgnoreCase(usuario)) {
//                match = u;
//            }
//        }
        match = procurarUsuario(usuario);
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
