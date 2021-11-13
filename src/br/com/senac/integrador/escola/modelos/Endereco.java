package br.com.senac.integrador.escola.modelos;

/**
 * Definição da classe Endereco
 * @author Felipe Godinho Dal Molin
 */
public class Endereco {
    private String estado;
    private String cidade;
    private String bairro;
    private int numero;
    private String endereco;

    public Endereco(String estado, String cidade, String bairro, int numero, String endereco) {
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.numero = numero;
        this.endereco = endereco;
    }
    
    public String getEstado() {
        return estado;
    }
    public String getCidade() {
        return cidade;
    }
    public String getBairro() {
        return bairro;
    }
    public int getNumero() {
        return numero;
    }
    public String getEndereco() {
        return endereco;
    }
}