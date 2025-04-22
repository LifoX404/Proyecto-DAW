package pruebaAPI.Desempenno.service;


import pruebaAPI.Desempenno.model.Achievements;

import java.util.List;

public interface IAchievementsService {

     public List<Achievements> findAll();

     public Achievements findById(long id);

     public Achievements save(Achievements achievements);

     public void eliminadoLogico(long id);

     public List<Achievements> findByEmployeeId(long id);



}
