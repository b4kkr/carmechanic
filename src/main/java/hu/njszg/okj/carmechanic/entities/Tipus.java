package hu.njszg.okj.carmechanic.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "tipusok")
@Entity
public class Tipus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tipus_id")
    private Long id;
    private String tipusnev;
}
