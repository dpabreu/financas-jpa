package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.Conta;

public class TesteConta {
	
	public static void main(String args[]) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("financas");
		EntityManager em = emf.createEntityManager();

		try {
			Conta conta = new Conta();
			conta.setTitular("Daniel");
			conta.setNumero("123");
			conta.setBanco("Itau");
			conta.setAgencia("456");
			
			em.getTransaction().begin();
			
			em.persist(conta);
			
			em.getTransaction().commit();
		} finally {
			emf.close();
			em.close();
		}
	}

}
