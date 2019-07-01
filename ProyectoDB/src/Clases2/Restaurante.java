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
public class Restaurante {
    public int idRest;
    public String NombreRes;
    public String HorarioRes;
    public String HorarioHoras;
    public String CodigoRest;
    public ArrayList<Plato> platos = new ArrayList<Plato>();
    private ArrayList<Restaurante> Restaurantes;

    public Restaurante() {
    }

    public Restaurante(int idRest, String NombreRes, String HorarioRes, String HorarioHoras, String CodigoRest) {
        this.idRest = idRest;
        this.NombreRes = NombreRes;
        this.HorarioRes = HorarioRes;
        this.HorarioHoras = HorarioHoras;
        this.CodigoRest = CodigoRest;
    }
    
    public Restaurante(int idRest, String NombreRes, String HorarioRes, String HorarioHoras, String CodigoRest,
            int idPlat, String NombrePlato, double Precio, String Detalle) {
        this.idRest = idRest;
        this.NombreRes = NombreRes;
        this.HorarioRes = HorarioRes;
        this.HorarioHoras = HorarioHoras;
        this.CodigoRest = CodigoRest;
        this.platos.add(new Plato (idPlat, NombrePlato, Precio, Detalle));
    }
    
    public void AgregarPlato(int idPlat, String NombrePlato, double Precio, String Detalle){
        this.platos.add(new Plato(idPlat, NombrePlato,Precio, Detalle));
    }

    public int getIdRest() {
        return idRest;
    }

    public void setIdRest(int idRest) {
        this.idRest = idRest;
    }

    public String getNombreRes() {
        return NombreRes;
    }

    public void setNombreRes(String NombreRes) {
        this.NombreRes = NombreRes;
    }

    public String getHorarioRes() {
        return HorarioRes;
    }

    public void setHorarioRes(String HorarioRes) {
        this.HorarioRes = HorarioRes;
    }

    public String getHorarioHoras() {
        return HorarioHoras;
    }

    public void setHorarioHoras(String HorarioHoras) {
        this.HorarioHoras = HorarioHoras;
    }

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(ArrayList<Plato> platos) {
        this.platos = platos;
    }

    public String getCodigoRest() {
        return CodigoRest;
    }

    public void setCodigoRest(String CodigoRest) {
        this.CodigoRest = CodigoRest;
    }

    public ArrayList<Restaurante> getRestaurantes() {
        return Restaurantes;
    }

    public void setRestaurantes(ArrayList<Restaurante> Restaurantes) {
        this.Restaurantes = Restaurantes;
    }
    
    @Override
    public String toString() {
        return String.format("%s", NombreRes);
    }
    
}
