package brianpelinku.u5w2d5_gestione_viaggi_aziendali.services;

import brianpelinku.u5w2d5_gestione_viaggi_aziendali.entities.Viaggio;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.exceptions.NotFoundException;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.payloads.NewDipendenteRespDTO;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.payloads.NewViaggioDTO;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;

    // salvo nuovo viaggio nel DB --> post + body
    public NewDipendenteRespDTO saveViaggio(NewViaggioDTO body) {

        Viaggio newViaggio = new Viaggio();
        newViaggio.setDestinazione(body.destinazione());
        newViaggio.setDataPrenotazione(body.dataPrenotazione());
        newViaggio.setStatoViaggio(body.statoViaggio());


        // salvo il nuovo record
        return new NewDipendenteRespDTO(this.viaggioRepository.save(newViaggio).getId());
    }

    public Page<Viaggio> findAll(int page, int size, String sortBy) {
        if (page > 20) page = 20;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.viaggioRepository.findAll(pageable);
    }

    // cerco viaggio byId
    public Viaggio findById(int viaggioId) {
        return this.viaggioRepository.findById(viaggioId).orElseThrow(() -> new NotFoundException(viaggioId));
    }

    // delete Viaggio
    public void findByIdAndDelete(int viaggioId) {
        Viaggio trovato = this.findById(viaggioId);
        this.viaggioRepository.delete(trovato);
    }
}
