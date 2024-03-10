package com.jobproject.joblisting.Repository;

import com.jobproject.joblisting.Model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostRepository extends MongoRepository<Post, String> {
}
