package com.aluracursos.literalura.Model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "libros")

public class Libros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "autor_id, nullable=false")
    private Autores autor;

    @Column(name = "nombre_autor")
    private String nombreAutor;

    @Column(name = "lenguajes")
    private String lenguajes;
    private double numeroDescargas;

    public Libros(){}

    public Libros(DatosLibros datosLibros, Autores autor) {
        this.titulo = datosLibros.titulo();
        setLenguajes(String.valueOf(datosLibros.languages()));//agregado el toString
        this.numeroDescargas = datosLibros.numeroDescargas();
        this.nombreAutor = autor.getName();
        this.autor = autor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(String lenguajes) {
        this.lenguajes = lenguajes;
    }

    public double getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(double numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    @Override
    public String toString() {
        return "~~~~~~~~~~~~~~~ Libro ~~~~~~~~~~~~~~~" + "\n" +
                "Título: " + titulo + "\n" +
                "Autor: " + nombreAutor + "\n" +
                "Idioma: " + lenguajes + "\n" +
                "Veces descargado: " + numeroDescargas + "\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" + "\n";
    }
}
