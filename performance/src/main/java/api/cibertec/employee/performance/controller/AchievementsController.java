package api.cibertec.employee.performance.controller;

import api.cibertec.employee.performance.controller.dto.AchievementsDTO;
import api.cibertec.employee.performance.mapper.AchievementsMapper;
import api.cibertec.employee.performance.model.Achievements;
import api.cibertec.employee.performance.service.IAchievementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/achievements")
public class AchievementsController {

    @Autowired
    private IAchievementsService achievementsService;

    @Autowired
    private AchievementsMapper achievementsMapper;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        Optional<Achievements> achievementsOptional = achievementsService.findById(id);

        if(achievementsOptional.isPresent()){
            AchievementsDTO achievementsDTO = achievementsMapper.toDTO(achievementsOptional.get());
            return ResponseEntity.ok(achievementsDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/list")
    public ResponseEntity<List<AchievementsDTO>> listActiveAchievements(){
        List<Achievements> activeAchievements = achievementsService.findAchievementsActive();

        if(activeAchievements.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        List<AchievementsDTO> achievementsDTO_active = activeAchievements.stream()
                .map(achievementsMapper::toDTO).
                collect(Collectors.toList());

        return ResponseEntity.ok(achievementsDTO_active);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll(){

        List<Achievements> achievements = achievementsService.findAll();

        if(achievements.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        List<AchievementsDTO> achievementsDTOs = achievements.stream()
                .map(achievementsMapper::toDTO).
                collect(Collectors.toList());

        return ResponseEntity.ok(achievementsDTOs);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody AchievementsDTO achievementsDTO){
        if(achievementsDTO.getDescription().isBlank() || achievementsDTO.getCategory().isBlank() || achievementsDTO.getIdEmployee() == null){
    return ResponseEntity.badRequest().build();
        }
        Achievements achievements = achievementsMapper.toEntity(achievementsDTO);
        achievementsService.save(achievements);

        try{
            return ResponseEntity.created(new URI("/api/achievements/save")).build();
        }
        catch(URISyntaxException e){
            return ResponseEntity.internalServerError().build();
        }
    }

}
