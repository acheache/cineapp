package com.ache.cineapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ache.cineapp.model.Pelicula;
import com.ache.cineapp.repository.PeliculaRepository;
import com.ache.cineapp.service.IPeliculaService;



@Service
public class PeliculaServiceImpl implements IPeliculaService{
	
	@Autowired
	private PeliculaRepository peliculaRepository;

	@Override
	public Pelicula registrar(Pelicula obj) {
		return peliculaRepository.save(obj);
	}

	@Override
	public Pelicula modificar(Pelicula obj) {
		return peliculaRepository.save(obj);
	}

	@Override
	public List<Pelicula> listar() {
		return peliculaRepository.findAll();
	}

	@Override
	public Pelicula leer(Integer id) {
		Optional<Pelicula> op = peliculaRepository.findById(id);
		return op.isPresent() ? op.get() : new Pelicula();
	}

	@Override
	public void eliminar(Integer id) {
		peliculaRepository.deleteById(id);

	}

}
