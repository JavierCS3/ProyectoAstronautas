/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany;

import entidades.Astronauta;
import entidades.Muerte;
import entidades.Nave;
import entidades.Vuelo;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;



/**
 *
 * @author PC Gamer
 */
public class ProyectoDeAstronautas {

        private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("ConexionBD1");
        em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            guardarDatos();

            em.getTransaction().commit();

            consultarDatos();

        } finally {
            em.close();
            emf.close();
        }
    }

    private static void guardarDatos() {
        Astronauta astronauta1 = new Astronauta();
        astronauta1.setPais("USA");
        astronauta1.setNombreCompleto("John Doe");
        astronauta1.setTipoDeSangre("O+");
        astronauta1.setEdad(34);
        astronauta1.setSexo("M");

        Astronauta astronauta2 = new Astronauta();
        astronauta2.setPais("Russia");
        astronauta2.setNombreCompleto("Ivan Ivanov");
        astronauta2.setTipoDeSangre("A-");
        astronauta2.setEdad(40);
        astronauta2.setSexo("M");

        Muerte muerte1 = new Muerte();
        muerte1.setFechaHoraMuerte(LocalDateTime.of(2023, 6, 15, 10, 0));
        muerte1.setAstronauta(astronauta1);
        astronauta1.setMuerte(muerte1);

        Nave nave = new Nave();
        nave.setNombre("Apollo");
        nave.setColor("Blanco");
        nave.setPais("USA");
        nave.setNumeroPasajeros(3);
        nave.setTamano("Grande");

        astronauta1.getNaves().add(nave);
        astronauta2.getNaves().add(nave);
        nave.getAstronautas().add(astronauta1);
        nave.getAstronautas().add(astronauta2);

        for (int i = 0; i < 5; i++) {
            Vuelo vuelo = new Vuelo();
            vuelo.setNumeroPasajero(i + 1);
            vuelo.setFechaHoraSalida(LocalDateTime.of(2023, 6, 14 + i, 8, 0));
            vuelo.setNave(nave);
            nave.getVuelos().add(vuelo);
        }

        em.persist(astronauta1);
        em.persist(astronauta2);
        em.persist(nave);
        em.persist(muerte1);
    }

    private static void consultarDatos() {
        TypedQuery<Astronauta> query = em.createQuery("SELECT a FROM Astronauta a", Astronauta.class);
        List<Astronauta> astronautas = query.getResultList();

        if (!astronautas.isEmpty()) {
            Nave navePersisted = em.find(Nave.class, 1L);

            if (navePersisted != null) {
                Vuelo vuelo = navePersisted.getVuelos().iterator().next();
                for (Astronauta astronauta : astronautas) {
                    if (astronauta.getMuerte() != null) {
                        System.out.printf("Los astronautas: %s y %s fueron muy valientes al subirse a la %s que tiene capacidad para %d pasajeros. Realizaron un vuelo el %s y lamentablemente, %s perdió la vida el %s.%n",
                                astronauta.getNombreCompleto(), astronauta.getNombreCompleto(), navePersisted.getNombre(), navePersisted.getNumeroPasajeros(), vuelo.getFechaHoraSalida(), astronauta.getNombreCompleto(), astronauta.getMuerte().getFechaHoraMuerte());
                    } else {
                        System.out.printf("El astronauta %s no tiene información de muerte registrada.%n", astronauta.getNombreCompleto());
                    }
                }
            } else {
                System.out.println("No se encontró la nave persistida con ID 1.");
            }
        } else {
            System.out.println("No se encontraron astronautas registrados.");
        }
    }
    }
