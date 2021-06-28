package ie.pt.SpringCourse;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUserDao implements UserDao {

    protected List<User> users = new ArrayList<>();

    public InMemoryUserDao() {
        users.add(new User(1, "Alice", "alice@gmail.com", false));
        users.add(new User(2, "Bob", "bob@gmail.com", true));
        users.add(new User(3, "Carol", "carol@gmail.com", true));
        users.add(new User(4, "Dan", "dan@gmail.com", true));
        users.add(new User(5, "Eve", "eve@gmail.com", false));
    }
    @Override
    public User addUser(User user) {
        if (user.id == -1) {
            // find max id and add 1
            int maxId = 0;
            for (User u: users) {
                if (u.getId() > maxId) {
                    maxId = u.getId();
                }
            }
            user.setId(maxId + 1);
        }
        users.add(user);
        return user;
    }

    @Override
    public User getUser(int id) throws UserDaoException {
        for(User u:users) {
            if (u.getId() == id) {
                return u;
            }
        }
        throw new UserDaoException("User not found");
    }

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User updateUser(User user) {

        for (int i=0; i<users.size(); i++) {
            if (users.get(i).id == user.id) {
                users.set(i, user);
                return user;
            }
        }
        return null;
    }

    @Override
    public void deleteUser(int id) throws UserDaoException {

        User userToDelete = getUser(id);
        users.remove(userToDelete);
    }

    @Override
    public void close() {

    }
}
