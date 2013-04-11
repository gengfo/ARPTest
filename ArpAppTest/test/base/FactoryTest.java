
package base;

import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

public class FactoryTest {

	public static void main(String args[]) {

		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("ARPUT");
		// Creating an EntityManager will trigger database login
		// and schema generation (because of the properties passed above)
		// EntityManager em = emf.createEntityManager();
		Metamodel mm = emf.getMetamodel();

		Set<EntityType<?>> a = mm.getEntities();

		System.out.println("Done");

	}

}
