package api.cibertec.employee.performance.persistence;

import api.cibertec.employee.performance.model.Achievements;

import java.util.List;
import java.util.Optional;

public interface IAchievementsDAO {

    public List<Achievements> findAll();

    public Optional<Achievements> findById(Long id);

    public void save(Achievements achievements);

    public void eliminadoLogico(Long id);

    public List<Achievements> findByEmployeeId(Long id);

    public List<Achievements> listAchievements();
}
