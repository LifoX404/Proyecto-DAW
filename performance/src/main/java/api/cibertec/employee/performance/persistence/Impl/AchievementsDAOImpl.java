package api.cibertec.employee.performance.persistence.Impl;

import api.cibertec.employee.performance.model.Achievements;
import api.cibertec.employee.performance.persistence.IAchievementsDAO;
import api.cibertec.employee.performance.repository.Achievements_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AchievementsDAOImpl implements IAchievementsDAO {

    @Autowired
    Achievements_Repository repository;

    @Override
    public List<Achievements> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Achievements> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void save(Achievements achievements) {
        repository.save(achievements);
    }

    @Override
    public void logicDelete(Long id) {
        repository.logicDelete(id);
    }

    @Override
    public List<Achievements> findAchievementsByEmployeeId(Long id) {
        return repository.findAchievementsByEmployeeId(id);
    }

    @Override
    public List<Achievements> findAchievementsActive() {
        return repository.findAchievementsActive();
    }
}
