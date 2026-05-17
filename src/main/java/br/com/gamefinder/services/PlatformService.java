package br.com.gamefinder.services;

import br.com.gamefinder.models.Platform;
import br.com.gamefinder.repositories.PlatformRepository;
import org.springframework.stereotype.Service;

@Service
public class PlatformService {
    private final PlatformRepository platformRepository;

    public PlatformService(PlatformRepository platformRepository) {
        this.platformRepository = platformRepository;
    }

    public Platform getPlatformById(Long id) {
        return platformRepository.findById(id).orElseThrow(
                () -> new org.springframework.web.server.ResponseStatusException(org.springframework.http.HttpStatus.NOT_FOUND, "Platform not found")
        );
    }

}
