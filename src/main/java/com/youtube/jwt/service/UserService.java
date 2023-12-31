package com.youtube.jwt.service;

import com.youtube.jwt.dao.RoleDao;
import com.youtube.jwt.dao.UserDao;
import com.youtube.jwt.entity.Role;
import com.youtube.jwt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    public User registerNewUser(User user){

        return userDao.save(user);
    }


    public void init(){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role ");
        roleDao.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created users");
        roleDao.save(userRole);

        User adminUser = new User();
        adminUser.setFirstName("admin");
        adminUser.setLastName("admin");
        adminUser.setUserName("admin123");
        adminUser.setUserPassword("admin@pass");
        Set<Role> adminRoles = new HashSet();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userDao.save(adminUser);

        User user = new User();
        user.setFirstName("haile");
        user.setLastName("sidede");
        user.setUserName("haile123");
        user.setUserPassword("haile@pass");
        Set<Role> userRoles = new HashSet();
        userRoles.add(userRole);
        user.setRole(userRoles);
        userDao.save(user);
    }
}
