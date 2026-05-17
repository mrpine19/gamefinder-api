package br.com.gamefinder.controllers;

import br.com.gamefinder.models.Game;
import br.com.gamefinder.services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService){
        this.gameService = gameService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.OK)
    public Game getGameById(Long id) {
        return gameService.getGameById(id);
    }
}
