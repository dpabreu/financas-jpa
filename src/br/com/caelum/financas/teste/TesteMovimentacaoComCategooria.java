package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Categoria;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoComCategooria {
	
	public static void main(String args[]) {
		
		EntityManager em = new JPAUtil().geEntityManager();
		
		Categoria categoria = new Categoria();
		categoria.setId(1);
		
		Query qrymov = em.createQuery("select m from Movimentacao m join m.categoria c where c = :pCategoria", Movimentacao.class);
		qrymov.setParameter("pCategoria", categoria);
		
		List<Movimentacao> movimentacoes = qrymov.getResultList();
		
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println(movimentacao.getDescricao());
		}
		
	}

}
