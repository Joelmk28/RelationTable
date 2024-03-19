package tajiri.relationtables.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tajiri.relationtables.model.Classe;
import tajiri.relationtables.model.Student;
import tajiri.relationtables.repository.IClasseRepository;
import tajiri.relationtables.repository.IStudentRepository;
import tajiri.relationtables.repository.IStudentRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class StudentService implements IStudentService {
    private final IStudentRepository iStudentRepository;
    private final ClasseService classeService;
    @Override
    public Student createStudent(Student student) {
        Classe classeExist = classeService.createOrRead(student.getClasse());
        student.setClasse(classeExist);
        return iStudentRepository.save(student);
    }

    @Override
    public List<Student> getStudentsList() {
        return iStudentRepository.findAll();
    }

    @Override
    public Student updateStudent(long id, Student Student) {
        return iStudentRepository.findById(id).map(s->{
            s.setName(Student.getName());
            s.setFirstname(Student.getFirstname());
            s.setLastname(Student.getLastname());
            return iStudentRepository.save(s);
        }).orElseThrow(()->new RuntimeException("cet étudiant n'existe pas"));
    }

    @Override
    public String deleteStudent(long id) {
        iStudentRepository.deleteById(id);
        return "cet étudiant a été supprimé avec succes";
    }
}
