package com.mms.Dao;

import com.mms.Hibernate.Entity.Session.SessionGate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mms.Hibernate.Entity.User;

@Repository("userDao")
public class UserDaoImpl {

    @Autowired
    private SessionGate sessionGate;

    public void persistUserdd(User user) {
        sessionGate.SaveOrUpdate(user);
    }

    public User findUserById(int id) {
        return (User) sessionGate.fetchById(id, User.class);
    }

    public void updateUser(User user) {
        sessionGate.update(user);

    }

    public void deleteUser(User user) {
        sessionGate.delete(user);

    }

}
