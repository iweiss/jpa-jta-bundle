package paxexam.bundle.persistence.impl;

import org.apache.log4j.Logger;
import paxexam.bundle.persistence.Bean;
import paxexam.bundle.persistence.MainService;

import javax.persistence.*;
import java.util.List;

/**
 * Created by lasombra on 26/01/2014.
 */
public class MainServiceImpl implements MainService
{
	Logger log = Logger.getLogger(MainServiceImpl.class);

	EntityManagerFactory emfRO;
	EntityManagerFactory emfRW;

	public MainServiceImpl()
	{
		emfRO = Persistence.createEntityManagerFactory("pu-ro");
		emfRW = Persistence.createEntityManagerFactory("pu-rw");
	}

	@Override
	public void warmUp()
	{
		EntityManager em = emfRW.createEntityManager();

		Query query = em.createNativeQuery("DELETE * FROM bean");
		Object result = query.getSingleResult();

		em.close();
	}

	@Override
	public void readDatabase()
	{
		EntityManager em = emfRO.createEntityManager();
		Query query = em.createNativeQuery("SELECT * FROM bean");
		List list = query.getResultList();

		log.info("Query result size == " + list.size());

		em.close();
	}

	@Override
	public void writeDatabase()
	{
		EntityManager em = emfRW.createEntityManager();
		EntityTransaction emt = em.getTransaction();

		Bean bean1 = new Bean();
		bean1.setId(1);
		bean1.setProperty("Bean 1");

		Bean bean2 = new Bean();
		bean2.setId(2);
		bean2.setProperty("Bean 2");

		emt.begin();
		em.persist(bean1);
		em.persist(bean2);
		emt.commit();
		em.close();
	}
}
