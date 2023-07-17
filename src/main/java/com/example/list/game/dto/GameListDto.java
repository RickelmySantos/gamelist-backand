package com.example.list.game.dto;

import com.example.list.game.entity.GameList;

public class GameListDto {

    private Long id;
    private String name;

    public GameListDto(GameList entity){
        id = entity.getId();
        name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
