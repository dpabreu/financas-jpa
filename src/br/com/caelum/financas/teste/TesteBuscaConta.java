package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteBuscaConta {
	
	public static void main(String args[]){
		EntityManager em = new JPAUtil().geEntityManager();
		
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 1);
		
		System.out.println(conta.getTitular());
		
		em.getTransaction().commit();
		
		em.close();
	}
	

}
