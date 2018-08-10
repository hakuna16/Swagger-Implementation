package com.rituj.swaggerImpl.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.query.N1qlQuery;
import com.couchbase.client.java.query.N1qlQueryResult;
import com.couchbase.client.java.query.N1qlQueryRow;
import com.rituj.swaggerImpl.common.CBJsonObjectTransformer;
import com.rituj.swaggerImpl.common.CouchbaseHelper;
import com.rituj.swaggerImpl.domain.Book;

@Repository
public class BookRepository {

    @Autowired
    private CouchbaseHelper couchbaseHelper;

    @Autowired
    private CBJsonObjectTransformer transformer;

    @Autowired
    private Bucket bucket;

    public List<Book> getBookById(Integer id) {
        String statement = "Select meta().id from `" + bucket.name() + "` where bookId=" + id;
        N1qlQueryResult n1qlQueryResult = bucket.query(N1qlQuery.simple(statement));
        List<N1qlQueryRow> bookRows = n1qlQueryResult.allRows();
        List<String> booksIds = new ArrayList<>();
        bookRows.forEach(item -> booksIds.add(item.value().getString("id")));
        return transformer.toObjects(couchbaseHelper.get(bucket, booksIds), Book.class);
    }

    public Book addBook(final Book book) {
        return transformer.toObject(couchbaseHelper.createDocument(bucket, book), Book.class);
    }
}
