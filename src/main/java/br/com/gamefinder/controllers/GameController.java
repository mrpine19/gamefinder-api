package br.com.gamefinder.controllers;

import br.com.gamefinder.models.Game;
import br.com.gamefinder.models.Genre;
import br.com.gamefinder.models.Platform;
import br.com.gamefinder.services.GameService;
import br.com.gamefinder.services.GenreService;
import br.com.gamefinder.services.PlatformService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;
    private final GenreService genreService;
    private final PlatformService platformService;

    public GameController(GameService gameService, GenreService genreService, PlatformService platformService){
        this.gameService = gameService;
        this.genreService = genreService;
        this.platformService = platformService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    @GetMapping("/{gameId}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGameById(@PathVariable Long gameId) {
        return gameService.getGameById(gameId);
    }

    @GetMapping("/genres/{genreId}")
    @ResponseStatus(HttpStatus.OK)
    public Genre getGenreById(@PathVariable Long genreId) {
        return genreService.getGenreById(genreId);
    }

    @GetMapping("/platforms/{platformId}")
    @ResponseStatus(HttpStatus.OK)
    public Platform getPlatformById(@PathVariable Long platformId) {
        return platformService.getPlatformById(platformId);
    }
}
