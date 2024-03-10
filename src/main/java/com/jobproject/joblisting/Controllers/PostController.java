package com.jobproject.joblisting.Controllers;

import com.jobproject.joblisting.Model.Post;
import com.jobproject.joblisting.Repository.PostRepository;
import com.jobproject.joblisting.Repository.SearchRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private SearchRepository Srepo;

    @RequestMapping(value="/")
    public void redirect(HttpServletResponse response)throws IOException {
         response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts(){
        return  postRepository.findAll();
    }

    // posts/java this java will putten in the variable text
    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return Srepo.findByText(text);
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        postRepository.save(post);
        return post;
    }


}
