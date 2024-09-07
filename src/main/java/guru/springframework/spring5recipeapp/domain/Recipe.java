package guru.springframework.spring5recipeapp.domain;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
//generate automatically getters and setters method.
@Getter
@Setter
//tells jpa it will be mapped to a table in the database.
@Entity
public class Recipe {
//primary key of the entity.
    @Id
//automatically generate the unique value for the primary key when the new record is inserted.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    properties.
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Difficulty difficulty;
    @Lob
    private String directions;

// represents the onetomany relationship.
// any changes to the recipe will also affect its related in
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe", orphanRemoval = true)
    private Set<Ingredient> ingredients = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notes_id")
    private Notes notes;


    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
            this.ingredients.add(ingredient);
            return this;
    }
}
