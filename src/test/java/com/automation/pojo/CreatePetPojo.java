package com.automation.pojo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CreatePetPojo {
    int id;
    Category category;
    String name;
    List<String> photoUrls;
    List<Tag> tags;
    String status;

    // Nested POJOs for category and tags
    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode
    public static class Category {
        int id;
        String name;
    }

    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode
    public static class Tag {
        int id;
        String name;
    }
}
