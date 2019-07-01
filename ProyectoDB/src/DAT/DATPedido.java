/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAT;

import Clases2.Pedido;
import Clases2.Restaurante;
import static DAT.DATPlato.c;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Jorge
 */
public class DATPedido {
    
   static  DATConexion c = new DATConexion();
    public ResultSet ConsultarPedidos() throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "SELECT * FROM `proyecto81`.`pedido`";
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
    public static ResultSet ConsultarPedidoPlato(String NumMesa) throws ClassNotFoundException, SQLException
    {
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "select pedido.idPedi,Estado,NumMesa,TiempoEspera from plato, pedido "
                + "where plato.idPlat = pedido.idPlat and plato.NumMesa = "+NumMesa +" order by 1";
//        System.out.println(Sentencia);
        ResultSet rs = st.executeQuery(Sentencia);
        return rs;
    }
    
    public int InsertarPedido(Pedido objPedi, int IdPlat) throws SQLException, ClassNotFoundException{
        int intRetorno=0;
        Statement st = c.AbrirConexion().createStatement();
        String Sentencia = "INSERT InTO `proyecto81`.`Pedido` (Estado, NumMesa, TiempoEspera, idPlat, idCaje)  VALUES ( " 
                +"'" +objPedi.getEstado()+"'"  + "," 
                +"'" +objPedi.getNumMesa()+"'"  + "," 
                +"'" +objPedi.getTiempoEspera()+"'"  + "," 
                +"'" +IdPlat+"'" + ",'" 
                + objPedi.cajera.getIdCaje()+ "')" ;
        System.out.println(Sentencia);
        intRetorno = st.executeUpdate(Sentencia);
        return intRetorno;
    }
}
