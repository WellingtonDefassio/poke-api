package br.deffa.poke.api.repositories;

import br.deffa.poke.api.model.PokeImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokeImageRepository extends JpaRepository<PokeImage, Integer> {
}
