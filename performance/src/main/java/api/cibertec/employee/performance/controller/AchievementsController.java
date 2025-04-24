package api.cibertec.employee.performance.controller;

import api.cibertec.employee.performance.service.IAchievementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/achievements")
public class AchievementsController {

    @Autowired
    private IAchievementsService achievementsService;

}
