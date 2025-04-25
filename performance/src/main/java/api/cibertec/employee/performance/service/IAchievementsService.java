package api.cibertec.employee.performance.service;

import api.cibertec.employee.performance.model.Achievements;

import java.util.List;
import java.util.Optional;

public interface IAchievementsService {

    public List<Achievements> findAll();

    // Lista según el ID
    public Optional<Achievements> findById(Long id);

    // Guarda el achievement
    public void save(Achievements achievements);

    // Desactiva el status a 0
    public void logicDelete(Long id);

    // Lista según el ID del empleado
    public List<Achievements> findAchievementsByEmployeeId(Long id);

    // Lista los Achievements activos
    public List<Achievements> findAchievementsActive();
}
