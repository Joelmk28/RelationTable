package tajiri.relationtables.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tajiri.relationtables.model.Student;

public interface IStudentRepository extends JpaRepository<Student,Long> {
}
