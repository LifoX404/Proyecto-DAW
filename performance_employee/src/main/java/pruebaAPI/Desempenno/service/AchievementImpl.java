package pruebaAPI.Desempenno.service;

import org.springframework.beans.factory.annotation.Autowired;
import pruebaAPI.Desempenno.model.Achievements;
import pruebaAPI.Desempenno.repository.Achievements_Repository;

import java.util.List;


public class AchievementImpl implements IAchievementsService{


    @Autowired
    Achievements_Repository repository;

    @Override
    public List<Achievements> findAll() {
        return repository.findAll();
    }

    @Override
    public Achievements findById(long id) {
        return repository.findById(id).isPresent() ? repository.findById(id).get() : null;
    }

    @Override
    public Achievements save(Achievements achievements) {
        return  repository.save(achievements);
    }

    @Override
    public void eliminadoLogico(long id) {
        Achievements achievement = repository.findById(id).orElseThrow(() -> new RuntimeException("No encontrado"));
        achievement.setStatusAchievement(false);
        repository.save(achievement);
    }

    @Override
    public List<Achievements> findByEmployeeId(long employeeId) {
        List<Achievements>
    }

}
