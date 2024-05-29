package com.example;

import java.util.HashMap;
import java.util.Map;

public class TASK5 {
    private Map<Integer, User> users = new HashMap<Integer, User>();
    private int idCounter = 1;

    public int registerUser(String name, String email, String password) {
        int id = idCounter++;
        User user = new User(id, name, email, password);
        users.put(id, user);
        return id;
    }

    public User getUser(int id) {
        return users.get(id);
    }

    public void updateUser(int id, String name, String email, String password) {
        if (users.containsKey(id)) {
            User user = users.get(id);
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
        }
    }

    public void deleteUser(int id) {
        users.remove(id);
    }

    public Map<Integer, User> getUsers() {
        return users;
    }

    public static void main(String[] args) {
        TASK5 task5 = new TASK5();
        TASK5API api = new TASK5API(task5);

        // Simulate API calls
        int userId1 = api.createUser("Mateus", "mateus@example.com", "password123");
        int userId2 = api.createUser("Maria", "maria@example.com", "password456");
        int userId3 = api.createUser("Daniel", "daniel@example.com", "password789");

        // Retrieve and print user data
        System.out.println("User with ID " + userId1 + ": " + api.getUser(userId1));
        System.out.println("User with ID " + userId2 + ": " + api.getUser(userId2));
        System.out.println("User with ID " + userId3 + ": " + api.getUser(userId3));

        // Update user data
        api.updateUser(userId1, "Mateus Oliveira.", "mateusoliveira@example.com", "newpassword");
        System.out.println("User updated: " + userId1 + ": " + api.getUser(userId1));

        // Delete user
        api.deleteUser(userId2);
        System.out.println("User with ID " + userId2 + " deleted.");

        // Print remaining users
        System.out.println("Remaining users:");
        Map<Integer, User> allUsers = api.getAllUsers();
        for (Map.Entry<Integer, User> entry : allUsers.entrySet()) {
            Integer id = entry.getKey();
            User user = entry.getValue();
            System.out.println("ID: " + id + ", User: " + user);
        }
    }
}
