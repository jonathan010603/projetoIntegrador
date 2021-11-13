package br.com.senac.integrador.escola.modelos;

import br.com.senac.integrador.escola.modelos.enums.Genero;
import br.com.senac.integrador.escola.modelos.enums.CorRaca;
import br.com.senac.integrador.modelos.enums.EstadoCivil;

/**
 * Definicação da classe Pessoa
 * @author Felipe Godinho Dal Molin
 */
public class Pessoa {
    
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private String email;
    private String deficiencia;
    private EstadoCivil estadoCivil;
    private Endereco endereco;
    private Genero genero;
    private CorRaca cor;
    
    public Pessoa
        (String nome, String cpf, String rg, String telefone, String email, String deficiencia, EstadoCivil estadoCivil, Endereco endereco, Genero genero, CorRaca cor) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.email = email;
        this.deficiencia = deficiencia;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
        this.genero = genero;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getRg() {
        return rg;
    }
    public String getTelefone() {
        return telefone;
    }
    public String getEmail() {
        return email;
    }
    public String getDeficiencia() {
        return deficiencia;
    }
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }
    public Endereco getEndereco() {
        return endereco;
    }  
    public Genero getGenero() {
        return genero;
    }
    public CorRaca getCorRaca() {
        return cor;
    }   
}