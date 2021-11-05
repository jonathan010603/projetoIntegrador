package br.com.senac.integrador.escola.modelos.auxiliares;

import javax.swing.JFrame;

/**
 * Definição da classe auxiliar abstrata JFrameManager
 * @author Felipe Godinho Dal Molin
 */
public abstract class JFrameManager {
    public static void changeJFrame(JFrame origin, JFrame target) {
        origin.setVisible(false);
        target.setVisible(true);
    }
}