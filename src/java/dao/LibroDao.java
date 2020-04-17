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
import model.Libro;

/**
 *
 * @author D3RL3
 */
public class LibroDao {
     public static boolean registrar(Libro l){
        try {
            
            String sql = "INSERT INTO LIBROS VALUES (?,?,?,?,?,(SELECT NOW()),?,?);";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareStatement(sql);
            
            st.setString(1, l.getIbn());
            st.setString(2, l.getTitulo());
            st.setString(3, l.getDescripcion());
            st.setString(4, l.getNombreAutor());
            st.setString(5, l.getPublicacion());
            st.setInt(6, l.getCodigoCategoria());
            st.setString(7, l.getNitEditorial());
            
            if(st.executeUpdate() > 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static ArrayList<Libro> listar(){
        try {
            
            String sql = "SELECT * FROM LIBROS;";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareStatement(sql);
            //st.setString(1, cat.getNombre());
            ResultSet rs = st.executeQuery();
            ArrayList<Libro> lista = new ArrayList<>();
            Libro l;
            
            while(rs.next()){
                l = new Libro();
                l.setIbn(rs.getString("isbn"));
                l.setTitulo(rs.getString("titulo"));
                l.setDescripcion(rs.getString("descripcion"));
                l.setNombreAutor(rs.getString("nombre_autor"));
                l.setPublicacion(rs.getString("publicacion"));
                l.setFechaRegistro(rs.getString("fecha_registro"));
                l.setCodigoCategoria(rs.getInt("codigo_categoria"));
                l.setNitEditorial(rs.getString("nit_editorial"));


                lista.add(l);
            }
            return lista;
            
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public static boolean actualizar(Libro l){
        try {
            
            String sql = "UPDATE LIBRO SET\n" +
                        "TITULO = ?,\n" +
                        "DESCRIPCION = ?,\n" +
                        "NOMBRE_AUTOR = ?,\n" +
                        "PUBLICACION = ?,\n" +
                        "CODIGO_CATEGORIA = ?,\n" +
                        "NIT_EDITORIAL = ?,\n" +
                        "WHERE ISBN = ?";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(7, l.getIbn());
            st.setString(1, l.getTitulo());
            st.setString(2, l.getDescripcion());
            st.setString(3, l.getNombreAutor());
            st.setString(4, l.getPublicacion());
            st.setInt(5, l.getCodigoCategoria());
            st.setString(6, l.getNitEditorial());
            
            if(st.executeUpdate() > 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static boolean eliminar(Libro l){
        try {
            
            String sql = "DELETE LIBRO WHERE ISBN = ?";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, l.getIbn());
            
            if(st.executeUpdate() > 0) {
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            return false;
        }
    }
}
