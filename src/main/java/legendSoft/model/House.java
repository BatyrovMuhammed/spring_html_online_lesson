package legendSoft.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class House {

    @Id
    @SequenceGenerator(name = "house_seq",sequenceName = "house_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "house_seq")
    private Long id;
    private String name;
    @Column(length = 100000)
    private String image;
    private int price;
    @Column(length = 10000)
    private String description;
    private String address;
    private int countPerson;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "house")
    private List<Comment> comments;

    public void addComment(Comment comment){
        if (comments == null){
            comments = new ArrayList<>();
        }
        comments.add(comment);
    }

}
