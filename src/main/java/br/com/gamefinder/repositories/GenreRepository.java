package br.com.gamefinder.repositories;

import br.com.gamefinder.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
