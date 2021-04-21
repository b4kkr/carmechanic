package hu.njszg.okj.carmechanic.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "autosok")
public class Autos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autos_id")
    private Long id;
    @Column(unique = true)
    private String nev;
    private String rendszam;
    private String telefon;

    @ManyToOne
    @JoinColumn(name = "tipuskod", referencedColumnName = "tipus_id")
    private Tipus tipus;

}
