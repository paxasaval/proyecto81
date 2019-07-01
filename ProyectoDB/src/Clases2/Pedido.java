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
public class Pedido {
    public int idPedi;
    public String Estado;
    public String NumMesa;
    public String TiempoEspera;
    public Cajera cajera;
    

    public Pedido() {
    }

    public Pedido(int idPedi, String Estado, String NumMesa, String TiempoEspera) {
        this.idPedi = idPedi;
        this.Estado = Estado;
        this.NumMesa = NumMesa;
        this.TiempoEspera = TiempoEspera;
        
    }
    
    public Pedido(int idPedi, String Estado, String NumMesa, String TiempoEspera, Cajera cajera) {
        this.idPedi = idPedi;
        this.Estado = Estado;
        this.NumMesa = NumMesa;
        this.TiempoEspera = TiempoEspera;
        this.cajera = cajera;
    }

    public int getIdPedi() {
        return idPedi;
    }

    public void setIdPedi(int idPedi) {
        this.idPedi = idPedi;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getNumMesa() {
        return NumMesa;
    }

    public void setNumMesa(String NumMesa) {
        this.NumMesa = NumMesa;
    }

    public String getTiempoEspera() {
        return TiempoEspera;
    }

    public void setTiempoEspera(String TiempoEspera) {
        this.TiempoEspera = TiempoEspera;
    }

    public Cajera getCajera() {
        return cajera;
    }

    public void setCajera(Cajera cajera) {
        this.cajera = cajera;
    }
    
    
}
