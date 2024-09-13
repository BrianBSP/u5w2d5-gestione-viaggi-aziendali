package brianpelinku.u5w2d5_gestione_viaggi_aziendali.exceptions;

import java.time.LocalDateTime;

public record ErrorsPayload(
        String message,
        LocalDateTime timestamp
) {
}
