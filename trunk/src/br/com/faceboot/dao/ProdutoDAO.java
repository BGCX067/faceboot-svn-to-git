package br.com.faceboot.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.faceboot.model.Produto;
import br.com.faceboot.util.HibernateUtil;

public class ProdutoDAO {

	public boolean salvar(Produto produto) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSession().beginTransaction();
			HibernateUtil.getSession().saveOrUpdate(produto);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return tx.wasCommitted();
	}

	public List<Produto> getAll() {
		return HibernateUtil.getSession().createCriteria(Produto.class).list();
	}

	public Produto getPeloId(int id) {
		Criteria criteria = HibernateUtil.getSession().createCriteria(Produto.class);
		criteria.add(Restrictions.eq("id", id));
		return (Produto) criteria.uniqueResult();
	}

	public List<Produto> getAtivos(){
		Criteria criteria = HibernateUtil.getSession().createCriteria(Produto.class);
		criteria.add(Restrictions.eq("ativo", 1));
		return criteria.list();
	}
	
	
}
