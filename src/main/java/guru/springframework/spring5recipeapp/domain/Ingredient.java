package guru.springframework.spring5recipeapp.domain;

import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
//it will generate the get and set method.
@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
//tells jpa this class will be mapped to a table in database.
@Entity
public class Ingredient {
// primary key of entity.
    @Id
// automatically generate the unique value for the entity when the new record is inserted.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
// fields or properties of the class,representing the columns in the database table.
    private Long id;
    private String description;
    private BigDecimal amount;
//represents the OneTOone relationship.
    @OneToOne(fetch = FetchType.EAGER)
//specifies the foreign key column in the database.
    @JoinColumn(name = "uom_id")
    private UnitOfMeasure uom;
//represents the ManyTOone relationship with recipe entity.
    @ManyToOne
//specify the foreign key column in the database.
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    // No-arg constructor required by JPA
    protected Ingredient() {
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
    }

    public Ingredient(String description, BigDecimal amount, UnitOfMeasure uom, Recipe recipe) {
        this.description = description;
        this.amount = amount;
        this.uom = uom;
        this.recipe = recipe;
    }
}

