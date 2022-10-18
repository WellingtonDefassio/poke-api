package br.deffa.poke.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Pokemon {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private Integer id_px;
   private String name;
   private Boolean isShiny;
   private Integer generate;

   @OneToMany(cascade = CascadeType.ALL, mappedBy = "pokemon", fetch = FetchType.LAZY)
   private List<PokeImage> images;

   @ManyToMany()
   private List<Type> types;


}
