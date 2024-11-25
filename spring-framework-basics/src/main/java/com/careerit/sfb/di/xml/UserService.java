package com.careerit.sfb.di.xml;

import com.careerit.sfb.di.xml.UserDao;

import java.util.List;

public class UserService {

    private UserDao userDao;
    public List<String> getUserNameInUpperCase(){
        List<String> users = userDao.getUsers();
        for(int i=0;i<users.size();i++){
            users.set(i, users.get(i).toUpperCase());
        }
        return users;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
