package br.com.senac.integrador.escola.modelos.auxiliares;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.AbstractButton;
import javax.swing.JTextField;

/**
 *
 * @author Felipe Godinho Dal Molin
 */
public abstract class Manager {

    public static int getIndexOfButtonSelectByList(ArrayList<AbstractButton> buttonsPeriodo) {
        for(AbstractButton button : buttonsPeriodo) {
            if(button.isSelected()){
                return buttonsPeriodo.indexOf(button);
            }
        }
        throw new RuntimeException("Nenhum botão selecionado.");
    }
    public static ArrayList<String> getListInputs(Component[] components) {
        List<Component> componentsList = Arrays.asList(components);
        ArrayList<JTextField> jTextFields = new ArrayList<>();
        componentsList.forEach((componente) -> {
            if(componente.getClass() == JTextField.class) {
                jTextFields.add((JTextField) componente);
            }
        });
        ArrayList<String> inputs = getInputs(jTextFields);
        return inputs;
    }
    private static ArrayList<String> getInputs(ArrayList<JTextField> list) {
        ArrayList<String> inputs = new ArrayList<>();
        list.forEach((textField) -> {
            inputs.add(textField.getText());
        });
        return inputs;
    }
}
