package ie.pt.SpringHelloWorld;

import ie.pt.SpringCourse.SqliteUserDao;
import ie.pt.SpringCourse.UserDao;
import ie.pt.SpringCourse.UserDaoException;
import ie.pt.SpringCourse.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public UserDao getUserDao() throws UserDaoException {
        return new SqliteUserDao();
    }
    @Bean
    public UserService getUserService() {
        return new UserService();
    }
}
