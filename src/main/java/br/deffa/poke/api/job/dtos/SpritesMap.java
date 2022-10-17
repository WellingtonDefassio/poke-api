package br.deffa.poke.api.job.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SpritesMap {
    private String back_default;
    private String back_female;
    private String back_shiny;
    private String back_shiny_female;
    private String front_default;
    private String front_female;
    private String front_shiny;
    private String front_shiny_female;
}
