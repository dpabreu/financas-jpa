package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaContaCliente {

	public static void main(String args[]) {
		
		Conta conta = new Conta();
		conta.setId(2);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Daniel");
		cliente.setProfissao("Analista de Sistemas");
		cliente.setEndereco("Rua Limites, 858");
		cliente.setConta(conta);

		Cliente cliente2 = new Cliente();
		cliente2.setNome("Emily");
		cliente2.setProfissao("Doula");
		cliente2.setEndereco("Rua Ministro Amarilio Lopes Salgado, 50");
		cliente2.setConta(conta);
		
		
		EntityManager em = new JPAUtil().geEntityManager();
		em.getTransaction().begin();
		
//		em.persist(cliente);
		em.persist(cliente2);
		
		em.getTransaction().commit();
		em.close();
	}
}
