/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases2;

/**
 *
 * @author Jorge
 */
public class Usuario {
    public int idUsua;
    public String CedulaAcc;
    public String ContraseñaAcc;
    public Cliente cliente;

    public Usuario() {
    }

    public Usuario(int idUsua, String CedulaAcc, String ContraseñaAcc) {
        this.idUsua = idUsua;
        this.CedulaAcc = CedulaAcc;
        this.ContraseñaAcc = ContraseñaAcc;
    }

    public int getIdUsua() {
        return idUsua;
    }

    public void setIdUsua(int idUsua) {
        this.idUsua = idUsua;
    }

    public String getCedulaAcc() {
        return CedulaAcc;
    }

    public void setCedulaAcc(String CedulaAcc) {
        this.CedulaAcc = CedulaAcc;
    }

    public String getContraseñaAcc() {
        return ContraseñaAcc;
    }

    public void setContraseñaAcc(String ContraseñaAcc) {
        this.ContraseñaAcc = ContraseñaAcc;
    }
    
    
}
