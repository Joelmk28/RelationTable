package tajiri.relationtables.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tajiri.relationtables.model.Classe;
import tajiri.relationtables.service.ClasseService;

import java.security.Provider;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "classe")
@AllArgsConstructor
public class ClasseController {
    private final ClasseService classeService;
@PostMapping(path = "create",consumes = APPLICATION_JSON_VALUE)
@ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<String> create(@RequestBody Classe classe) {
        classeService.createClasse(classe);
        return ResponseEntity.ok("la classe a été creer avec success");
    }
@GetMapping("classes")
    public List<Classe> getClasseList() {
        return classeService.getClassesList();
    }
@PutMapping(path = "update/{id}",consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateClasse(@PathVariable long id,@RequestBody Classe classe) {
        classeService.updateClasse(id, classe);
        return ResponseEntity.ok("la classe a étéé modifier");
    }
@DeleteMapping(path ="{id}")
    public ResponseEntity<String> deleteClasse(@PathVariable long id) {
        classeService.deleteClasse(id);
        return ResponseEntity.ok("la classe a étéé suppimer");

    }



}