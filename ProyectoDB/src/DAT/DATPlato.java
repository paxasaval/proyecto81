/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import Clases2.Plato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jorge
 */
public class DATPlato {
    static DATConexion c = new DATConexion();
//    public static ResultSet ConsultarPlatoRestaurante(String CodigoRest) throws ClassNotFoundException, SQLException
//    {
//        Statement st = c.AbrirConexion().createStatement();
//        String Sentencia = "select restaurante.idRest,NombreRes,HorarioRes,HorarioHoras,CodigoRest from plato, restaurante "
//                + "where plato.idPlat = restaurante.idPlat and restaurante.CodigoRest = "+CodigoRest +" order by 1";
//        System.out.println(Sentencia);
//        ResultSet rs = st.executeQuery(Sentencia);
//        return rs;
//    }
    
    public static ResultSet ConsultarPlatoRestaurante(String CodigoRest) throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "select idPlat,plato.idRest,NombrePlato,Precio,Detalle from proyecto81.restaurante, proyecto81.plato "
                + "where restaurante.idRest = plato.idRest and restaurante.CodigoRest = "+"'"+CodigoRest +"'"+" order by 1";
//        System.out.println(Sentencia);
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
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
    
     public static int InsertarPlato(Plato objPlat, int IdRest) throws ClassNotFoundException, SQLException{
        int intRetorno=0;
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "INSERT InTO `proyecto81`.`plato` (NombrePlato,Precio,Detalle, IdRest)  VALUES ( " 
                +"'" +objPlat.getNombrePlato()+"'"  + "," 
                +"'" +objPlat.getPrecio()+"'" + "," 
                +"'" +objPlat.getDetalle()+"'" + ",'" 
                +IdRest+"')"; 
//                + ObjDir.canton.getIdCan() + "')" ;
         System.out.println(Sentencia);
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
     }
     public static boolean InsertarPlato1(Plato objPlat, int IdRest) throws SQLException, ClassNotFoundException{
       PreparedStatement ps = null;
       Connection con = c.AbrirConexion();
       String sql = "INSERT INTO proyecto81.plato (NombrePlato,Precio,Detalle,IdRest) VALUES(?,?,?,?)";
       try{
           ps = con.prepareStatement(sql);
           ps.setString(1, objPlat.getNombrePlato());
           ps.setDouble(2, objPlat.getPrecio());
           ps.setString(3, objPlat.getDetalle());
           ps.setDouble(4, IdRest);
           ps.execute();
           return true;
       } catch (Exception e) {
           System.err.println(e);
       }
         return false;  
     }
     
//     public static boolean InsertarDireccion1(Direccion ObjDir, int IdCli) 
//             throws ClassNotFoundException, SQLException{
//        PreparedStatement ps = null;
//        Connection con = c.AbrirConexion();
//        String sql = "INSERT INTO Direccion (Calle, Numero, IdClie, IdCan) VALUES (?,?,?,?)";
//        try {
//            ps = con.prepareStatement(sql);
//            ps.setString(1, ObjDir.getCalle());
//            ps.setString(2, ObjDir.getNumero());
//            ps.setInt(3, IdCli);
////            ps.setInt(4, IdCan);
//            ps.setInt(4, ObjDir.canton.getIdCan());
//            ps.execute();
//            return true ;
//        } catch (Exception e) {
//            System.out.println(sql);
//            System.err.println(e);
//        }  
//        return false;
//     }
}
