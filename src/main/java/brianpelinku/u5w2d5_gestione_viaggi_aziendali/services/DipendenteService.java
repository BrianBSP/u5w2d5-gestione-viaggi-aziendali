package brianpelinku.u5w2d5_gestione_viaggi_aziendali.services;

import brianpelinku.u5w2d5_gestione_viaggi_aziendali.entities.Dipendente;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.exceptions.BadRequestException;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.payloads.NewDipendenteDTO;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.repositories.DipendenteRepository;
import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    private Cloudinary cloudinary;

    // salvo nuovo dipendente nel DB --> post + body
    public Dipendente saveDipendente(NewDipendenteDTO body) {

        this.dipendenteRepository.findByEmail(body.email()).ifPresent(author -> {
            throw new BadRequestException("L'email " + body.email() + " è già in uso.");
        });
        Dipendente newDip = new Dipendente(body.username(), body.nome(), body.cognome(), body.email(),
                "https://ui-avatars.com/api/?name=" + body.nome() + "+" + body.cognome());

        // salvo il nuovo record
        return this.dipendenteRepository.save(newDip);
    }

    // cerco tutti i dipendenti
    public Page<Dipendente> findAll(int page, int size, String sortBy) {
        if (page > 20) page = 20;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.dipendenteRepository.findAll(pageable);
    }

}
