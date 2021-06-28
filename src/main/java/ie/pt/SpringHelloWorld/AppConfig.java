package ie.pt.SpringHelloWorld;

import ie.pt.SpringCourse.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {

    @Value("${application.name}")
    private String applicationName;

    @Value("${application.connection_string}")
    private String connectionString;

    @Bean
    public JdbcTemplate getJdbcTemplate() {

        return new JdbcTemplate(new DriverManagerDataSource(connectionString));
    }

    @Bean
    public UserDao getUserDao() throws UserDaoException {
        System.out.println(connectionString);
        //return new SqliteUserDao(connectionString);
        return new JdbcTemplateUserDao();
    }

    @Bean
    public UserService getUserService() {
        return new UserService();
    }
}
