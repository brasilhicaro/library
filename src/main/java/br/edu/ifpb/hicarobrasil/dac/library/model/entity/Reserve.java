package br.edu.ifpb.hicarobrasil.dac.library.model.entity;

import java.sql.Date;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "reserve")
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "loan")
    private Date loan;
    @Column(name = "devolution")
    private Date devolution;
    @Column(name = "bookID")
    private long bookID;
}
