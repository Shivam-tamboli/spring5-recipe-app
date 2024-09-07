package guru.springframework.spring5recipeapp.domain;

import javax.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
//generate automatically the get and set methods.
@Getter
@Setter
@EqualsAndHashCode(exclude = {"recipe"})
//tells jpa this will be  mapped to a table into the database.
@Entity
public class Notes {
//primary key of the entity.
    @Id
// automatically generate the unique value for entity when the new record is inserted.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
// properties.
    private Long id;

    @Lob
    private String recipeNotes;
//represents the One to One relationship
    @OneToOne(mappedBy = "notes")
    // 'mappedBy = "notes"' indicates that the Recipe entity owns the relationship.
    private Recipe recipe;
}
