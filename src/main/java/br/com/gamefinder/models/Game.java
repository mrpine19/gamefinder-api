package br.com.gamefinder.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game {
    private Long id;
    private String title;
    private String description;
    private LocalDate releaseDate;
    private Double rating;
    private Genre genre;
    private Platform platform;
    private String coverUrl;
    private String backdoprUrl;
    private boolean inWishList;
}
