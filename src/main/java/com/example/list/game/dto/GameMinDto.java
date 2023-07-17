package com.example.list.game.dto;

import com.example.list.game.entity.Game;
import com.example.list.game.projections.GameMinProjection;

import java.util.List;

public class GameMinDto {
    private Long id;
    private String title;

    private Integer year;

    private String imgUrl;

    private String shortDescription;

    public GameMinDto() {
    }

    public GameMinDto(Game entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.year = entity.getYear();
        this.imgUrl = entity.getImgUrl();
        this.shortDescription = entity.getShortDescription();
    }

    public GameMinDto(GameMinProjection projection) {
        id = projection.getId();
        title = projection.getTitle();
        year = projection.getGameYear();
        imgUrl = projection.getImgUrl();
        shortDescription = projection.getShortDescription();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void add(List<GameMinDto> gameMinDtos) {

    }
}
