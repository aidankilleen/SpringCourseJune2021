package ie.pt.SpringCourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateUserDao implements UserDao {

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public JdbcTemplateUserDao() {
        //jdbcTemplate = new JdbcTemplate()
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User getUser(int id) throws UserDaoException {

        return (User)jdbcTemplate.queryForObject("select * from users where id=?",
                                    new Object[] { id },
                                    new UserRowMapper());
    }

    @Override
    public List<User> getUsers() {
        return (List<User>)jdbcTemplate.query("select * from users", new UserRowMapper());
    }

    @Override
    public User updateUser(User user) {

        jdbcTemplate.update("update users set name=?, email=?, active=? where id=?",
                            new Object[] { user.getName(), user.getEmail(), user.isActive(), user.getId() });
        return user;
    }

    @Override
    public void deleteUser(int id) throws UserDaoException {
        jdbcTemplate.update("delete from users where id = ?", new Object[] { id });
    }

    @Override
    public void close() {

    }
}
