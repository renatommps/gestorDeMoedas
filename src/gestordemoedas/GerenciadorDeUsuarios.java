package gestordemoedas;

import java.util.LinkedHashMap;


public class GerenciadorDeUsuarios {
    
    private LinkedHashMap<String, String> usuarios;
    
    private static GerenciadorDeUsuarios instance = new GerenciadorDeUsuarios();
    
    public static GerenciadorDeUsuarios getInstance() {
        return instance;
    }
    
    private GerenciadorDeUsuarios() {
        usuarios = new LinkedHashMap<>();
    }
     
}
