package com.ache.cineapp.service;

import java.util.List;

public interface ICRUD<T> {
	T registrar(T obj);
	T modificar(T obj);
	List<T> listar();
	T leer(Integer id);
	void eliminar(Integer id);
}
