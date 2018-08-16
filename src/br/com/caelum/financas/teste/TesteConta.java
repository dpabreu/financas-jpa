package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConta {
	
	public static void main(String args[]) {
		
		EntityManager em = new JPAUtil().geEntityManager();

		try {
			Conta conta = new Conta();
			conta.setTitular("Daniel");
			conta.setNumero("11641-6");
			conta.setBanco("Banco do Brasil");
			conta.setAgencia("3114-3");
			
			em.getTransaction().begin();
			
			em.persist(conta);
			
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}

}
