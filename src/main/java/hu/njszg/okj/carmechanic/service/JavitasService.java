package hu.njszg.okj.carmechanic.service;

import hu.njszg.okj.carmechanic.entities.Autos;
import hu.njszg.okj.carmechanic.entities.Javitas;
import hu.njszg.okj.carmechanic.repository.JavitasRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JavitasService {

    private final JavitasRepository javitasRepository;

    public List<Javitas> getJavitasokRendezve(){
        return javitasRepository.getJavitasok();
    }
}
