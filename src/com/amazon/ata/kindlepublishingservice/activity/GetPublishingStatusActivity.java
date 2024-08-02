package com.amazon.ata.kindlepublishingservice.activity;

import com.amazon.ata.kindlepublishingservice.converters.PublishingStatusConverter;
import com.amazon.ata.kindlepublishingservice.dao.CatalogDao;
import com.amazon.ata.kindlepublishingservice.dao.PublishingStatusDao;
import com.amazon.ata.kindlepublishingservice.dynamodb.models.PublishingStatusItem;
import com.amazon.ata.kindlepublishingservice.models.PublishingStatusRecord;
import com.amazon.ata.kindlepublishingservice.models.requests.GetPublishingStatusRequest;
import com.amazon.ata.kindlepublishingservice.models.response.GetPublishingStatusResponse;
import com.amazonaws.services.lambda.runtime.Context;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class GetPublishingStatusActivity {
    PublishingStatusDao publishingStatusDao;
    CatalogDao catalogDao;
    @Inject
    public GetPublishingStatusActivity(PublishingStatusDao publishingStatusDao, CatalogDao catalogDao) {
        this.publishingStatusDao = publishingStatusDao;
        this.catalogDao = catalogDao;
    }

    public GetPublishingStatusResponse execute(GetPublishingStatusRequest publishingStatusRequest) {
        List<PublishingStatusItem> publishingStatusItems = publishingStatusDao.getPublishingStatuses(publishingStatusRequest.getPublishingRecordId());
        ArrayList<PublishingStatusRecord> publishingStatusRecords = new ArrayList<>();
        PublishingStatusConverter publishingStatusConverter = new PublishingStatusConverter(catalogDao);
        for(PublishingStatusItem pi : publishingStatusItems) {
            publishingStatusRecords.add(publishingStatusConverter.toPublishingStatusRecord(pi));
        }
        GetPublishingStatusResponse response = GetPublishingStatusResponse.builder().withPublishingStatusHistory(publishingStatusRecords).build();
        return response;
    }
}
