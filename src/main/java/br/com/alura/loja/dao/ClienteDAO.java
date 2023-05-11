package br.com.alura.loja.dao;

import javax.persistence.EntityManager;

import br.com.alura.modelo.Cliente;

public class ClienteDAO {
	private EntityManager em;
	
	public ClienteDAO(EntityManager em) {
		this.em = em;
	}
	
	public void cadastrar(Cliente cliente) {
		this.em.persist(cliente);
	}
	
	public Cliente buscaPorId(Long id) {
		return em.find(Cliente.class, id);
	}

}
