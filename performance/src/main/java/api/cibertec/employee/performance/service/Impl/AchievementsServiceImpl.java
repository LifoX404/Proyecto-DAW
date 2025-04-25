package api.cibertec.employee.performance.service.Impl;

import api.cibertec.employee.performance.model.Achievements;
import api.cibertec.employee.performance.persistence.IAchievementsDAO;
import api.cibertec.employee.performance.service.IAchievementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AchievementsServiceImpl implements IAchievementsService {

    @Autowired
    private IAchievementsDAO achievementsDAO;

    @Override
    public List<Achievements> findAll() {
        return achievementsDAO.findAll();
    }

    @Override
    public Optional<Achievements> findById(Long id) {
        return achievementsDAO.findById(id);
    }

    @Override
    public void save(Achievements achievements) {
        achievementsDAO.save(achievements);
    }

    @Override
    public void logicDelete(Long id) {
        achievementsDAO.logicDelete(id);
    }

    @Override
    public List<Achievements> findAchievementsByEmployeeId(Long id) {
        return achievementsDAO.findAchievementsByEmployeeId(id);
    }

    @Override
    public List<Achievements> findAchievementsActive() {
        return achievementsDAO.findAchievementsActive();
    }


}
