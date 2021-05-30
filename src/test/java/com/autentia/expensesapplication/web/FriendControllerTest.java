package com.autentia.expensesapplication.web;

import com.autentia.expensesapplication.entities.Friend;
import com.autentia.expensesapplication.service.FriendService;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class FriendControllerTest {
    private FriendController friendController;

    private FriendService friendService;

    @Before
    public void init(){
        friendService = mock(FriendService.class);
        friendController = new FriendController(friendService);
    }

    @Test
    public void expensesControllerShouldCallService() throws ParseException {
        List<Friend> expectedResponse = new ArrayList<Friend>(Arrays.asList(new Friend("Rodolfo", "Lopez")));

        when(friendService.findAll()).thenReturn(expectedResponse);

        List<Friend> expenses = friendController.findAll();

        verify(friendService).findAll();
        assertTrue(expenses.equals(expectedResponse));
    }
}
