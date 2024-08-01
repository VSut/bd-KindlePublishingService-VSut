package com.amazon.ata.kindlepublishingservice.publishing;

import javax.inject.Inject;
import java.util.Queue;

public class BookPublishRequestManager {

    Queue<BookPublishRequest> bookPublishRequestQueue;

    /**
     * Instantiates a new BookPublishRequestManager object.
     * @param bookPublishRequestQueue The queue of book publish requests.
     */
    @Inject
    public BookPublishRequestManager(Queue<BookPublishRequest> bookPublishRequestQueue) {
        this.bookPublishRequestQueue = bookPublishRequestQueue;
    }

    /**
     * Adds a book publish request to the queue.
     * @param bookPublishRequest The book publish request to add to the queue.
     */
    public void addBookPublishRequest(BookPublishRequest bookPublishRequest) {
        bookPublishRequestQueue.offer(bookPublishRequest);
    }

    /**
     * Retrieves the next book publish request to process from the queue.
     * @return The next book publish request to process.
     */
    public BookPublishRequest getBookPublishRequestToProcess() {
        return bookPublishRequestQueue.poll();
    }


}
