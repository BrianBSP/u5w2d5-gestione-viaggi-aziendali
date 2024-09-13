package brianpelinku.u5w2d5_gestione_viaggi_aziendali.services;

import brianpelinku.u5w2d5_gestione_viaggi_aziendali.entities.Dipendente;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.entities.Prenotazione;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.entities.Viaggio;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.exceptions.NotFoundException;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.payloads.NewPrenotazioneDTO;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.payloads.NewPrenotazioneRespDTO;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.repositories.PrenotazioneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PrenotazioneService {
    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private DipendenteService dipendenteService;

    @Autowired
    private ViaggioService viaggioService;

    // salvo nuovo viaggio nel DB --> post + body
    public NewPrenotazioneRespDTO savePrenotazione(NewPrenotazioneDTO body) {

        Dipendente dipendente = dipendenteService.findById(body.dipendenteId().getId());
        Viaggio viaggio = viaggioService.findById(body.viaggioId().getId());

        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDataDiRichiesta(body.dataDiRichiesta());
        prenotazione.setNoteAggiuntive(body.noteAggiuntive());
        prenotazione.setViaggio(body.viaggioId());
        prenotazione.setDipendente(body.dipendenteId());


        // salvo il nuovo record
        return new NewPrenotazioneRespDTO(this.prenotazioneRepository.save(prenotazione).getId());
    }

    // finAll
    public Page<Prenotazione> findAll(int page, int size, String sortBy) {
        if (page > 20) page = 20;
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return this.prenotazioneRepository.findAll(pageable);
    }

    // cerco Prenotazione byId
    public Prenotazione findById(int prenotazioneId) {
        return this.prenotazioneRepository.findById(prenotazioneId).orElseThrow(() -> new NotFoundException(prenotazioneId));
    }

    // delete Prenotazione
    public void findByIdAndDelete(int prenotazioneId) {
        Prenotazione trovato = this.findById(prenotazioneId);
        this.prenotazioneRepository.delete(trovato);
    }
}
