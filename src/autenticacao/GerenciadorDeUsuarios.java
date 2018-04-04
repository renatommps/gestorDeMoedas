package autenticacao;

import gerenciadordearquivos.FileManager;
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
        List<Usuario> objs = FileManager.getInstance().readAllObjects("usuarios");
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
    
    public void salvarUsuarioAtual() {
        FileManager.getInstance().deleteObject(usuarioAtual.getID(), "usuarios");
        FileManager.getInstance().writeObject(usuarioAtual, "usuarios");
    }
    
    public boolean autenticar(String usuario, String senha) {
        Usuario match = procurarUsuario(usuario);
        boolean ret = false;

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
