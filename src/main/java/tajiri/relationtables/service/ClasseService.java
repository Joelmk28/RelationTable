package tajiri.relationtables.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import tajiri.relationtables.model.Classe;
import tajiri.relationtables.repository.IClasseRepository;

import java.util.List;
@Service
@AllArgsConstructor

public class ClasseService implements IClasseService{
    private final IClasseRepository iClasseRepository;
    @Override
    public Classe createClasse(Classe classe) {
        return iClasseRepository.save(classe);
    }

    @Override
    public List<Classe> getClassesList() {
        return iClasseRepository.findAll();
    }

    @Override
    public Classe updateClasse(long id, Classe classe) {
        return iClasseRepository.findById(id).map(c->{
            c.setName(classe.getName());
            c.setNombre_student(classe.getNombre_student());
            c.setStudentList(classe.getStudentList());
            return iClasseRepository.save(c);
        }).orElseThrow(()->new RuntimeException("cette classe n'existe pas"));
    }

    @Override
    public String deleteClasse(long id) {
        iClasseRepository.deleteById(id);
        return "cette classe a été supprimée avec succes";
    }
    @Override
    public  Classe createOrRead(Classe classe){
        Classe classExist = iClasseRepository.findClasseByName(classe.getName());
        if(classExist == null){
            classExist = classe;
        }
        return classExist;
    }
}
