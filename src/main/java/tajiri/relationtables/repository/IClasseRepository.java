package tajiri.relationtables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tajiri.relationtables.model.Classe;

public interface IClasseRepository extends JpaRepository<Classe,Long> {
    Classe findClasseByName(String name);
}
