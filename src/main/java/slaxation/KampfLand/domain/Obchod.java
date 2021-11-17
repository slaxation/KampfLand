package slaxation.KampfLand.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "obchod")
public class Obchod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int obchod_id;

    @Column(name = "nazov_obchodu")
    private String nazov;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "obchod")
    private List<Prevadzka> prevadzky;




}
