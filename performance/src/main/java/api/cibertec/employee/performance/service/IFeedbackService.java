
package api.cibertec.employee.performance.service;

import api.cibertec.employee.performance.model.Feedback;

import java.util.List;

public interface IFeedbackService {

    public List<Feedback> findAll();

    public void save(Feedback feedback);

    public  List<Feedback> findFeedbackByEmployeeId(Long id);


}

