package br.com.gamefinder.assembler;

import br.com.gamefinder.controllers.GameController;
import br.com.gamefinder.dtos.GameResponseDTO;
import br.com.gamefinder.models.Game;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class GameAssembler implements RepresentationModelAssembler<Game, EntityModel<GameResponseDTO>> {
    @Override
    public EntityModel<GameResponseDTO> toModel(Game game) {
        GameResponseDTO dto = new GameResponseDTO(game.getId(), game.getTitle());
        return EntityModel.of(
                dto,
                linkTo(methodOn(GameController.class).getGameById(game.getId())).withSelfRel()
        );
    }
}
