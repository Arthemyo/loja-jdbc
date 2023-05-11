package br.com.alura.testes;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.alura.loja.dao.CategoriaDAO;
import br.com.alura.loja.dao.ClienteDAO;
import br.com.alura.loja.dao.PedidoDAO;
import br.com.alura.loja.dao.ProdutoDAO;
import br.com.alura.loja.vo.RelatorioDeVendasVO;
import br.com.alura.modelo.Categoria;
import br.com.alura.modelo.Cliente;
import br.com.alura.modelo.Pedido;
import br.com.alura.modelo.Produto;
import br.com.alura.util.JPAUtil;

public class CadastroDePedidos {

	public static void main(String[] args) {
		
		
		EntityManager em = JPAUtil.getEntityManager();	
		em.getTransaction().begin();

		PedidoDAO pedidoDAO = new PedidoDAO(em);
	
		em.getTransaction().commit();
		
		BigDecimal totalVendido = pedidoDAO.valorVendidoTotal();
		System.out.println("VT: " + totalVendido);
		
		List<RelatorioDeVendasVO> relatorioVendas = pedidoDAO.relatorioDeVendas();
		relatorioVendas.forEach(System.out::println);
		
		Pedido pedido = new PedidoDAO(em).buscarPedidoComCliente(1l);
		
		em.close();
		
		System.out.println(pedido.getCliente());

	}
	
	
	private static void cadastroProduto() {
		Categoria celulares = new Categoria("CELULARES");
		
		Produto celular = new Produto("Galaxy Fold", "Produto da China", new BigDecimal("800"), celulares);
		
		EntityManager em = JPAUtil.getEntityManager();
		
		Cliente cliente = new Cliente("Rodirgo", "123456");
		
		ProdutoDAO dao = new ProdutoDAO(em);
		CategoriaDAO categoriaDAO = new CategoriaDAO(em);
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
		em.getTransaction().begin();
		categoriaDAO.cadastrar(celulares);
		dao.cadastrar(celular);
		clienteDAO.cadastrar(cliente);
		em.getTransaction().commit();
		em.close();
	}

}
