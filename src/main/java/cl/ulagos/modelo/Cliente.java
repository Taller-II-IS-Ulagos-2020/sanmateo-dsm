package cl.ulagos.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cliente
 *
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int run;
	private String nombre;

	@OneToMany(mappedBy="cliente")
	private List<Producto> productos;
	
	public Cliente(int run, String nombre) {
		
		this.run = run;
		this.nombre = nombre;
	}
	
	public Cliente(int run) {
		
		this.run = run;
	}
	
	public Cliente() {
		super();
	}
	
	public int getRun() {
		return run;
	}

	public void setRun(int run) {
		this.run = run;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
   
}
