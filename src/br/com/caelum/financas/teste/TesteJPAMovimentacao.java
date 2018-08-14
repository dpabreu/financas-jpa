package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteJPAMovimentacao {

	public static void main(String args[]){
		
		EntityManager em = new JPAUtil().geEntityManager();
		
		em.getTransaction().begin();
		
		Conta conta = em.find(Conta.class, 2);
		
		Movimentacao mov = new Movimentacao();
		mov.setValor(new BigDecimal("356.78"));
		mov.setData(Calendar.getInstance());
		mov.setTipo(TipoMovimentacao.SAIDA);
		mov.setDescricao("Compras");
		mov.setConta(conta);
		
		em.persist(mov);
		
		em.getTransaction().commit();
		
	}
}
