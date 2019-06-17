package com.ache.cineapp.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ache.cineapp.model.Turno;
import com.ache.cineapp.repository.TurnoRepository;
import com.ache.cineapp.service.ITurnoService;

@Service
public class TurnoServiceImpl implements ITurnoService {
	@Autowired
	private TurnoRepository turnoRepository;

	@Override
	public Turno registrar(Turno obj) {
		return turnoRepository.save(obj);
	}

	@Override
	public Turno modificar(Turno obj) {
		return turnoRepository.save(obj);
	}

	@Override
	public List<Turno> listar() {
		return turnoRepository.findAll();
	}

	@Override
	public Turno leer(Integer id) {
		Optional<Turno> op = turnoRepository.findById(id);
		return op.isPresent() ? op.get() : new Turno();
	}

	@Override
	public void eliminar(Integer id) {
		turnoRepository.deleteById(id);

	}

}
