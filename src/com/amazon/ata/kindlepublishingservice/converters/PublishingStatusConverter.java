package com.amazon.ata.kindlepublishingservice.converters;

import com.amazon.ata.kindlepublishingservice.dao.CatalogDao;
import com.amazon.ata.kindlepublishingservice.dynamodb.models.PublishingStatusItem;
import com.amazon.ata.kindlepublishingservice.models.PublishingStatusRecord;

public class PublishingStatusConverter {
    CatalogDao catalogDao;

    public PublishingStatusConverter(CatalogDao catalogDao) {
        this.catalogDao = catalogDao;
    }
    public PublishingStatusRecord toPublishingStatusRecord(PublishingStatusItem publishingStatusItem) {
        return PublishingStatusRecord.builder()
            .withBookId(publishingStatusItem.getBookId())
            .withStatus(publishingStatusItem.getStatus().toString())
            .withStatusMessage(publishingStatusItem.getStatusMessage())
            .build();
    }
}
