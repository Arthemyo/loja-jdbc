package br.com.alura.modelo;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "categorias")
public class Categoria {
	
	@EmbeddedId
	private CategoriaId id;
	
	
	
	public Categoria() {
		
	}

	public Categoria(String nome) {
		this.id = new CategoriaId(nome, "xpto");
	}

	public CategoriaId getId() {
		return id;
	}

	public void setId(CategoriaId id) {
		this.id = id;
	}
	
	
	
	
	
}
