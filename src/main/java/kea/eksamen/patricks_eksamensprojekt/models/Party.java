package kea.eksamen.patricks_eksamensprojekt.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "parties")
@Entity
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column(columnDefinition = "integer default 100")
    private int votes;



}
