package br.com.senac.integrador.escola.modelos;

/**
 * Definição do enum Periodo
 * Valores possíveis: MATUTINO, VESPERTINO, NOTURNO
 * @author Felipe Godinho Dal Molin
 */
public enum Periodo {
    MATUTINO {
        @Override
        String messagePeriodo() {
            return "MATUTINO";
        }
    }, VESPERTINO {
        @Override
        String messagePeriodo() {
            return "VESPERTINO";
        }
    }, NOTURNO {
        @Override
        String messagePeriodo() {
            return "NOTURNO";
        }
    };
    abstract String messagePeriodo();
}