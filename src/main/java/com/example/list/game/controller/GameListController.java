package com.example.list.game.controller;

import com.example.list.game.dto.GameListDto;
import com.example.list.game.dto.GameMinDto;
import com.example.list.game.dto.ReplacementDTO;
import com.example.list.game.entity.GameList;
import com.example.list.game.services.GameListService;
import com.example.list.game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/list")
public class GameListController {
    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;
    @GetMapping
    public ResponseEntity<List<GameListDto>> findAll(){
        List<GameListDto> result = gameListService.findAll();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/{listId}/games")
    public ResponseEntity<List<GameMinDto>> findGames(@PathVariable long listId){
        List<GameMinDto> gameMinDtos = gameService.findByGameList(listId);
        return ResponseEntity.ok().body(gameMinDtos);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
