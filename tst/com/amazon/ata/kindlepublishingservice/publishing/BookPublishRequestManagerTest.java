// BookPublishRequestManagerTest.java
package com.amazon.ata.kindlepublishingservice.publishing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Queue;


import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.*;

public class BookPublishRequestManagerTest {

    @Mock
    private Queue<BookPublishRequest> bookPublishRequestQueue;

    @InjectMocks
    private BookPublishRequestManager bookPublishRequestManager;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddBookPublishRequest() {
        BookPublishRequest request = BookPublishRequest.builder().build();
        bookPublishRequestManager.addBookPublishRequest(request);
        verify(bookPublishRequestQueue, times(1)).offer(request);
    }

    @Test
    public void testGetBookPublishRequestToProcess() {
        BookPublishRequest request = BookPublishRequest.builder().build();
        when(bookPublishRequestQueue.poll()).thenReturn(request);
        BookPublishRequest retrievedRequest = bookPublishRequestManager.getBookPublishRequestToProcess();
        assertEquals(request, retrievedRequest);
        verify(bookPublishRequestQueue, times(1)).poll();
    }
}