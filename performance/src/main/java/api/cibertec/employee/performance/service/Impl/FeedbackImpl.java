package api.cibertec.employee.performance.service.Impl;

import api.cibertec.employee.performance.model.Feedback;
import api.cibertec.employee.performance.persistence.IFeedbackDAO;
import api.cibertec.employee.performance.service.IFeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackImpl implements IFeedbackService {

    @Autowired
    private IFeedbackDAO feedbackDAO;

    @Override
    public List<Feedback> findAll() {
        return feedbackDAO.findAll();
    }

    @Override
    public void save(Feedback feedback) {
        feedbackDAO.save(feedback);
    }

    @Override
    public List<Feedback> findFeedbackByEmployeeId(Long id) {
        return feedbackDAO.findFeedbackByEmployeeId(id);
    }
}
