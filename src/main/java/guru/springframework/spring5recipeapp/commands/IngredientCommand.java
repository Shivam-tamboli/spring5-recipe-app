package guru.springframework.spring5recipeapp.commands;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class IngredientCommand {
    private Long id;
    private Long recipeId;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasureCommand uom; // Assuming you have a UnitOfMeasureCommand class

    // Getters and Setters

}
