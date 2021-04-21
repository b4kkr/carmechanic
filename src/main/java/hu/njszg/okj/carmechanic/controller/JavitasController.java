package hu.njszg.okj.carmechanic.controller;

import hu.njszg.okj.carmechanic.entities.Javitas;
import hu.njszg.okj.carmechanic.service.JavitasService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;

import java.util.List;

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

        List<Javitas> javitas = javitasService.getJavitasokRendezve();
        model.addAttribute("javitasSzur", new Javitas());
        model.addAttribute("javitasok", javitas);
        return "index";
    }

    @GetMapping("/javitasok/javitas/{id}")
    public String getJavitasById(
        @PathVariable("id") Long id,
        Model model
    ){
        model.addAttribute("javitas", javitasService.getJavitasById(id));
        return "javitas";
    }

    @GetMapping("/javitasok/mentes")
    public String javitasokMenteseCsv(){
        javitasService.javitasokFajlbaKiir();
        return "redirect:/javitasok";
    }

    @PostMapping("/javitasok/szures")
    public String adatokSzurese(
        @ModelAttribute Javitas javitasSzur,
        Model model
    ){
        model.addAttribute("javitasSzur", new Javitas());
        model.addAttribute("javitasok", javitasService.getJavitasokSzereloNevMinAr(javitasSzur.getSzerelo().getNev(), javitasSzur.getIranyar()));
        return "index";
    }

    @GetMapping("/javitasok/uj")
    public String getUjJavitasokForm(Model model){
        model.addAttribute("javitas", new Javitas());
        return "ujjavitas";
    }

    @PostMapping("/javitasok/uj/mentes")
    public String javitasMent(
        @ModelAttribute Javitas javitasDto
    ){
        javitasService.mentes(javitasDto);
        return "redirect:/";
    }

}
