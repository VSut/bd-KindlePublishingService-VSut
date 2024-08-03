package com.amazon.ata.kindlepublishingservice.dagger;

import com.amazon.ata.kindlepublishingservice.clients.RecommendationsServiceClient;
//import com.amazon.ata.kindlepublishingservice.metrics.MetricsPublisher;
import com.amazon.ata.kindlepublishingservice.publishing.BookPublishRequest;
import com.amazon.ata.recommendationsservice.RecommendationsService;

import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

@Module
public class ClientsModule {

    @Singleton
    @Provides
    public RecommendationsServiceClient provideRecommendationsServiceClient(
        RecommendationsService recommendationsService) {
        return new RecommendationsServiceClient(recommendationsService);
    }

    @Singleton
    @Provides
    public ConcurrentLinkedQueue<BookPublishRequest> provideBookPublishRequestQueue() {
        return new ConcurrentLinkedQueue<BookPublishRequest>();
    }
}
