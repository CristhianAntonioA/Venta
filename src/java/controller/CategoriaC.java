/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ImplCategoriaD;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import model.CategoriaM;

@Named(value = "categoriaC")
@SessionScoped
public class CategoriaC implements Serializable {

    private CategoriaM cm = new CategoriaM();
    private List<CategoriaM> lstCategoria;

    @PostConstruct
    public void iniciar() {
        try {
            listarCategoria();
        } catch (Exception e) {

        }
    }

    public void listarCategoria() throws Exception {
        ImplCategoriaD dao;
        try {
            dao = new ImplCategoriaD();
            lstCategoria = dao.listaCat();
        } catch (Exception e) {
            throw e;
        }

    }

    /*GETTER AND SETTER*/
    public CategoriaM getCm() {
        return cm;
    }

    public void setCm(CategoriaM cm) {
        this.cm = cm;
    }

    public List<CategoriaM> getLstCategoria() {
        return lstCategoria;
    }

    public void setLstCategoria(List<CategoriaM> lstCategoria) {
        this.lstCategoria = lstCategoria;
    }

}
