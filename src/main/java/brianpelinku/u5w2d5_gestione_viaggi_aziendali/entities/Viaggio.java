package brianpelinku.u5w2d5_gestione_viaggi_aziendali.entities;

import brianpelinku.u5w2d5_gestione_viaggi_aziendali.enums.StatoViaggio;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "viaggi")
public class Viaggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String destinazione;
    @Column(name = "data_prenotazione")
    private LocalDate dataPrenotazione;
    @Column(name = "stato_viaggio")
    @Enumerated(EnumType.STRING)
    private StatoViaggio statoViaggio;
}
