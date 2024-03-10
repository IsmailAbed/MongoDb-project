package com.jobproject.joblisting.Repository;

import com.jobproject.joblisting.Model.Post;

import java.util.List;

public interface SearchRepository {
    List<Post> findByText(String text);
}
