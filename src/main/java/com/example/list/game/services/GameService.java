package com.example.list.game.services;

import com.example.list.game.dto.GameDto;
import com.example.list.game.dto.GameMinDto;
import com.example.list.game.entity.Game;
import com.example.list.game.repositories.GameRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {
    GameRepository gameRepository;
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
        var result = gameRepository.findAll();
        List<GameMinDto> gameMinDtos = result.stream().map(x -> new GameMinDto(x)).toList();
        return gameMinDtos;
    }

    @Transactional(readOnly = true)
    public GameDto findById(Long id){
    Game result = gameRepository.findById(id).get();
    GameDto gameDto = new GameDto(result);
    return  gameDto;
    }
}
