package br.com.gamefinder.repositories;

import br.com.gamefinder.models.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform, Long> {
}
