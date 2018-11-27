/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;

/**
 *
 * @author Arranque 4
 */
public class CategoriaDAO {
    
    public static boolean registrar(Categoria c) {
        
        try {
            String SQL ="INSERT INTO categorias(nombre) values(?)";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, c.getNombre());
            if(st.executeUpdate()>0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
        
    }
    
     public static boolean eliminar(Categoria cat) {
        
        try {
            String SQL ="DELETE FROM categorias WHERE nombre=?";
            Connection con = Conexion.conectar();
            PreparedStatement st = con.prepareStatement(SQL);
            st.setString(1, cat.getNombre());
            if(st.executeUpdate()>0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
        
    }
    
    
    
    
}
