package com.example.list.game.services;

import com.example.list.game.dto.GameMinDto;
import com.example.list.game.entity.Game;
import com.example.list.game.repositories.GameRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    GameRepository gameRepository;
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    public List<GameMinDto> findAll(){
        var result = gameRepository.findAll();
        List<GameMinDto> gameMinDtos = result.stream().map(x -> new GameMinDto(x)).toList();
        return gameMinDtos;
    }
}
