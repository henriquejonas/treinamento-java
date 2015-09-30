package br.com.treinamento.dao;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public abstract class MySqlDao<T> implements Serializable
{
	private static final long         serialVersionUID      = 1L;

	protected transient EntityManager entityManager;


	protected abstract Class<T> getPersistentClass();

	public MySqlDao()
	{

	}

	public MySqlDao(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}


	public void beginTransaction()
	{
		getEntityManager().getTransaction().begin();
	}

	public void commitTransaction()
	{
		try
		{
			getEntityManager().getTransaction().commit();
		}
		catch(RuntimeException ex)
		{
			//rollbackTransaction(getEntityManager());
			throw ex;
		}
	}


	public List<T> findAll()
	{
		return getEntityManager().createNamedQuery(getPersistentClass().getSimpleName() + ".findAll", getPersistentClass()).getResultList();
	}

	public T findById(Long id)
	{
		return getEntityManager().find(getPersistentClass(), id);
	}


	protected EntityManager getEntityManager()
	{
		if(entityManager != null)
		{
			return entityManager;
		}
		else
		{
//			return MySqlListener.getEntityManager();
		}
		return entityManager;
	}

	public void remove(T entity)
	{

		EntityManager em = getEntityManager();
		try
		{
			em.getTransaction().begin();

			em.remove(entity);

			em.getTransaction().commit();
		}
		catch(RuntimeException e)
		{
			throw e;
		}
	}
}
