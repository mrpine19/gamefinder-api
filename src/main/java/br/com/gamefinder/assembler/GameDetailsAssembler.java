package br.com.gamefinder.assembler;

import br.com.gamefinder.controllers.GameController;
import br.com.gamefinder.models.Game;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class GameDetailsAssembler implements RepresentationModelAssembler<Game, EntityModel<Game>> {

    @Override
    public EntityModel<Game> toModel(Game game) {

        EntityModel<Game> model = EntityModel.of(
                game,

                linkTo(methodOn(GameController.class)
                        .getGameById(game.getId()))
                        .withSelfRel()
                        .withTitle(game.getTitle()),

                linkTo(methodOn(GameController.class)
                        .getGenreById(game.getGenre().getId()))
                        .withRel("same-genre")
                        .withTitle("Games in " + game.getGenre().getName() + " genre"),

                linkTo(methodOn(GameController.class)
                        .getPlatformById(game.getPlatform().getId()))
                        .withRel("same-platform")
                        .withTitle("Games on " + game.getPlatform().getName())
        );

        if (game.isInWishlist()) {

            model.add(
                    linkTo(methodOn(GameController.class)
                            .updateFromWishlist(game.getId()))
                            .withRel("remove-from-wishlist")
                            .withTitle("Remove " + game.getTitle() + " from wishlist")
                            .withType("GET")
            );

        } else {

            model.add(
                    linkTo(methodOn(GameController.class)
                            .updateFromWishlist(game.getId()))
                            .withRel("add-to-wishlist")
                            .withTitle("Add " + game.getTitle() + " to wishlist")
                            .withType("GET")
            );
        }

        return model;
    }
}
