package br.com.gamefinder.controllers;

import br.com.gamefinder.assembler.GameAssembler;
import br.com.gamefinder.assembler.GameDetailsAssembler;
import br.com.gamefinder.dtos.GameResponseDTO;
import br.com.gamefinder.models.Game;
import br.com.gamefinder.models.Genre;
import br.com.gamefinder.models.Platform;
import br.com.gamefinder.services.GameService;
import br.com.gamefinder.services.GenreService;
import br.com.gamefinder.services.PlatformService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/games")
public class GameController {

    private final GameService gameService;
    private final GenreService genreService;
    private final PlatformService platformService;
    private final GameAssembler gameAssembler;
    private final GameDetailsAssembler gameDetailsAssembler;

    public GameController(GameService gameService, GenreService genreService, PlatformService platformService, GameAssembler gameAssembler, GameDetailsAssembler gameDetailsAssembler){
        this.gameService = gameService;
        this.genreService = genreService;
        this.platformService = platformService;
        this.gameAssembler = gameAssembler;
        this.gameDetailsAssembler = gameDetailsAssembler;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public PagedModel<EntityModel<GameResponseDTO>> getAllGames(Pageable pageable, PagedResourcesAssembler<Game> pagedAssembler) {
        Page<Game> games = gameService.getAllGames(pageable);

        return pagedAssembler.toModel(games, gameAssembler);
    }

    @GetMapping("/{gameId}")
    @ResponseStatus(HttpStatus.OK)
    public EntityModel<Game> getGameById(@PathVariable Long gameId) {

        Game game = gameService.getGameById(gameId);

        return gameDetailsAssembler.toModel(game);
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

    @GetMapping("/wishlist/{gameId}")
    public ResponseEntity<Void> updateFromWishlist(@PathVariable Long gameId) {
        gameService.updateFromWishlist(gameId);
        return ResponseEntity.ok().build();
    }
}
