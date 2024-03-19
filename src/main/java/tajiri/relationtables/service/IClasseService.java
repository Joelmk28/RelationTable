package tajiri.relationtables.service;

import tajiri.relationtables.model.Classe;

import java.util.List;

public interface IClasseService {
    Classe createClasse (Classe classe);
    List<Classe> getClassesList();
    Classe updateClasse(long id,Classe classe);
    String deleteClasse(long id);


}
