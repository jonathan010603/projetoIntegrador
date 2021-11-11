package br.com.senac.integrador.escola.modelos;

import br.com.senac.integrador.escola.modelos.enums.CorRaca;
import br.com.senac.integrador.escola.modelos.enums.Genero;
import br.com.senac.integrador.modelos.enums.EstadoCivil;

/**
 * Definicação da classe Professor
 * @author Felipe Godinho Dal Molin
 */
public class Professor extends Pessoa {
    
    private Professor(String nome, String cpf, String rg, String telefone, String email, String deficiencia, EstadoCivil estadoCivil, Endereco endereco, Genero genero, CorRaca cor) {
        super(nome, cpf, rg, telefone, email, deficiencia, estadoCivil, endereco, genero, cor);
    }
    public Professor(Pessoa pessoa) {
        this(
            pessoa.getNome(), 
            pessoa.getCpf(), 
            pessoa.getRg(), 
            pessoa.getTelefone(), 
            pessoa.getEmail(), 
            pessoa.getDeficiencia(), 
            pessoa.getEstadoCivil(), 
            pessoa.getEndereco(), pessoa.getGenero(), pessoa.getCorRaca());
    }
    
}