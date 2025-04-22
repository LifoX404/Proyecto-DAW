package pruebaAPI.Desempenno.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/achievements")
public class Achievements_Controller {

    @GetMapping("/listar")
    public String getAchievements() {
        return("Hola");
    }
}
