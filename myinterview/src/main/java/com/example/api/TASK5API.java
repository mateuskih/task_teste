package com.example.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.model.user.User;

public class TASK5API {
    private Map<Integer, User> users = new HashMap<Integer, User>();
    private int idCounter = 1;

    // POST /api/users
    public int createUser(String name, String email, String password) {
        int id = idCounter++;
        User user = new User(id, name, email, password);
        users.put(id, user);
        return id;
    }

    // GET /api/users/{id}
    public User getUser(int id) {
        return users.get(id);
    }

    // GET /api/users
    public Map<Integer, User> getUsers() {
        return users;
    }

    // PUT /api/users/{id}
    public void updateUser(int id, String name, String email, String password) {
        if (users.containsKey(id)) {
            User user = users.get(id);
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
        }
    }

    // DELETE /api/users/{id}
    public void deleteUser(int id) {
        users.remove(id);
    }

    // POST /api/authenticate
    public boolean authenticate(String email, String password) {
        for (User user : getUsers().values()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false; 
    }

    // GET /api/users?name={name}
    public List<User> getUsersByName(String name) {
        List<User> usersByName = new ArrayList<User>();
        for (User user : getUsers().values()) {
            if (user.getName().equals(name)) {
                usersByName.add(user);
            }
        }
        return usersByName;
    }
}
