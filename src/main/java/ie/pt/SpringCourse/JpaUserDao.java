package ie.pt.SpringCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class JpaUserDao implements UserDao {

    @Autowired
    protected EntityManager em;

    public JpaUserDao() {
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User getUser(int id) throws UserDaoException {

        User u = em.find(User.class, id);
        return u;
    }

    @Override
    public List<User> getUsers() {
        TypedQuery<User> query = em.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public User updateUser(User user) {

        User u = em.find(User.class, user.getId());

        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setActive(user.isActive());

        // save the changes
        em.getTransaction().begin();
        em.persist(u);
        em.getTransaction().commit();

        return user;
    }

    @Override
    public void deleteUser(int id) throws UserDaoException {

    }

    @Override
    public void close() {
        em.close();
    }
}
