/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import bean.Usuario;

/**
 *
 * @author Guilherme Gehling
 */
public class Controle {

    private static final Controle INSTANCE = new Controle();
    public static int usuario;

    private Controle() {
    }

    public static Controle getINSTANCE() {
        return INSTANCE;
    }

    public static void setUsuario(int usuraio) {
        usuario = usuraio;
    }

    public static int getUsuario() {
        return usuario;
    }
}
