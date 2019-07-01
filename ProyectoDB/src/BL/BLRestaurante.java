/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Clases2.Plato;
import Clases2.Restaurante;
import DAT.DATRestaurante;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class BLRestaurante {

    DATRestaurante ObjDatRestaurante = new DATRestaurante();
    BLPlato ObjBLplato = new BLPlato();

    //Para el Arreglo de Objetos
    public static ArrayList<Restaurante> ArrayRestaurante = new ArrayList<Restaurante>();
    
    public void ObtenerRestaurantes(ArrayList<Restaurante> listRestaurante) throws SQLException{
        DATRestaurante objRestaurante = new DATRestaurante();
        ResultSet rs = objRestaurante.ObtenerRestaurante();
        while(rs.next()){
            Restaurante objRest = new Restaurante(rs.getInt(1), rs.getString(2), rs.getString(3), 
                    rs.getString(4), rs.getString(5));
            listRestaurante.add(objRest);
        }
        
        ResultSet rsP = objRestaurante.ObtenerPlatos();
        ArrayList<Plato> listPlatos = new ArrayList<Plato>();
        while(rsP.next()){
            Plato objPlato = new Plato(rsP.getInt(1), rsP.getString(2), rsP.getDouble(3), rsP.getString(4));
            listPlatos.add(objPlato);
        }
        for(Restaurante r : listRestaurante){
            ArrayList<Plato> listPlatoAux = new ArrayList<>();
            for(Plato p : listPlatos){
                if(r.getIdRest() == p.getIdRest()){
                    listPlatoAux.add(p);
                }
            }
            r.setPlatos(listPlatoAux);
        }
    }
    
   

    //Clase Estudiante
    public ArrayList<Restaurante> ConsultarRestauranteDB() throws ClassNotFoundException, SQLException {
        ResultSet rs;
        rs = ObjDatRestaurante.ConsultarRestaurante();
        ArrayList<Plato> ArrayPlatos = new ArrayList<Plato>();
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
            Restaurante e = new Restaurante();
            for (String columnName : columns) {
                String value = rs.getString(columnName);
                if (columnName.equals("idRest")) {
                    e.setIdRest(Integer.valueOf(value));
                }
                if (columnName.equals("CodigoRest")) {
                    e.setCodigoRest(value);
                    ArrayPlatos.clear();
                    ArrayPlatos = BLPlato.BuscarPlato(e.CodigoRest);
                    for (Plato objPlat : ArrayPlatos)
                        e.AgregarPlato(objPlat.getIdPlat(), objPlat.getNombrePlato(), objPlat.getPrecio(), objPlat.getDetalle());
                    
                }
                if (columnName.equals("NombreRes")) {
                    e.setNombreRes(value);

                }
                if (columnName.equals("HorarioRes")) {
                    e.setHorarioRes(value);
                }
                if (columnName.equals("HorarioHoras")) {
                    e.setHorarioHoras(value);
                }
            }
            ArrayRestaurante.add(e);
        }
        return ArrayRestaurante;
    }

    public Restaurante ConsultarCodigoResDB(String strCodigoRest) throws ClassNotFoundException, SQLException {
        Restaurante objRest = new Restaurante();
        ResultSet rs = ObjDatRestaurante.ConsultarCodigoRes(strCodigoRest);
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
            for (String columnName : columns) {
                String value = rs.getString(columnName);
                if (columnName.equals("idRest")) {
                    objRest.setIdRest(Integer.valueOf(value));
                }
                if (columnName.equals("NombreRes")) {
                    objRest.setNombreRes(value);
                    //DIRECCION con composicion
                }
                if (columnName.equals("HorarioRes")) {
                    objRest.setHorarioRes(value);
                }
                if (columnName.equals("HorarioHoras")) {
                    objRest.setHorarioHoras(value);
                }
                if (columnName.equals("CodigoRest")) {
                    objRest.setHorarioHoras(value);
                }
                ArrayPlato.clear();
                ArrayPlato = BLPlato.BuscarPlato(objRest.getCodigoRest());
                for (Plato objPlat : ArrayPlato) {
                    objRest.AgregarPlato(objPlat.getIdPlat(), objPlat.getNombrePlato(), objPlat.getPrecio(),
                             objPlat.getDetalle());
                }
            }
        }
        return objRest;
    }

    public int InsertarRestauranteDB(Restaurante objRest) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;
        //Descompone lo que viene en el ArrayList de Cleintes par apoderlos procesar uno a uno.
        intRetorno = ObjDatRestaurante.InsertarRestaurante(objRest);
        return intRetorno;
    }
}
