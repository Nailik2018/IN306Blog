package ch.hftm.blog.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
public class Author {

    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastname;
}