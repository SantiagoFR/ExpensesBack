package com.autentia.expensesapplication.service;

import com.autentia.expensesapplication.entities.Friend;
import com.autentia.expensesapplication.repository.FriendsRepository;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class FriendsServiceTest {
    private FriendsService friendsService;
    private FriendsRepository friendsRepository;

    @Before
    public void init() {
        friendsRepository = mock(FriendsRepository.class);
        friendsService = new FriendsService(friendsRepository);
    }

    @Test
    public void expensesServiceShouldCallRepository() throws ParseException {
        List<Friend> expectedResponse = new ArrayList<Friend>(Arrays.asList(new Friend("Rodolfo", "Lopez")));

        when(friendsRepository.findAll()).thenReturn(expectedResponse);

        List<Friend> expenses = friendsService.findAll();

        verify(friendsRepository).findAll();
        assertTrue(expenses.equals(expectedResponse));
    }
}
