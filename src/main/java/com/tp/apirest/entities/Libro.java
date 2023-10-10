package com.tp.apirest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "Libro")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Libro extends Base{
    @Column(name = "Título")
    private String titulo;

    @Column(name = "Fecha")
    private int fecha;

    @Column(name = "Género")
    private String genero;

    @Column(name = "Páginas")
    private int paginas;

    @ManyToMany(cascade = CascadeType.REFRESH)
    private List<Autor> autores = new ArrayList<Autor>();

}