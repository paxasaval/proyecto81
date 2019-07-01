/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases2;

import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class Cliente {
    public int idClie;
    public String Cedula;
    public String PrimApellido;
    public String SegApellido;
    public String PrimNombre;
    public String SegNombre;
    public String Telefono;
    public String Direccion;
    public String eMail;
    public String Contraseña;
    public ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

    public Cliente() {
    }

    public Cliente(int idClie, String Cedula, String PrimApellido, String SegApellido, String PrimNombre, String SegNombre,
            String Telefono, String Direccion, String eMail, String Contraseña) {
        this.idClie = idClie;
        this.Cedula = Cedula;
        this.PrimApellido = PrimApellido;
        this.SegApellido = SegApellido;
        this.PrimNombre = PrimNombre;
        this.SegNombre = SegNombre;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.eMail = eMail;
        this.Contraseña = Contraseña;
    }
    
//    public Cliente(int idClie, String Cedula, String PrimApellido, String SegApellido, String PrimNombre, String SegNombre,
//            String Telefono, String Direccion, String eMail, String Contraseña,int idUsua, String CedulaAcc, String claveAcceso) {
//        this.idClie = idClie;
//        this.Cedula = Cedula;
//        this.PrimApellido = PrimApellido;
//        this.SegApellido = SegApellido;
//        this.PrimNombre = PrimNombre;
//        this.SegNombre = SegNombre;
//        this.Telefono = Telefono;
//        this.Direccion = Direccion;
//        this.eMail = eMail;
//        this.Contraseña = Contraseña;
//        this.ArrayUsuario.add(new Usuario(idUsua, CedulaAcc, claveAcceso));
//    }
    
    public Cliente(int idClie, String Cedula, String PrimApellido, String SegApellido, String PrimNombre, String SegNombre,
            String Telefono, String Direccion, String eMail, String Contraseña,int idUsua, String CedulaAcc, String ContraseñaAcc) {
        this.idClie = idClie;
        this.Cedula = Cedula;
        this.PrimApellido = PrimApellido;
        this.SegApellido = SegApellido;
        this.PrimNombre = PrimNombre;
        this.SegNombre = SegNombre;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.eMail = eMail;
        this.Contraseña = Contraseña;
        this.usuarios.add(new Usuario(idUsua, CedulaAcc, ContraseñaAcc));
    }
    
    public void AgregarUsuario(int idUsua, String CedulaAcc, String ContraseñaAcc){
        this.usuarios.add(new Usuario(idUsua, CedulaAcc,ContraseñaAcc));
    }

    public int getIdClie() {
        return idClie;
    }

    public void setIdClie(int idClie) {
        this.idClie = idClie;
    }

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getPrimApellido() {
        return PrimApellido;
    }

    public void setPrimApellido(String PrimApellido) {
        this.PrimApellido = PrimApellido;
    }

    public String getSegApellido() {
        return SegApellido;
    }

    public void setSegApellido(String SegApellido) {
        this.SegApellido = SegApellido;
    }

    public String getPrimNombre() {
        return PrimNombre;
    }

    public void setPrimNombre(String PrimNombre) {
        this.PrimNombre = PrimNombre;
    }

    public String getSegNombre() {
        return SegNombre;
    }

    public void setSegNombre(String SegNombre) {
        this.SegNombre = SegNombre;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    
}
