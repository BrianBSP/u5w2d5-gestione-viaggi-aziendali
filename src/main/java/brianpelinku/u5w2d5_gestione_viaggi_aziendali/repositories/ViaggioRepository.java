package brianpelinku.u5w2d5_gestione_viaggi_aziendali.repositories;

import brianpelinku.u5w2d5_gestione_viaggi_aziendali.entities.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViaggioRepository extends JpaRepository<Viaggio, Integer> {
}
