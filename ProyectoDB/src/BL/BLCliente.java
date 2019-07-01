/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Clases2.Cliente;
import DAT.DATCliente;
import java.sql.SQLException;

/**
 *
 * @author Jorge
 */
public class BLCliente {
    DATCliente ObjDatCliente = new DATCliente();
    BLUsuario ObjBLusuario = new BLUsuario();
    
    public int InsertarClienteDB(Cliente ObjCli) throws SQLException, ClassNotFoundException{
        int intRetorno =0;
        //Descompone lo que viene en el ArrayList de Cleintes par apoderlos procesar uno a uno.
            intRetorno = ObjDatCliente.InsertarCliente(ObjCli);
        return intRetorno;
    }  
    
}
