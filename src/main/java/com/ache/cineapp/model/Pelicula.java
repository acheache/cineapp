package com.ache.cineapp.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "pelicula")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String idPelicula;
	@ApiModelProperty(notes = "Nombres debe tener minimo 3 caracteres")
	@Size(min = 3, message = "[nombre] Minimo 3 caracteres")
	@Column(name = "nombre", length = 100)
	private String nombre;
	@Temporal(TemporalType.DATE)
	private Date fechaPublicacion;
	private String estado;
	@OneToOne
	@JoinColumn(name = "id_turno", nullable = false, foreignKey = @ForeignKey(name = "fk_pelicula_turno"))
	private Turno turno;

	public String getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(String idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

}
