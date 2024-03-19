package tajiri.relationtables.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String lastname;

    private String name;
    private String firstname;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classe_id")
    @JsonBackReference
    private Classe classe;
}
