package com.jobproject.joblisting.Model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

//JobPost -> collection name
@Document(collection = "JobPost")// bas ytla3 empty bel postman lezem hayda l class y3rf , since bel repository htyna post butClass post not aware of this
public class Post {
    private String profile;
    private String description;
    private int exp;
    private String techs[];

    public Post() {
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public String[] getTechs() {
        return techs;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    @Override
    public String toString() {
        return "Post{" +
                "profile='" + profile + '\'' +
                ", description='" + description + '\'' +
                ", exp=" + exp +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }
}
