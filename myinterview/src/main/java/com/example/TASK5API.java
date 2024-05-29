package com.example;

import java.util.Map;

public class TASK5API {

    private final TASK5 task5;

    public TASK5API(TASK5 task5) {
        this.task5 = task5;
    }

    // POST /api/users
    public int createUser(String name, String email, String password) {
        return task5.registerUser(name, email, password);
    }

    // GET /api/users/{id}
    public User getUser(int id) {
        return task5.getUser(id);
    }

    // PUT /api/users/{id}
    public void updateUser(int id, String name, String email, String password) {
        task5.updateUser(id, name, email, password);
    }

    // DELETE /api/users/{id}
    public void deleteUser(int id) {
        task5.deleteUser(id);
    }

    // Utility method to get all users (for testing purposes)
    public Map<Integer, User> getAllUsers() {
        return task5.getUsers();
    }
}
