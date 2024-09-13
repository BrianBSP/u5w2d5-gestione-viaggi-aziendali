package brianpelinku.u5w2d5_gestione_viaggi_aziendali.payloads;

import brianpelinku.u5w2d5_gestione_viaggi_aziendali.enums.StatoViaggio;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDate;

public record NewViaggioDTO(
        @NotEmpty(message = "La destinazione è obbligatoria")
        String destinazione,
        @NotEmpty(message = "Il nome è obbligatorio")
        LocalDate dataPrenotazione,
        @NotEmpty(message = "Inserire lo stato del viaggion. Campo obbligatorio.")
        StatoViaggio statoViaggio
) {
}
