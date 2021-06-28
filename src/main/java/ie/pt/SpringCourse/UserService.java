package ie.pt.SpringCourse;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {

    @Autowired
    protected UserDao dao;

    public UserService() {

    }
    /*
    public UserService(UserDao dao) {
        this.dao = dao;
    }
    */
    public int getCount() {
        return dao.getUsers().size();
    }
}
