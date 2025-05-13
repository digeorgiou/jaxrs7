package gr.aueb.cf.schoolapp.dao;

import gr.aueb.cf.schoolapp.model.Teacher;
import jakarta.enterprise.context.ApplicationScoped;

//αυτο μπαινει για να γινει new η κλαση στο IOC και να μπορει να γινει inject
// στο service
@ApplicationScoped //δημιουργειται ενα μονο TeacherDAOImpl
public class TeacherDAOImpl extends AbstractDAO<Teacher> implements ITeacherDAO{

    public TeacherDAOImpl() {
        this.setPersistenceClass(Teacher.class);
    }

}
