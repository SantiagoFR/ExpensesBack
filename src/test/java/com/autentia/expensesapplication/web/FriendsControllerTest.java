package com.autentia.expensesapplication.web;

import com.autentia.expensesapplication.entities.Friend;
import com.autentia.expensesapplication.service.FriendsService;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class FriendsControllerTest {
    private FriendsController friendsController;

    private FriendsService friendsService;

    @Before
    public void init(){
        friendsService = mock(FriendsService.class);
        friendsController = new FriendsController(friendsService);
    }

    @Test
    public void expensesControllerShouldCallService() throws ParseException {
        List<Friend> expectedResponse = new ArrayList<Friend>(Arrays.asList(new Friend("Rodolfo", "Lopez")));

        when(friendsService.findAll()).thenReturn(expectedResponse);

        List<Friend> expenses = friendsController.findAll();

        verify(friendsService).findAll();
        assertTrue(expenses.equals(expectedResponse));
    }
}
