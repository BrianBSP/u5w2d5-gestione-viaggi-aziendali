package brianpelinku.u5w2d5_gestione_viaggi_aziendali.repositories;

import brianpelinku.u5w2d5_gestione_viaggi_aziendali.entities.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DipendenteRepository extends JpaRepository<Dipendente, Integer> {

    Optional<Dipendente> findByEmail(String email);
}
