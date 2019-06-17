package com.ache.cineapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ache.cineapp.model.Pelicula;


public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {

}
