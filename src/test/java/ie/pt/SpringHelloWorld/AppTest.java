package ie.pt.SpringHelloWorld;

import static org.junit.Assert.*;

import ie.pt.SpringCourse.SqliteUserDao;
import ie.pt.SpringCourse.User;
import ie.pt.SpringCourse.UserDao;
import ie.pt.SpringCourse.UserDaoException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    ApplicationContext ctx;

    @Before
    public void getApplicationContext() {
        ctx = new ClassPathXmlApplicationContext("spring-beans.xml");
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void shouldPrintHelloWorld() {
        System.out.println("hello world");
        assertTrue(true);
    }

    @Test
    public void shouldCreateUserDao() {
        try {
            UserDao dao = new SqliteUserDao();
            assertNotNull(dao);
        }
        catch(UserDaoException ex) {
            Assert.fail();
        }
    }

    @Test
    public void shouldGetDaoFromSpring() {
        UserDao dao = ctx.getBean(UserDao.class);
        assertNotNull(dao);
    }

    @Test
    public void shouldFailToFindUser99() {
        UserDao dao = ctx.getBean(UserDao.class);

        User u = null;
        try {
            u = dao.getUser(99);
        } catch (UserDaoException e) {

        }
        assertNull(u);
    }

    @Test
    public void shouldReturnUserFromDb() {
        UserDao dao = ctx.getBean(UserDao.class);

        User user = null;
        try {
            user = dao.getUser(1);
        } catch (UserDaoException e) {
            e.printStackTrace();
        }

        System.out.println(user);
    }

    @Test
    public void shouldAddANewUser() {
        System.out.println("should add new user");
        UserDao dao = ctx.getBean(UserDao.class);

        User userToAdd = new User("NEW USER", "new.user@gmail.com", false);

        User addedUser = dao.addUser(userToAdd);

        assertNotEquals(addedUser.getId(), -1);
        assertEquals(userToAdd.getName(), addedUser.getName());

        dao.close();

    }
}
