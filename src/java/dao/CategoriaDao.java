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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;

/**
 *
 * @author D3RL3
 */
public class CategoriaDao {
    public static boolean registrar(Categoria cat){
        try {
            String sql = "INSERT INTO CATEGORIAS(NOMBRE) VALUES (?);";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, cat.getNombre());
            if(st.executeUpdate() > 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static ArrayList<Categoria> listar(){
        try {
            String sql = "SELECT * FROM CATEGORIAS;";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareStatement(sql);
            //st.setString(1, cat.getNombre());
            ResultSet rs = st.executeQuery();
            ArrayList<Categoria> lista = null;
            Categoria cat;
            while(rs.next()){
                cat = new Categoria();
                cat.setCodigo(rs.getInt("codigo"));
                cat.setNombre(rs.getString("nombre"));
                lista.add(cat);
            }
            return lista;
            
        } catch (SQLException ex) {
            return null;
        }
    }
}
