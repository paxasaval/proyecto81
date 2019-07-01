/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import Clases2.Cliente;
import Clases2.Usuario;
import DAT.DATCliente;
import DAT.DATUsuario;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Jorge
 */
public class BLUsuario {
    public static ArrayList<Usuario> ArrayUsuarios = new ArrayList<Usuario>();
    static DATUsuario ObjDatUsuario = new DATUsuario();
    static Usuario objUsua = new Usuario();
    
    
    public static ArrayList<Usuario> BuscarUsuarioCedula(String Cedula) throws ClassNotFoundException, SQLException {
        ResultSet rs;
        rs = ObjDatUsuario.ConsultarClienteCedula(Cedula);
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
            Usuario e = new Usuario();
            for (String columnName : columns){
                String value = rs.getString(columnName);
                if (columnName.equals("idUsua"))
                    e.setIdUsua(Integer.parseInt(value));
                if (columnName.equals("CedulaAcc"))
                    e.setCedulaAcc(value);
                if (columnName.equals("ContraseñaAcc"))
                    e.setContraseñaAcc(value);
            }
            ArrayUsuarios.add(e);
        }
        return ArrayUsuarios;
    }
    //Aquí debe implementar los métodos de INSERCION, ACTUALIZACION Y BORRADO
    /*
    public int InsertarUsuarioDB(Cliente objCli) throws SQLException, ClassNotFoundException{
        int intRetorno = 0;
        Usuario objUsua = new Usuario();
        //Descompone lo que viene en el ArrayList de Cleintes par apoderlos procesar uno a uno.
        objUsua = objCli.usuarios.get(objCli.usuarios.size()-1);
        intRetorno = ObjDatUsuario.InsertarUsuario(objUsua, intRetorno);
        return intRetorno;
    }
    */
    public static void InsertarUsuarioDB2(Cliente objCli) throws SQLException, ClassNotFoundException{
        Usuario objUsua = new Usuario();
       
        //Descompone lo que viene en el ArrayList de Cleintes par apoderlos procesar uno a uno.
        objUsua = objCli.usuarios.get(objCli.usuarios.size()-1);
        ObjDatUsuario.InsertarUsuario2(objUsua, objCli.idClie);
    }
}
