/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import Clases2.Cliente;
import Clases2.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jorge
 */
public class DATUsuario {

    static DATConexion c = new DATConexion();

    public static ResultSet ConsultarClienteCedula(String Cedula) throws ClassNotFoundException, SQLException {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "select usuario.idUsua from proyecto81.cliente2, proyecto81.usuario "
                + "where cliente2.idClie = usuario.idClie and cliente2.cedula = " + Cedula + " order by 1";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }

    public static int InsertarUsuario(Usuario ObjUsua, int IdClie) throws SQLException, ClassNotFoundException {
        int intRetorno = 0;
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "INSERT InTO `proyecto81`.`usuario` (CedulaAcc, ContraseñaAcc, idClie)  VALUES ( "
                + "'" + ObjUsua.getCedulaAcc()+ "'" + ","
                + "'" + ObjUsua.getContraseñaAcc()+ "'" + ",'"
                + IdClie + "')";
        System.out.println(Sentencia);
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
    
    public static boolean InsertarUsuario2(Usuario ObjUsua, int IdCli) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = null;
        Connection con = c.AbrirConexion();
        String sql = "INSERT INTO `proyecto81`.`usuario` (CedulaAcc, ContraseñaAcc, idClie) VALUES (?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, ObjUsua.getCedulaAcc());
            ps.setString(2, ObjUsua.getContraseñaAcc());
            ps.setDouble(3, IdCli);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
        }
        return false;
    }
}
