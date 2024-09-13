package brianpelinku.u5w2d5_gestione_viaggi_aziendali.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("L'elemento con id " + id + " non è stato trovato.");
    }
}
