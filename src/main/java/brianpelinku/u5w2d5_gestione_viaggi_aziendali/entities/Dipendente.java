package brianpelinku.u5w2d5_gestione_viaggi_aziendali.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "dipendenti")
public class Dipendente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private int id;
    private String username;
    private String nome;
    private String cognome;
    private String email;
    private String avatar;

    public Dipendente(String username, String nome, String cognome, String email, String avatar) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.avatar = avatar;
    }
}
