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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author PC Gamer
 */
@Table (name="astronautas")
@Entity
public class Astronauta implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "pais", nullable = false, length = 50)
    private String pais;
    
    @Column(name = "nombre_completo", nullable = false, length = 100)
    private String nombreCompleto;
    
    @Column(name = "tipo_de_sangre", nullable = false, length = 3)
    private String tipoDeSangre;
    
    @Column(name = "edad", nullable = false)
    private int edad;
    
    @Column(name = "sexo", nullable = false, length = 1)
    private String sexo;

    @OneToOne(mappedBy = "astronauta", cascade = CascadeType.ALL)
    private Muerte muerte;

    @ManyToMany
    @JoinTable(
        name = "astronauta_nave",
        joinColumns = @JoinColumn(name = "astronauta_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "nave_id", referencedColumnName = "id")
    )
    private Set<Nave> naves = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTipoDeSangre() {
        return tipoDeSangre;
    }

    public void setTipoDeSangre(String tipoDeSangre) {
        this.tipoDeSangre = tipoDeSangre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Muerte getMuerte() {
        return muerte;
    }

    public void setMuerte(Muerte muerte) {
        this.muerte = muerte;
    }

    public Set<Nave> getNaves() {
            return naves;
        }

    public void setNaves(Set<Nave> naves) {
        this.naves = naves;
    }

    
}
