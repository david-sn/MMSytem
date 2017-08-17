package com.mms.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mms.Dao.UserDaoImpl;
import com.mms.Hibernate.Entity.User;

@Service("userService")
public class UserServiceImpl {

    @Autowired
    UserDaoImpl userDao;

    @Transactional
    public void persistUser(User user) {
        userDao.persistUserdd(user);

    }

    @Transactional
    public User findUserById(int id) {

        return userDao.findUserById(id);
    }

    @Transactional
    public void updateUser(User user) {
        userDao.updateUser(user);

    }

    @Transactional
    public void deleteUser(User user) {
        userDao.deleteUser(user);

    }

}
