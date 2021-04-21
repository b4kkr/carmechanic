package hu.njszg.okj.carmechanic.controller;

import hu.njszg.okj.carmechanic.service.JavitasService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class JavitasController {

    private final JavitasService javitasService;

    @GetMapping
    public String redirectToJaviatsok(){
        return "redirect:/javitasok";
    }

    @GetMapping("/javitasok")
    public String getJavitasok(Model model){
        model.addAttribute("javitasok", javitasService.getJavitasokRendezve());
        return "index";
    }

}
