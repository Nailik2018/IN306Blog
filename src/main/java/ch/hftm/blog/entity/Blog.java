package ch.hftm.blog.entity;

import jakarta.json.bind.annotation.JsonbTransient;
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
    @JsonbTransient
    private long id;
//    @NotNull
    @NotBlank(message = "Der Titel darf nicht leer sein")
    @Size.List({
        @Size(min = 2, message = "Der Titel muss mindestens 2 Zeichen lang sein"),
        @Size(max = 128, message = "Der Titel darf maximal 128 Zeichen lang sein")
    })
    private String title;
    private String content;

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "ID")
    private Author author;
}