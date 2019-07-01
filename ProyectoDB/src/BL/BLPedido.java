/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Clases2.Pedido;
import DAT.DATPedido;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class BLPedido {
    
    DATPedido objDATpedido = new DATPedido();
    public ArrayList<Pedido> ConsultarPedidoPlato() throws ClassNotFoundException, SQLException {
        ResultSet rs;
        rs = objDATpedido.ConsultarPedidos();
        ArrayList<Pedido> ArrayPedidos = new ArrayList<Pedido>();
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columns.add(columnName);
        }
        //Envia los datos al objeto
        while (rs.next()) {

            Pedido e = new Pedido();
            for (String columnName : columns) {
                String value = rs.getString(columnName);
                if (columnName.equals("idPedi")) {
                    e.setIdPedi(Integer.valueOf(value));
                    if (columnName.equals("Estado")) {
                        e.setEstado(value);
                        //DIRECCION con composicion
//                        ArrayDirecciones.clear();
//                        ArrayDirecciones = BLDireccion.BuscarDirecciones(e.getCedula());
//                        for (Direccion objDir : ArrayDirecciones) {
//                            e.AgragarDireccion(objDir.getIdDir(), objDir.getCalle(), objDir.getNumero());
//                        }
                        //DIRECCION con Agregacion
//                      e.direcciones = ArrayDirecciones;
                    }
                    if (columnName.equals("NumMesa")) {
                        e.setNumMesa(value);
                    }
                    if (columnName.equals("TiempoEspera")) {
                        e.setTiempoEspera(value);
                    }
                }

                //DIRECCION con Agregacion
                // e.direcciones = BLDireccion.BuscarDirecciones(e.getCedula());
                ArrayPedidos.add(e);
            }
            return ArrayPedidos;
        }
        return null;

    }
}
