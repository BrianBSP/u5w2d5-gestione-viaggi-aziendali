package brianpelinku.u5w2d5_gestione_viaggi_aziendali.services;

import brianpelinku.u5w2d5_gestione_viaggi_aziendali.repositories.DipendenteRepository;
import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;

    private Cloudinary cloudinary;
}
