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
// automatically generate the unique value for the primary key when the new record is inserted.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Difficulty difficulty;
    private Integer servings;
    private String source;
    private String url;

    @Lob //    field will be stored as a large object in the database
    private String directions;

// each recipe can have multiple ingredients.
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe", orphanRemoval = true)
    private Set<Ingredient> ingredients = new HashSet<>();

    @Lob
    private Byte[] image;

//each recipe can belong to multiple categories,each category can include multiple recipes.
//many-to-many relationships require a join table to link the two entities
    @ManyToMany
    @JoinTable(name = "recipe_category",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();// set ensure each category is unique in set.

//each recipes have one associated notes.
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "notes_id")
    private Notes notes;



    public void setNotes(Notes notes) {
        if (notes != null) {
            this.notes = notes;
            notes.setRecipe(this);
        }
    }

// Adds an ingredient to the recipe and ensures the bidirectional relationship is maintained.
    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
            this.ingredients.add(ingredient);
            return this;
    }


}
