package br.com.faceboot.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.com.faceboot.model.Facebook;
import br.com.faceboot.util.HibernateUtil;

public class FacebookDAO {

	public boolean salvar(Facebook facebook) {
		Transaction tx = null;
		try {
			tx = HibernateUtil.getSession().beginTransaction();
			HibernateUtil.getSession().saveOrUpdate(facebook);
			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			System.out.println(e.getMessage());
		}
		return tx.wasCommitted();
	}

	public List<Facebook> getAll() {
		return HibernateUtil.getSession().createCriteria(Facebook.class).list();
	}

	public Facebook getPeloId(int id) {
		Criteria criteria = HibernateUtil.getSession().createCriteria(Facebook.class);
		criteria.add(Restrictions.eq("id", id));
		return (Facebook) criteria.uniqueResult();
	}

	public List<Facebook> getAtivos(){
		Criteria criteria = HibernateUtil.getSession().createCriteria(Facebook.class);
		criteria.add(Restrictions.eq("ativo", 1));
		return criteria.list();
	}
	
	
}
