/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author D3RL3
 */
public class Libro implements Serializable{
    public String ibn;
    public String titulo;
    public String descripcion;
    public String nombreAutor;
    public String publicacion;
    public String fechaRegistro;
    public int codigoCategoria;
    public String nitEditorial;
    
    public Libro() {
        this.ibn = "";
        this.titulo = "";
        this.descripcion = "";
        this.nombreAutor = "";
        this.publicacion = "";
        this.fechaRegistro = "";
        this.codigoCategoria = 0;
        this.nitEditorial = "";
    }

    public Libro(String ibn, String titulo, String descripcion, String nombreAutor, String publicacion, String fechaRegistro, int codigoCategoria, String nitEditorial) {
        this.ibn = ibn;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.nombreAutor = nombreAutor;
        this.publicacion = publicacion;
        this.fechaRegistro = fechaRegistro;
        this.codigoCategoria = codigoCategoria;
        this.nitEditorial = nitEditorial;
    }

    public String getIbn() {
        return ibn;
    }

    public void setIbn(String ibn) {
        this.ibn = ibn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(String publicacion) {
        this.publicacion = publicacion;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(int codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getNitEditorial() {
        return nitEditorial;
    }

    public void setNitEditorial(String nitEditorial) {
        this.nitEditorial = nitEditorial;
    }

    
}
