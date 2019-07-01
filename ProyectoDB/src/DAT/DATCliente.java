/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import Clases2.Cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jorge
 */
public class DATCliente {
    
    DATConexion c = new DATConexion();
    public ResultSet ConsultarClientes() throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM `proyecto81`.`cliente2`";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
     public ResultSet ConsultarID() throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM `proyecto81`.`cliente2`";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
    public ResultSet ConsultarCedula(String strCedula) throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM `proyecto81`.`cliente2` WHERE CEDULA = " + strCedula ;
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
    //Aquí debe implementar los métodos de INSERCION, ACTUALIZACION Y BORRADO
    public int InsertarCliente(Cliente ObjCli) throws SQLException, ClassNotFoundException{
        int intRetorno=0;
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "INSERT InTO `proyecto81`.`cliente2` (Cedula, PrimApellido, SegApellido, PrimNombre, SegNombre, Telefono,"
                + "Direccion, eMail, Contraseña)  VALUES ( " 
                +"'" +ObjCli.getCedula()+"'"  + "," 
                +"'" +ObjCli.getPrimApellido()+"'" + "," 
                +"'" +ObjCli.getSegApellido()+"'" + "," 
                +"'" +ObjCli.getPrimNombre()+"'" + "," 
                +"'" +ObjCli.getSegNombre()+"'" + "," 
                +"'" +ObjCli.getTelefono()+"'" + "," 
                +"'" +ObjCli.getDireccion()+"'" + "," 
                +"'" +ObjCli.geteMail()+"'" + ",'" 
                + ObjCli.getContraseña() + "')" ;
        System.out.println(Sentencia);
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
    
    public int ActualizarCliente(String strCedula, String strPrimApellido, String strSegApellido, String strPrimNombre,
            String strSegNombre, String strTelefono, String strDireccion, String streMail, String strContraseña) throws SQLException, ClassNotFoundException{
        int intRetorno=0;
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "UPDATE `proyecto81`.`cliente2` set PrimApellido = '" +strPrimApellido + "'" + ","
                + " SegApellido = '" +strSegApellido +"'" + ","
                + " PrimNombre = '" +strPrimNombre +"'" + ","
                + " SegNombre = '" +strSegNombre +"'" + ","
                + " Telefono = '" +strTelefono +"'" + ","
                + " Direccion = '" +strDireccion +"'" + ","
                + " eMail = '" +streMail +"'" + ","
                + " Contraseña = '" +strContraseña +"'" + ","
                + " Cedula = '" + strCedula + 
                "' where cedula = '" + strCedula+"'";
        System.out.println(Sentencia);
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
}
