package br.com.senac.integrador.escola.modelos.auxiliares;

/**
 * Classe Regex de expresões regulares
 * @author Felipe Godinho Dal Molin
 */
public abstract class Regex {
    // 55 (048) 99999-9999
    public static final String TELEFONE = "[0-9]{2} \\([0-9]{3}\\) [0-9]{5}-[0-9]{4}";
    public static final String CPF = "[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}";
    public static final String RG = "[0-9]{1,3}.[0-9]{3}.[0-9]{3}";
}