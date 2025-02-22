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
    private int id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    // Nested POJOs for category and tags
    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode
    public static class Category {
        private int id;
        private String name;
    }

    @Getter
    @Setter
    @ToString
    @EqualsAndHashCode
    public static class Tag {
        private int id;
        private String name;
    }
}
