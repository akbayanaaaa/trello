package kz.baibalaeva.demo.trelloModels;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "folders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Folders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


    @ManyToMany(fetch = FetchType.EAGER)
    private List<TaskCategories> taskCategories;


}
