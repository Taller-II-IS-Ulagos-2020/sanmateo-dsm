package cl.ulagos.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {

	@Id
	private int run;
	private String nombre;
	private int telefono;
	private String direccion;
	
	@ManyToMany(mappedBy = "proveedor", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	private List<Producto> producto;
	
	
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
	
	public int getTelefono() {
		return telefono;
	}
	
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public List<Producto> getProductos() {
		return producto;
	}

	public void setProductos(List<Producto> producto) {
		this.producto = producto;
	}

	
}
