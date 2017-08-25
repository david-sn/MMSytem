package com.mms.Service;

import com.mms.Dao.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.mms.Hibernate.Entity.User;

public class UserServiceImpl {

    @Autowired
    SessionDAO sessionDAO;

    @Transactional
    public void persistUser(User user) {
        sessionDAO.Save(user);

    }

    @Transactional
    public User findUserById(int id) {

        return sessionDAO.fetchById(id, User.class);
    }

    @Transactional
    public void updateUser(User user) {
        sessionDAO.update(user);

    }

    @Transactional
    public void deleteUser(User user) {
        sessionDAO.delete(user);

    }

}
