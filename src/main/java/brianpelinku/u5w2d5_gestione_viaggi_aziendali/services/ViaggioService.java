package brianpelinku.u5w2d5_gestione_viaggi_aziendali.services;

import brianpelinku.u5w2d5_gestione_viaggi_aziendali.repositories.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;

}
