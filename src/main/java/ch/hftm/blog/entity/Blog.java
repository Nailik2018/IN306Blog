package ch.hftm.blog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class Blog {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String content;

//    public Blog(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }

    public Blog(){
    }

    public Blog(String title, String content){
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
