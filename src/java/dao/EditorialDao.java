/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Editorial;


/**
 *
 * @author D3RL3
 */
public class EditorialDao {
     public static boolean registrar(Editorial e){
        try {
            String sql = "INSERT INTO EDITORIAL(nit, nombre, telefono, direccion, email, sitioweb) VALUES (?,?,?,?,?,?);";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, e.getNit());
            st.setString(2, e.getNombre());
            st.setString(3, e.getTelefono());
            st.setString(4, e.getDireccion());
            st.setString(5, e.getEmail());
            st.setString(6, e.getSitioWeb());

            if(st.executeUpdate() > 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static ArrayList<Editorial> listar(){
        try {
            String sql = "SELECT * FROM EDITORIAL";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareStatement(sql);
            //st.setString(1, cat.getNombre());
            ResultSet rs = st.executeQuery();
            ArrayList<Editorial> lista = null;
            Editorial e;
            while(rs.next()){
                e = new Editorial();                
                e.setNit(rs.getString("nit"));
                e.setNombre(rs.getString("nombre"));
                e.setDireccion(rs.getString("direccion"));
                e.setEmail(rs.getString("email"));
                e.setSitioWeb(rs.getString("sitioweb"));
                e.setTelefono(rs.getString("telefono"));                
                lista.add(e);
            }
            return lista;
            
        } catch (SQLException ex) {
            return null;
        }
    }    
}
