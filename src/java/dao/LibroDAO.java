/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import model.Libro;

/**
 *
 * @author Arranque 4
 */
public class LibroDAO {
    
    
    public static boolean registrar (Libro l) {
        try {
            String SQL="INSERT INTO libros VALUES (?,?,?,?,?,(select now()),?,?);";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, l.getIsbn());
            st.setString(2, l.getTitulo());
            st.setString(3, l.getDescripcion());
            st.setString(4, l.getNombre_autor());
            st.setString(5, l.getPublicacion());
            st.setInt(6, l.getCodigo_categoria());
            st.setString(7, l.getNit_editorial());
            
            if(st.executeUpdate()>0){
                return true;
            } else {
                return false;
            }       } catch (SQLException ex) {
                return false;
        }
    }
    
     public static boolean actualizar (Libro l){
        
        try {
            String SQL="UPDATE libros " +
                       "  SET " +
                       "     titulo=?, " +
                       "     descripcion=?, " +
                       "     nombre_autor=?, " +
                       "     publicacion=?, " +
                       "     codigo_categoria=?," +
                       "     nit_editorial=?" +
                       "  WHERE " +
                       "     isbn=?";
            
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareStatement (SQL);
            
            st.setString(1, l.getTitulo());
            st.setString(2, l.getDescripcion());
            st.setString(3, l.getNombre_autor());
            st.setString(4, l.getPublicacion());
            st.setInt(5, l.getCodigo_categoria());
            st.setString(6, l.getNit_editorial());
            st.setString(7, l.getIsbn());
            
            if(st.executeUpdate()>0){
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
                return false;
        }
        
    }
     
         public static boolean eliminar (Libro l) {
        try {
            String SQL="DELETE FROM libros WHERE isbn=?";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, l.getIsbn());
            
            if(st.executeUpdate()>0){
                return true;
            } else {
                return false;
            }       } catch (SQLException ex) {
                return false;
        }
         }
}
