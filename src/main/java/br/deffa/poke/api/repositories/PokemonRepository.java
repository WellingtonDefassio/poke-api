package br.deffa.poke.api.repositories;

import br.deffa.poke.api.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
}
