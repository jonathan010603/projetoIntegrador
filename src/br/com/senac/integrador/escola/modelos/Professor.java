package br.com.senac.integrador.escola.modelos;

/**
 * Definicação da classe Professor
 * @author Felipe Godinho Dal Molin
 */
public class Professor extends Pessoa {
    
    private String formacao;
    private String historicoProfisional;
    
    public Professor(Pessoa pessoa, String formacao, String historicoProfissonal) {
        super(
            pessoa.getNome(),pessoa.getCpf(), 
            pessoa.getRg(), pessoa.getTelefone(), 
            pessoa.getEmail(), pessoa.getDeficiencia(), 
            pessoa.getEstadoCivil(), pessoa.getEndereco(), 
            pessoa.getGenero(), pessoa.getCorRaca());
        this.formacao = formacao;
        this.historicoProfisional = historicoProfissonal;
    }

    public String getFormacao() {
        return formacao;
    }
    public String getHistoricoProfisional() {
        return historicoProfisional;
    }
}