/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.CategoriaI;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.CategoriaM;

/**
 *
 * @author Cristhian
 */
public class ImplCategoriaD extends Conexion implements CategoriaI {

    @Override
    public List<CategoriaM> listaCat() throws Exception {
        this.conexion();
        ResultSet rs;
        List<CategoriaM> lista;
        try {
            Statement st = this.getCn().createStatement();
            rs = st.executeQuery("SELECT * FROM CATEGORIA");
            lista = new ArrayList<>();
            CategoriaM cm;
            while (rs.next()) {
                cm = new CategoriaM();
                cm.setCODCAT(rs.getString("CODCAT"));
                cm.setDESCAT(rs.getString("DESCAT"));
                lista.add(cm);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.cerrar();
        }
    }

}
