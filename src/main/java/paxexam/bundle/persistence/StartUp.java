package paxexam.bundle.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * Created by lasombra on 25/01/2014.
 */
public class StartUp
{
	@PersistenceContext(name = "pu-ro")
	EntityManagerFactory roEMF = Persistence.createEntityManagerFactory("pu-ro");

	@PersistenceContext(name = "pu-rw")
	EntityManagerFactory rwEMF = Persistence.createEntityManagerFactory("pu-rw");

	public StartUp()
	{

	}
}
