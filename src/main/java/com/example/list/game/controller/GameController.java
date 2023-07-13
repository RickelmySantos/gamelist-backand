package com.example.list.game.controller;

import com.example.list.game.dto.GameMinDto;
import com.example.list.game.entity.Game;
import com.example.list.game.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    GameService gameService;
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }
    @GetMapping
    public ResponseEntity<List<GameMinDto>> findAll(){
        List<GameMinDto> result = gameService.findAll();
        return ResponseEntity.ok(result);
    }
}
