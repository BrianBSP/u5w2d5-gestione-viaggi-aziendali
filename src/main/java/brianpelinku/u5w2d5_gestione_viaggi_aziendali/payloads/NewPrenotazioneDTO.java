package brianpelinku.u5w2d5_gestione_viaggi_aziendali.payloads;

import brianpelinku.u5w2d5_gestione_viaggi_aziendali.entities.Dipendente;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.entities.Viaggio;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record NewPrenotazioneDTO(
        @NotEmpty(message = "La data di richiesta della prenotazione è obbligatoria.")
        LocalDate dataDiRichiesta,
        @NotEmpty(message = "Inserire delle note. Campo aggiuntivo.")
        String noteAggiuntive,

        Dipendente dipendenteId,
        Viaggio viaggio
) {
}
