package ch.hftm.blog.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Blog {
    @Id
    @GeneratedValue
    private long id;
//    @NotNull
    @NotBlank(message = "Der Titel darf nicht leer sein")
    @Size.List({
        @Size(min = 3, message = "Der Titel muss mindestens 3 Zeichen lang sein"),
        @Size(max = 50, message = "Der Titel darf maximal 50 Zeichen lang sein")
    })
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "ID")
    private Author author;
}