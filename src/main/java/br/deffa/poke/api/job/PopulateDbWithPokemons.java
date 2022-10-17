package br.deffa.poke.api.job;

import br.deffa.poke.api.job.dtos.PokemonMap;
import br.deffa.poke.api.model.PokeImage;
import br.deffa.poke.api.model.Pokemon;
import br.deffa.poke.api.model.Type;
import br.deffa.poke.api.repositories.PokeImageRepository;
import br.deffa.poke.api.repositories.PokemonRepository;
import br.deffa.poke.api.repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PopulateDbWithPokemons {

    public static String URL_POKEMON = "https://pokeapi.co/api/v2/pokemon-form/";


    @Autowired
    private PokemonRepository pokemonRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    PokeImageRepository pokeImageRepository;



    @PostConstruct
    public void createPokemons() {


        RestTemplate restTemplate = new RestTemplate();
        for (int i = 151; i <= 152; i++) {

            PokemonMap pokemonMap = restTemplate.getForObject(URL_POKEMON + i, PokemonMap.class);
            Pokemon pokemon = new Pokemon();
            List<PokeImage> pokeImageList = new ArrayList<>();

            pokemonMap.getSprites().forEach((k, v) -> {
                var image = new PokeImage();
                image.setName(k);
                image.setLink(v);
                image.setPokemon(pokemon);
                pokeImageList.add(image);
            });

            List<Type> types = pokemonMap.getTypes().stream().map(t -> {
                Type type = new Type();
                type.setName(t.getType().getName());
                return type;
            }).collect(Collectors.toList());

            pokemon.setName(pokemonMap.getName());
            pokemon.setId_px(Integer.valueOf(pokemonMap.getId()));
            pokemon.setImages(pokeImageList);
            pokemon.setTypes(types);
            pokemon.setIsShiny(false);

            typeRepository.saveAll(types);
            pokemonRepository.save(pokemon);
            pokeImageRepository.saveAll(pokeImageList);





        }


    }
}
