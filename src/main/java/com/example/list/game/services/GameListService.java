package com.example.list.game.services;

import com.example.list.game.dto.GameListDto;
import com.example.list.game.entity.GameList;
import com.example.list.game.projections.GameMinProjection;
import com.example.list.game.repositories.GameListRepository;
import com.example.list.game.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    public GameListRepository gameListRepository;
    @Autowired
    public GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll(){
        List<GameList> gameList = gameListRepository.findAll();
        return gameList.stream().map(GameListDto ::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {

        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
