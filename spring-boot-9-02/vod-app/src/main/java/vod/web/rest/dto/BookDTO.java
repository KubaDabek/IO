package vod.web.rest.dto;

import lombok.Data;

@Data
public class BookDTO {
    private String title;
    private String poster;
    private int authorId;
    private float rating;
}