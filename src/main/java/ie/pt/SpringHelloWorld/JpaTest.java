package ie.pt.SpringHelloWorld;

import ie.pt.SpringCourse.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaTest {
    public static void main(String[] args) {
        System.out.println("JPA Test");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eightwest");
        EntityManager em = emf.createEntityManager();

        User u = em.find(User.class, 2);
        u.display();

        em.close();
    }
}
