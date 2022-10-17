package br.deffa.poke.api.repositories;

import br.deffa.poke.api.model.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, String> {
}
