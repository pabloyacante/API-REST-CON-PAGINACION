package com.tp.apirest.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name= "Localidad" )
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Localidad extends Base{

    @Column(name = "Denominacion")
    private String denominacion;

}
