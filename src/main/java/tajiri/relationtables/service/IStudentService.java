package tajiri.relationtables.service;

import tajiri.relationtables.model.Student;

import java.util.List;

public interface IStudentService {
    Student createStudent (Student Student);
    List<Student> getStudentsList();
    Student updateStudent(long id,Student Student);
    String deleteStudent(long id);

}
