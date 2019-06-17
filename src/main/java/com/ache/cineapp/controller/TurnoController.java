package com.ache.cineapp.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ache.cineapp.model.Turno;
import com.ache.cineapp.service.ITurnoService;
import com.ache.cineapp.util.ModeloNotFoundException;


@RestController
@RequestMapping("/api/v1/turnos")
public class TurnoController {
	
	@Autowired
	private ITurnoService service;
	
	@GetMapping
	public ResponseEntity<List<Turno>> listar(){
		List<Turno> lista = service.listar();
		return new ResponseEntity<List<Turno>>(lista, HttpStatus.OK);		
	}
	
	@GetMapping(value = "/{id}")
	public Resource<Turno> listarPorId(@PathVariable("id") Integer id){
		
		Turno turno = service.leer(id);
		if(turno.getIdTurno() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO : " + id);
		}
		
		Resource<Turno> resource = new Resource<Turno>(turno);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).listarPorId(id));
		resource.add(linkTo.withRel("pelicula-resource"));
		
		return resource;
	}
	
	@PostMapping
	public ResponseEntity<Turno> registrar(@RequestBody Turno turno) {
		Turno p = service.registrar(turno);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getIdTurno()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Object> modificar(@RequestBody Turno pel) {
		service.modificar(pel);
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public void eliminar(@PathVariable("id") Integer id){
		Turno turno = service.leer(id);

		if (turno.getIdTurno() == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO: " + id);
		} else {
			service.eliminar(id);
		}
	}

}
