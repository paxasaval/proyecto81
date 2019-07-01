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
public class Plato {
    public int idPlat;
    public String NombrePlato;
    public double Precio;
    public String Detalle;
    public int idRest;
    public Restaurante restaurante;
    public Cajera cajera;
    public ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
   

    public Plato() {
    }

    public Plato(int idPlat, String NombrePlato, double Precio, String Detalle) {
        this.idPlat = idPlat;
        this.NombrePlato = NombrePlato;
        this.Precio = Precio;
        this.Detalle = Detalle;
    }
    
    

    public Plato(int idPlat, String NombrePlato, double Precio, String Detalle,
            int idPedi, String Estado, String NumMesa ,String TiempoEspera) {
        this.idPlat = idPlat;
        this.NombrePlato = NombrePlato;
        this.Precio = Precio;
        this.Detalle = Detalle;
        this.cajera = cajera;
        this.pedidos.add(new Pedido(idPedi, Estado, NumMesa, TiempoEspera));
        
    }
    
    public void AgregarPedido(int idPedi, String Estado, String NumMesa, String TiempoEspera, Cajera cajera){
        this.pedidos.add(new Pedido(idPedi, Estado, NumMesa, TiempoEspera, cajera));
    }

    public int getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(int idPlat) {
        this.idPlat = idPlat;
    }

    public String getNombrePlato() {
        return NombrePlato;
    }

    public void setNombrePlato(String NombrePlato) {
        this.NombrePlato = NombrePlato;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public int getIdRest() {
        return idRest;
    }

    public void setIdRest(int idRest) {
        this.idRest = idRest;
    }

    public Cajera getCajera() {
        return cajera;
    }

    public void setCajera(Cajera cajera) {
        this.cajera = cajera;
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

   
    
    
}
