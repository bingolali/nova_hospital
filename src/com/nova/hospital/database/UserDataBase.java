package com.nova.hospital.database;

import com.nova.hospital.model.*;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author bingolalii
 */
public class UserDataBase {

    public static User[] users = new User[]{
            new Admin("admin", "123"),
            new User("user1", "123","user"),
            new User("user2", "123","user")
    };

    public static void save(User user) {
        User[] _users = new User[users.length + 1];
        for (int i = 0; i < users.length; i++) {
            _users[i] = users[i];
        }

        _users[_users.length - 1] = user;
        setUsers(_users);
    }

    private static void setUsers(User[] _users) {
        users = _users;
    }

    public static Optional<User> exists(User user) {
        return Arrays.stream(users).filter(existsUser -> {
            return existsUser.getName().equals(user.getName()) && existsUser.getPwd().equals(user.getPwd());
        }).findFirst();
    }

    public static boolean exists(String userId) {
        for (User u : users) {
            if (userId.equals(u.getUserid())) return true;
        }
        return false;
    }

    public static User find(String userId) {
        for (User u : users) {
            if (userId.equals(u.getUserid())) return u;
        }
        return null;
    }

    public static boolean delete(String userId) {
        if (exists(userId)) {
            User[] _users = new User[users.length - 1];
            for (int i = 0, j = 0; i < users.length; i++) {
                if (!userId.equals(users[i].getUserid())) {
                    _users[j++] = users[i];
                }
            }
            setUsers(_users);
            return true;
        }
        return false;
    }
}
