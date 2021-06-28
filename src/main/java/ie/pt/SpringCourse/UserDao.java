package ie.pt.SpringCourse;

import java.util.List;

public interface UserDao {

    public User addUser(User user);
    public User getUser(int id) throws UserDaoException;
    public List<User> getUsers();
    public User updateUser(User user);
    public void deleteUser(int id) throws UserDaoException ;
    public void close();

}
