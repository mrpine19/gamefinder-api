package br.com.gamefinder.assembler;

import br.com.gamefinder.controllers.GameController;
import br.com.gamefinder.models.Game;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class GameAssembler implements RepresentationModelAssembler<Game, EntityModel<Game>> {
    @Override
    public EntityModel<Game> toModel(Game game) {
        return EntityModel.of(
                game,
                linkTo(methodOn(GameController.class).getGameById(game.getId())).withSelfRel(),
                linkTo(methodOn(GameController.class).getAllGames()).withRel("games"),
                linkTo(methodOn(GameController.class).getGenreById(game.getGenre().getId())).withRel("genre"),
                linkTo(methodOn(GameController.class).getPlatformById(game.getPlatform().getId())).withRel("platform")
        );
    }
}
