package br.com.gamefinder.services;

import br.com.gamefinder.models.Genre;
import br.com.gamefinder.repositories.GenreRepository;
import org.springframework.stereotype.Service;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre getGenreById(Long id) {
        return genreRepository.findById(id).orElseThrow(
                () -> new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND, "Genre not found")
        );
    }
}
