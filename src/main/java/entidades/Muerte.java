/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author PC Gamer
 */
@Table(name = "muertes")
@Entity
public class Muerte implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "fecha_hora_muerte", nullable = false)
    private LocalDateTime fechaHoraMuerte;

    @OneToOne
    @JoinColumn(name = "astronauta_id", referencedColumnName = "id")
    private Astronauta astronauta;

    public Muerte(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHoraMuerte() {
        return fechaHoraMuerte;
    }

    public void setFechaHoraMuerte(LocalDateTime fechaHoraMuerte) {
        this.fechaHoraMuerte = fechaHoraMuerte;
    }

    public Astronauta getAstronauta() {
        return astronauta;
    }

    public void setAstronauta(Astronauta astronauta) {
        this.astronauta = astronauta;
    }
    
    
}
