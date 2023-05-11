package br.com.alura.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Embedded
	private DadosPessoais dadosPessoais;
	
	public Cliente() {
		
	}
	
	public Cliente(String nome, String CPF) {
		this.dadosPessoais = new DadosPessoais(nome, CPF);
	}

	public Long getId() {
		return id;
		
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}
	
	

	
	
	
}
