package api.cibertec.employee.performance.persistence;

import api.cibertec.employee.performance.model.Feedback;
import java.util.List;

public interface IFeedbackDAO {

    public List<Feedback> findAll();

    public void save(Feedback feedback);

    public  List<Feedback> findFeedbackByEmployeeId(Long id);


}
