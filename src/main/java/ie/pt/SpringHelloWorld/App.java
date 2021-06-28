package ie.pt.SpringHelloWorld;

import ie.pt.SpringCourse.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {

        System.out.println("Annotation Driven Configutation");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        UserService us = ctx.getBean(UserService.class);

        System.out.println("count:" + us.getCount());
        /*
        UserDao dao = ctx.getBean(UserDao.class);

        List<User> users = dao.getUsers();

        for (User u:users) {
            u.display();
        }

        dao.close();
        */


    }

    public static void mainOriginal( String[] args )
    {

        System.out.println( "Spring Framework Test" );

        // TestBean tb = new TestBean();

        // request object from Spring Container / Context
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-beans.xml");

        TestBean tb = ctx.getBean(TestBean.class);
        tb.display();

        // User u = new User(1, "Aidan", "aidan@gmail.com", false);
        // u.display();

        // UserDao dao = new InMemoryUserDao();
        UserDao dao = ctx.getBean(UserDao.class);

        User u = null;
        try {
            u = dao.getUser(99);
            u.display();
        } catch (UserDaoException e) {
            //e.printStackTrace();
            // System.out.println("User not found");
            System.out.println(e.getMessage());
        }

        List<User> users = dao.getUsers();

        for(User user:users) {
            user.display();
        }

        dao.close();
/*
        User user3 = dao.getUser(3);

        user3.display();

        System.out.println("=================");

        dao.deleteUser(3);


        User userToUpdate = dao.getUser(4);

        userToUpdate.setName("CHANGED");

        dao.updateUser(userToUpdate);


        users = dao.getUsers();

        System.out.println(users.size());

        System.out.println("After:");

        for (User us: users) {
            us.display();
        }

        System.out.println("=================");

        User newUser = new User("New User", "new.user@gmail.com", false);

        User addedUser = dao.addUser(newUser);

        addedUser.display();


        SqliteUserDao sdao = new SqliteUserDao();

        User u5 = sdao.getUser(2);

        u5.display();
*/
    }
}
