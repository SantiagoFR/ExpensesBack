package com.autentia.expensesapplication.service;

import com.autentia.expensesapplication.entities.Friend;
import com.autentia.expensesapplication.repository.FriendRepository;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class FriendServiceTest {
    private FriendService friendService;
    private FriendRepository friendRepository;

    @Before
    public void init() {
        friendRepository = mock(FriendRepository.class);
        friendService = new FriendService(friendRepository);
    }

    @Test
    public void expensesServiceShouldCallRepository() throws ParseException {
        List<Friend> expectedResponse = new ArrayList<Friend>(Arrays.asList(new Friend("Rodolfo", "Lopez")));

        when(friendRepository.findAll()).thenReturn(expectedResponse);

        List<Friend> expenses = friendService.findAll();

        verify(friendRepository).findAll();
        assertTrue(expenses.equals(expectedResponse));
    }
}
