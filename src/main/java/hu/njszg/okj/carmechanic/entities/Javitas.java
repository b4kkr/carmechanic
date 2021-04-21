package hu.njszg.okj.carmechanic.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "javitasok")
public class Javitas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "javitas_id")
    private Long id;
    private LocalDate datum;
    private int javido;
    private int iranyar;

    @ManyToOne
    @JoinColumn(name = "szerelo_id", referencedColumnName = "szerelo_id")
    private Szerelo szerelo;
    @ManyToOne
    @JoinColumn(name = "autos_id", referencedColumnName = "autos_id")
    private Autos autos;
}
