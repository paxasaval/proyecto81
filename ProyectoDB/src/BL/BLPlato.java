/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import static BL.BLRestaurante.ArrayRestaurante;
import Clases2.Plato;
import Clases2.Restaurante;
import DAT.DATPlato;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class BLPlato {
    public static ArrayList<Plato>  ArrayPlato = new ArrayList<Plato>();
        static DATPlato ObjDatPlato = new DATPlato();
        static Plato ObjPlat = new Plato();
    
    public static ArrayList<Plato> BuscarPlato(String CodigoRest) throws ClassNotFoundException, SQLException {
        ResultSet rs;
        rs = ObjDatPlato.ConsultarPlatoRestaurante(CodigoRest);
        ArrayList<Plato> ArrayPlato = new ArrayList<Plato>();
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
            Plato e = new Plato();
            for (String columnName : columns){
                String value = rs.getString(columnName);
                if (columnName.equals("idPlat"))
                    e.setIdPlat(Integer.parseInt(value));
                if (columnName.equals("NombrePlato"))
                    e.setNombrePlato(value);
                if (columnName.equals("Precio"))
                    e.setPrecio(Integer.parseInt(value));
                if (columnName.equals("Detalle"))
                    e.setDetalle(value);
            }
            ArrayPlato.add(e);
        }
        return ArrayPlato;
    }
    
    public ArrayList<Plato> ConsultarPlatoDB() throws ClassNotFoundException, SQLException {
        ResultSet rs;
        rs = ObjDatPlato.ObtenerPlatos();
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
            Plato e = new Plato();
            for (String columnName : columns) {
                String value = rs.getString(columnName);
                if (columnName.equals("idPlat")) {
                    e.setIdPlat(Integer.valueOf(value));
                }
                if (columnName.equals("NombrePlato")) {
                    e.setNombrePlato(value);
                }
                if (columnName.equals("Precio")) {
                    e.setPrecio(Integer.valueOf(value));
                }
                if (columnName.equals("Detalle")) {
                    e.setDetalle(value);
                }
            }
            ArrayPlato.add(e);
        }
        return ArrayPlato;
    }
    
    public static void InsertarPlato(Restaurante objRestaurante) throws ClassNotFoundException, SQLException{
        Plato ObjPlat = new Plato();
        ObjPlat = objRestaurante.platos.get(objRestaurante.platos.size()-1);
        ObjDatPlato.InsertarPlato1(ObjPlat, objRestaurante.idRest);
    }
}

