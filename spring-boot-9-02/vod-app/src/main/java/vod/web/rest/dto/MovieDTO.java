package vod.web.rest.dto;

import lombok.Data;

@Data
public class MovieDTO {
    private String title;
    private String poster;
    private int directorId;
    private float rating;
}