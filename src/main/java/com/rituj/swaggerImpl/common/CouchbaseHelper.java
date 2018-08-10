package com.rituj.swaggerImpl.common;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.document.JsonDocument;

/**
 * This is a helper class to access couchbase DB based on set of parameters.
 *
 * @author rituj
 */
@Component
public class CouchbaseHelper {

    @Autowired
    private CBJsonObjectTransformer cbJsonObjectTransformer;

    /**
     * Fetches a list of {@link JsonDocument} objects for given list of document ids from couchbase DB
     * from given bucket instance.
     *
     * @param bucket instance of the couchbase bucket
     * @param documentIds list of document ids which needs to be fetched
     * @return list of {@link JsonDocument} objects
     */
    public List<JsonDocument> get(final Bucket bucket, final List<String> documentIds) {
    	 Assert.notNull(bucket, "Cannot fetch if bucket is null!");
         Assert.notEmpty(documentIds, "Cannot get json document for empty list of document ids!");

         return documentIds.stream().map(documentId -> getJsonDocument(bucket, documentId)).collect(Collectors.toList());
    }

    /**
     * Fetches a {@link JsonDocument} object for given document id from couchbase DB
     * from given bucket instance.
     *
     * @param bucket instance of the couchbase bucket
     * @param documentId document id which needs to be fetched
     * @return {@link JsonDocument} object
     */
    public JsonDocument getJsonDocument(final Bucket bucket, final String documentId) {
   	 	Assert.notNull(bucket, "Cannot fetch if bucket is null!");
        Assert.notNull(documentId, "Cannot get json document for null document id!");
        return bucket.get(documentId);
   }

    /**
     * Delete a list of documents for given list of document ids from couchbase DB from given bucket instance.
     * Returns list of {@link JsonDocument} objects that have been removed.
     *
     * @param bucket instance of the couchbase bucket
     * @param documentIds list of document ids which needs to be removed
     * @return list of {@link JsonDocument} objects
     */
	public List<JsonDocument> remove(final Bucket bucket, final List<String> documentIds) {
		Assert.notNull(bucket, "Cannot fetch if bucket is null!");
		Assert.notEmpty(documentIds, "Cannot delete json document for empty list of document ids!");

		return documentIds.stream().map(documentId -> removeDocument(bucket, documentId)).collect(Collectors.toList());
	}

    /**
     * Delete a document for given document id from couchbase DB from given bucket instance.
     * Returns {@link JsonDocument} object that has been removed.
     *
     * @param bucket instance of the couchbase bucket
     * @param documentId list of document id which needs to be removed
     * @return {@link JsonDocument} object
     */
    public JsonDocument removeDocument(final Bucket bucket, final String documentId) {
        Assert.notNull(bucket, "Cannot fetch if bucket is null!");
        Assert.hasText(documentId, "Cannot delete json document for blank document id!");

        return bucket.remove(documentId);
    }
}
