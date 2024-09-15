package brianpelinku.u5w2d5_gestione_viaggi_aziendali.payloads;

import jakarta.validation.constraints.NotEmpty;

public record NewViaggioDTO(
        @NotEmpty(message = "La destinazione è obbligatoria.")
        String destinazione,

        @NotEmpty(message = "la Data di prenotazione è obbligatoria.")
        String dataPrenotazione,

        @NotEmpty(message = "Lo stato del viaggio è obbligatorio.")
        String statoViaggio
) {
}
