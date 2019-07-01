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
public class Cajera {
    public int idCaje;
    public String Nombre;
    public String Apellido;
    public String NumCaja;
    public String Codigo;

    public Cajera() {
    }

    public Cajera(int idCaje, String Nombre, String Apellido, String NumCaja, String Codigo) {
        this.idCaje = idCaje;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.NumCaja = NumCaja;
        this.Codigo = Codigo;
    }

    public int getIdCaje() {
        return idCaje;
    }

    public void setIdCaje(int idCaje) {
        this.idCaje = idCaje;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getNumCaja() {
        return NumCaja;
    }

    public void setNumCaja(String NumCaja) {
        this.NumCaja = NumCaja;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
    
    
}
