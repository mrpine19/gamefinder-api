package br.com.gamefinder.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    private String description;
    private LocalDate releaseDate;
    private Double rating;
    
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;
    
    @ManyToOne
    @JoinColumn(name = "platform_id")
    private Platform platform;
    
    private String coverUrl;
    private String backdropUrl; // corrigido de backdoprUrl para bater com o SQL
    private boolean inWishlist; // corrigido para inWishlist (SQL usa in_wishlist)
}
