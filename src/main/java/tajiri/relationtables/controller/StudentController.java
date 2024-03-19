package tajiri.relationtables.controller;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tajiri.relationtables.model.Student;
import tajiri.relationtables.service.StudentService;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "student")
@AllArgsConstructor
public class StudentController {
    private final StudentService StudentService;
    @PostMapping(path = "create",consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<String> create(@RequestBody Student student) {

        StudentService.createStudent(student);
        return ResponseEntity.ok("la Student a été creer avec success");
    }
    @GetMapping("students")
    public List<Student> getStudentList() {
        return StudentService.getStudentsList();
    }
    @PutMapping(path = "update/{id}",consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateStudent(@PathVariable long id,@RequestBody Student student) {
        StudentService.updateStudent(id, student);
        return ResponseEntity.ok("l'étudiant a été modifier");
    }
    @DeleteMapping(path ="{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable long id) {
        StudentService.deleteStudent(id);
        return ResponseEntity.ok("l'étudiant a été suppimer");

    }



}