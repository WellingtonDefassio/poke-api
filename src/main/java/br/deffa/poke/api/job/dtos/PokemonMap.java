package br.deffa.poke.api.job.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PokemonMap {

    private String name;
    private String id;
    private Map<String, String> sprites;
    private List<TypesMap> types;


}
