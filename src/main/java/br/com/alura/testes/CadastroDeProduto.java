package br.com.alura.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class CadastroDeProduto {

	public static void main(String[] args) {
		cadastroProduto();
		EntityManager em = JPAUtil.getEntityManager();
		ProdutoDAO produtoDAO = new ProdutoDAO(em);
		
		Produto p = produtoDAO.buscaPorId(1l);
		System.out.println("Get nome: " + p.getNome());
		
		produtoDAO.buscaPorParametroCriteria("Xaiomi Redmi", new BigDecimal("800"), null);
		
		List<Produto> todosOsProdutos = produtoDAO.buscaTodos();
		todosOsProdutos.forEach(p2 -> System.out.println("Nome: " + p2.getNome() + " Id: " + p2.getId()));
		
		List<Produto> buscaNomeProduto = produtoDAO.buscaPorNome("Galaxy Fold");
		buscaNomeProduto.forEach(p3 -> System.out.println("Nome: " + p3.getNome() + " Id: " + p3.getId()));
		
		BigDecimal p4 = produtoDAO.buscaPorPreco(1l);
		System.out.println(p4);
	}
	
	private static void cadastroProduto() {
		Categoria celulares = new Categoria("CELULARES");
		
		Produto celular = new Produto("Galaxy Fold", "Produto da China", new BigDecimal("800"), celulares);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		ProdutoDAO dao = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		
		em.getTransaction().begin();
		categoriaDAO.cadastrar(celulares);
		dao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}

}
