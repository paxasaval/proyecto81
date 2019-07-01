/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author USUARIO
 */
public class Expresiones {

    public boolean mailValiodo(String email) {
        Pattern pat = Pattern.compile("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@"
                + "[a-z0-9-]+(\\.[a-z0-9-]+)*(\\.[a-z]{2,4})$");
        Matcher mat = pat.matcher(email);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean numeroCelular(String celular) {
        Pattern pat = Pattern.compile("[0-9]{10}");
        Matcher mat = pat.matcher(celular);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean numeroCedula(String cedula) {
        Pattern pat = Pattern.compile("[0-9]{10}");
        Matcher mat = pat.matcher(cedula);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean NumeroCasa(String celular) {
        Pattern pat = Pattern.compile("[0-9-]{5}");
        Matcher mat = pat.matcher(celular);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean numeroTarjeta(String numTarjeta) {
        Pattern pat = Pattern.compile("[0-9]{16}");
        Matcher mat = pat.matcher(numTarjeta);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean contrasenia(String pass) {
        Pattern pat = Pattern.compile("[a-zA-z0-9]{8,20}");
        Matcher mat = pat.matcher(pass);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }

}
