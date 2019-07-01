/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import Clases2.Restaurante;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jorge
 */
public class DATRestaurante {
    DATConexion c = new DATConexion();
    
    public ResultSet ObtenerRestaurante() throws SQLException {
        try {
            Statement consulta = c.getConnection().createStatement();
            String sql = "SELECT * FROM `proyecto81`.`restaurante`";
            return consulta.executeQuery(sql);
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
        
        
    }
    
    public ResultSet ObtenerPlatos() throws SQLException {
        try {
            Statement consulta = c.getConnection().createStatement();
            String sql = "SELECT * FROM `proyecto81`.`plato`";
            return consulta.executeQuery(sql);
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
    }
    public ResultSet ConsultarRestaurante() throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM `proyecto81`.`restaurante`";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
//     public ResultSet ConsultarID() throws ClassNotFoundException, SQLException
//    {
//        Statement st = c.AbrirConexion().createStatement();
//        String Sentencia = "SELECT * FROM cliente";
//        ResultSet rs = st.executeQuery(Sentencia);
//        return rs;
//    }
    
    public ResultSet ConsultarCodigoRes(String strCodigoRest) throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT idRest,NombreRes,HorarioRes,HorarioHoras FROM proyecto81.restaurante where CodigoRest='" + strCodigoRest +"'" ;
        System.out.println(Sentencia);
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
    //Aquí debe implementar los métodos de INSERCION, ACTUALIZACION Y BORRADO
    public int InsertarRestaurante(Restaurante objRest) throws SQLException, ClassNotFoundException{
        int intRetorno=0;
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "INSERT InTO `proyecto81`.`restaurante`(NombreRes, HorarioRes, HorarioHoras, CodigoRest)  VALUES ( " 
                +"'" +objRest.getNombreRes()+"'"  + "," 
                +"'" +objRest.getHorarioRes()+"'"  + "," 
                +"'" +objRest.getHorarioHoras()+"'" + ",'" 
                + objRest.getCodigoRest()+ "')" ;
        System.out.println(Sentencia);
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
    
    public int ActualizarRestaurante(String strNombreRes, String strHorarioRes, String strHorarioHoras, String strCodigoRest) throws SQLException, ClassNotFoundException{
        int intRetorno=0;
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "UPDATE `proyecto81`.`restaurante` set NombreRes = '" +strNombreRes + "'" + ","
                + " HorarioRes = '" +strHorarioRes +"'" + ","
                + " HorarioRes = '" +strHorarioHoras +"'" + ","
                + " CodigoRest = '" + strCodigoRest + 
                "' where NombreRes = '" + strNombreRes+"'";
        System.out.println(Sentencia);
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
}
