package ch.hftm.blog.entity;

import jakarta.persistence.*;
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
    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "ID")
    private Author author;
}