package brianpelinku.u5w2d5_gestione_viaggi_aziendali.controllers;

import brianpelinku.u5w2d5_gestione_viaggi_aziendali.entities.Viaggio;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.exceptions.BadRequestException;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.payloads.NewDipendenteRespDTO;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.payloads.NewViaggioDTO;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.payloads.NewViaggioRespDTO;
import brianpelinku.u5w2d5_gestione_viaggi_aziendali.services.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    // POST --> creo un nuovo record --- +body
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public NewViaggioRespDTO saveViaggio(@RequestBody @Validated NewViaggioDTO viaggio, BindingResult validation) {
        if (validation.hasErrors()) {
            String messages = validation
                    .getAllErrors()
                    .stream()
                    .map(error -> error.getDefaultMessage())
                    .collect(Collectors.joining(". "));
            throw new BadRequestException("Segnalazione Errori nel Payload. " + messages);
        } else {
            return new NewViaggioRespDTO(this.viaggioService.saveViaggio(viaggio).dipendenteId());
        }
    }

    // GET All
    @GetMapping
    public Page<Viaggio> getAllViaggi(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "5") int size,
                                      @RequestParam(defaultValue = "id") String sortBy) {
        return this.viaggioService.findAll(page, size, sortBy);
    }

    // GET byId
    @GetMapping("/{viaggiId}")
    public NewDipendenteRespDTO findviaggiById(@PathVariable int viaggiId) {
        return new NewDipendenteRespDTO(this.viaggioService.findById(viaggiId).getId());
    }

    // PUT   +body
    /*@PutMapping("/{viaggiId}")
    public NewDipendenteRespDTO findByIdAndUpdate(@PathVariable int viaggiId, @RequestBody NewDipendenteDTO newDipendente) {
        return new NewDipendenteRespDTO(this.viaggioService.findByIdAndUpdate(viaggiId, newDipendente).viaggiId());
    }*/

    // DELETE
    @DeleteMapping("/{viaggiId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findByIdAndDelete(@PathVariable int viaggiId) {
        viaggioService.findByIdAndDelete(viaggiId);
    }
}
