package br.com.senac.integrador.escola.modelos;

/**
 * Definição da classe Aluno
 * @author Felipe Godinho Dal Molin
 */
public class Aluno {
    public String nome;
    public String cpf;
    public Periodo periodo;

    /**
     *
     * @param nome
     * @param cpf
     * @param periodo
     */
    public Aluno(String nome, String cpf, Periodo periodo) {
        this.nome = nome;
        this.cpf = cpf;
        this.periodo = periodo;
    }

    @Override
    public String toString() {
        String message = String.format(
        "[Nome: %s, CPF: %s, Período: %s]", 
        nome, cpf, periodo.messagePeriodo());
        return message;
    }
    
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public Periodo getPeriodo() {
        return periodo;
    }
}