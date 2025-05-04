package api.cibertec.employee.performance.persistence.Impl;

import api.cibertec.employee.performance.model.Feedback;
import api.cibertec.employee.performance.persistence.IFeedbackDAO;
import api.cibertec.employee.performance.repository.Feedback_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeedbackDAOImpl implements IFeedbackDAO {

    @Autowired
    Feedback_Repository repository;


    @Override
    public List<Feedback> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Feedback feedback) {
        repository.save(feedback);
    }

    @Override
    public List<Feedback> findFeedbackByEmployeeId(Long id) {
        return repository.findFeedbackByEmployeeId(id);
    }
}
