/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Clases2.Cliente;
import Clases2.Usuario;
import DAT.DATCliente;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class BLCliente {

    DATCliente ObjDatCliente = new DATCliente();
    BLUsuario ObjBLusuario = new BLUsuario();
    public static ArrayList<Cliente> ArrayCliente = new ArrayList<Cliente>();

    public ArrayList<String> ConsultarClientesDBCedula() throws SQLException, ClassNotFoundException {
        ResultSet rs;
        rs = ObjDatCliente.ConsultarClientes();
        ArrayList<String> ArrayCedulas = new ArrayList<String>();
        ResultSetMetaData rm = rs.getMetaData();
        //Recupera los campos de la tabla
        int columnCount = rm.getColumnCount();
        ArrayList<String> columns = new ArrayList<>();
        for (int i = 1; i <= columnCount; i++) {
            String columnName = rm.getColumnName(i);
            columns.add(columnName);
        }
        //
        while (rs.next()) {
            String cedula = "";
            for (String columnName : columns) {
                String value = rs.getString(columnName);
                if (columnName.equals("Cedula"))
                   cedula=value;
            }
          ArrayCedulas.add(cedula);
        }
      return ArrayCedulas; 
    }
    

    public ArrayList<Cliente> ConsultarClientesDB() throws ClassNotFoundException, SQLException {
        ResultSet rs;
        rs = ObjDatCliente.ConsultarClientes();
        ArrayList<Usuario> ArrayUsuarios = new ArrayList<Usuario>();
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
            Cliente e = new Cliente();
            for (String columnName : columns) {
                String value = rs.getString(columnName);
                if (columnName.equals("idClie")) {
                    e.setIdClie(Integer.valueOf(value));
                }
                if (columnName.equals("Cedula")) {
                    e.setCedula(value);
                    ArrayUsuarios.clear();
                    ArrayUsuarios = BLUsuario.BuscarUsuarioCedula(e.getCedula());
                    for (Usuario objUsu : ArrayUsuarios) {
                        e.AgregarUsuario(objUsu.getIdUsua(), objUsu.getCedulaAcc(), objUsu.getContraseñaAcc());
                    }
                }
                if (columnName.equals("PrimApellido")) {
                    e.setPrimApellido(value);
                }
                if (columnName.equals("SegApellido")) {
                    e.setSegApellido(value);
                }
                if (columnName.equals("PrimNombre")) {
                    e.setPrimNombre(value);
                }
                if (columnName.equals("SegNombre")) {
                    e.setSegNombre(value);
                }
                if (columnName.equals("Telefono")) {
                    e.setTelefono(value);
                }
                if (columnName.equals("Direccion")) {
                    e.setDireccion(value);
                }
                if (columnName.equals("eMail")) {
                    e.seteMail(value);
                }
                if (columnName.equals("Contraseña")) {
                    e.setContraseña(value);
                }

            }
            ArrayCliente.add(e);
        }   
        return ArrayCliente;
    }

    public int InsertarClienteDB(Cliente ObjCli) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;
        //Descompone lo que viene en el ArrayList de Cleintes par apoderlos procesar uno a uno.
        intRetorno = ObjDatCliente.InsertarCliente(ObjCli);
        return intRetorno;
    }

}
