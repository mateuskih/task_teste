package com.example;

import java.util.List;
import java.util.Map;

import com.example.api.TASK5API;
import com.example.model.user.User;

public class TASK5 {
    public static void main(String[] args) {

        TASK5API api = new TASK5API();

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
        Map<Integer, User> allUsers = api.getUsers();
        for (Map.Entry<Integer, User> entry : allUsers.entrySet()) {
            Integer id = entry.getKey();
            User user = entry.getValue();
            System.out.println("ID: " + id + ", User: " + user);
        }

        // Simulated route for user authentication
        boolean authenticated = api.authenticate("daniel@example.com", "password789");
        System.out.println("Authentication result for Daniel: " + authenticated);

        List<User> usersByName = api.getUsersByName("Daniel");
        System.out.println("Result search users by name: " + usersByName);

    }
}
