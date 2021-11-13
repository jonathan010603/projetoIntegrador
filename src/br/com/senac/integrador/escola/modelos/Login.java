package br.com.senac.integrador.escola.modelos;

import br.com.senac.integrador.escola.modelos.enums.TipoLogin;

/**
 * Definição da classe Login
 * @author Felipe Godinho Dal Molin
 */
public class Login {
    private String usuario;
    private String senha;
    private TipoLogin tipo;

    public Login(String usuario, String senha, TipoLogin tipo) {
        this.usuario = usuario;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getUsuario() {
        return usuario;
    }
    public String getSenha() {
        return senha;
    }
    public TipoLogin getTipo() {
        return tipo;
    }
}