package com.example;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.api.TASK5API;
import com.example.model.user.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

public class TASK5Test {

    @Mock
    private TASK5API api;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateUser() {
        when(api.createUser(anyString(), anyString(), anyString())).thenReturn(1);

        int userId = api.createUser("John", "john@example.com", "password");

        verify(api).createUser(eq("John"), eq("john@example.com"), eq("password"));

        assertEquals(1, userId);
    }

    @Test
    public void testGetUser() {
        when(api.getUser(1)).thenReturn(new User(1, "John", "john@example.com", "password"));

        User user = api.getUser(1);

        verify(api).getUser(1);

        assertEquals(1, user.getId());
        assertEquals("John", user.getName());
        assertEquals("john@example.com", user.getEmail());
        assertEquals("password", user.getPassword());
    }

    @Test
    public void testUpdateUser() {
        doNothing().when(api).updateUser(anyInt(), anyString(), anyString(), anyString());

        api.updateUser(1, "John Doe", "john.doe@example.com", "newpassword");

        verify(api).updateUser(eq(1), eq("John Doe"), eq("john.doe@example.com"), eq("newpassword"));
    }

    @Test
    public void testDeleteUser() {
        doNothing().when(api).deleteUser(anyInt());

        api.deleteUser(1);

        verify(api).deleteUser(1);
    }

    @Test
    public void testGetAllUsers() {
        Map<Integer, User> users = new HashMap<Integer, User>();
        users.put(1, new User(1, "John", "john@example.com", "password"));
        users.put(2, new User(2, "Jane", "jane@example.com", "password123"));
        when(api.getUsers()).thenReturn(users);

        Map<Integer, User> returnedUsers = api.getUsers();

        verify(api).getUsers();

        assertEquals(users, returnedUsers);
    }

    @Test
    public void testAuthenticate() {
        when(api.authenticate("john@example.com", "password")).thenReturn(true);

        boolean authenticated = api.authenticate("john@example.com", "password");

        verify(api).authenticate("john@example.com", "password");

        assertTrue(authenticated);
    }

    @Test
    public void testGetUsersByName() {
        List<User> users = Arrays.asList(new User(1, "John", "john@example.com", "password"));
        when(api.getUsersByName("John")).thenReturn(users);

        List<User> returnedUsers = api.getUsersByName("John");

        verify(api).getUsersByName("John");

        assertEquals(users, returnedUsers);
    }
}
