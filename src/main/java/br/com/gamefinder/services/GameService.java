package br.com.gamefinder.services;

import br.com.gamefinder.models.Game;
import br.com.gamefinder.repositories.GameRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository){
        this.gameRepository = gameRepository;
    }

    public Page<Game> getAllGames(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }

    public Game getGameById(Long id){
        return gameRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found")
        );
    }

    public void updateFromWishlist(Long gameId) {
        Game game = getGameById(gameId);
        game.setInWishlist(!game.isInWishlist());
        gameRepository.save(game);
    }
}
