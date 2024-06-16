/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author PC Gamer
 */
@Table(name = "naves")
@Entity
public class Nave implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "color", nullable = false, length = 30)
    private String color;

    @Column(name = "pais", nullable = false, length = 50)
    private String pais;

    @Column(name = "numero_pasajeros", nullable = false)
    private int numeroPasajeros;

    @Column(name = "tamano", nullable = false, length = 50)
    private String tamano;

    @ManyToMany(mappedBy = "naves")
    private Set<Astronauta> astronautas = new HashSet<>();

    @OneToMany(mappedBy = "nave", cascade = CascadeType.ALL)
    private Set<Vuelo> vuelos = new HashSet<>();
    
    public Nave(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public Set<Astronauta> getAstronautas() {
        return astronautas;
    }

    public void setAstronautas(Set<Astronauta> astronautas) {
        this.astronautas = astronautas;
    }

    public Set<Vuelo> getVuelos() {
        return vuelos;
    }

    public void setVuelos(Set<Vuelo> vuelos) {
        this.vuelos = vuelos;
    }
    
    
}
