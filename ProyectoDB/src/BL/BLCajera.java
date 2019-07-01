/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Clases2.Cajera;
import Clases2.Cliente;
import DAT.DATCajera;
import java.sql.SQLException;

/**
 *
 * @author Jorge
 */
public class BLCajera {
    DATCajera objDATcajera = new DATCajera();
    
    public int InsertarCajeraDB(Cajera objCaje) throws SQLException, ClassNotFoundException{
        int intRetorno =0;
        //Descompone lo que viene en el ArrayList de Cleintes par apoderlos procesar uno a uno.
            intRetorno = objDATcajera.InsertarCajera(objCaje);
        return intRetorno;
    }
}
