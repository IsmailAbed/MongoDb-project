package com.jobproject.joblisting.Repository;

import com.jobproject.joblisting.Model.Post;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchRepoImp implements SearchRepository{

    @Autowired
    MongoConverter mongoConverter;

    @Autowired
    MongoClient mongoClient;
    @Override
    public List<Post> findByText(String text) {
        final List<Post> posts =  new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("listingdb");
        MongoCollection<Document> collection = database.getCollection("JobPost");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                        new Document("index", "default")
                                .append("text",
                                        new Document("query", "java")
                                                .append("path", Arrays.asList("techs", "description", "profile")))),
                new Document("$sort",
                        new Document("exp", 1L)),
                new Document("$limit", 5L)));

        //result.forEach(document -> posts.add(document));// i cant since doc is different format
        // doc is doc format , post is java format , so we use covertor

        result.forEach(document -> posts.add(mongoConverter.read(Post.class, document)));


        return posts;
    }
}
