package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class TestJPARead {
	EntityManagerFactory fac = null;
	EntityManager em = null;

	int id;
	String name;
	Scanner sc = null;
	SoCity soCity = null;

	public TestJPARead() {
		fac = Persistence.createEntityManagerFactory("TestJPA",
				System.getProperties());
		em = fac.createEntityManager();
		sc = new Scanner(System.in);
	}

	void addBook() {
	}

	void delBook() {
	}

	void findBook() {
		em.getTransaction().begin();

		System.out.println("Enter City Id");
		id = 1;
		soCity = em.find(SoCity.class, id);

		if (soCity == null)
			System.out.println("Record is not present");
		else {
			System.out.println("SoCity id is " + soCity.getSoCityId());
			System.out.println("SoCity name is " + soCity.getSoCityName());
		}
	}

	public void showAll() {

		List<SoCity> l = em.createQuery("select object(o) from SoCity as o")
				.getResultList();

		for (SoCity soCity : l) {
			System.out.println("Book id is " + soCity.getSoCityId());
			System.out.println("Book name is " + soCity.getSoCityName());
			System.out
					.println("---------------------------------------------------------------");
		}
	}

	public List<SoCity> GetCitiesBySQL() {
		List<SoCity> soCities = em.createQuery(
				"select object(o) from SoCity as o").getResultList();
		return soCities;
	}

/*	public List<SoLocation> GetLocationsForCityBySQL(SoCity soCity) {
		List<SoLocation> soLocations = em.createQuery(
				"select object(o) from SoLocation as o where SoCity = "+soCity).getResultList();
		return em.createQuery(
		        "SELECT c FROM SoLocation c WHERE c. LIKE :custName")
		        .setParameter("custName", soCity.getSoCityId())
		        .getResultList();
		return soLocations;

	}*/
	
	public List<SoLocation> GetLocationsByCity() {
		  int soCityId = 1;
		   Query query = em.createQuery( "Select object(sl) from SoLocation as sl where sl.soCity.soCityId = ?1" );
		   query.setParameter( 1, soCityId );
		   return new ArrayList<SoLocation>( query.getResultList() );
		}

	public void MyJPACall() {/*
							 * 
							 * String ch = "no"; TestJPARead mybook = new
							 * TestJPARead();
							 * 
							 * while (!ch.equals("yes")) { int x; System.out
							 * .println(
							 * "Enter choice 1. Add 2. Remove 3. Find 4. Update 5. showAll"
							 * ); x = mybook.sc.nextInt();
							 * 
							 * if (x == 1) mybook.addBook();
							 * 
							 * else if (x == 2) mybook.delBook();
							 * 
							 * else if (x == 3) mybook.findBook();
							 * 
							 * else if (x == 4) mybook.updateBook();
							 * 
							 * else if (x == 5) //mybook.showAll();
							 * 
							 * System.out.println("Exit yes\\no"); ch =
							 * mybook.sc.next(); }
							 */
	}
}