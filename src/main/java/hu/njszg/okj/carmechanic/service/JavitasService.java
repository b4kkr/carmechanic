package hu.njszg.okj.carmechanic.service;

import hu.njszg.okj.carmechanic.entities.Autos;
import hu.njszg.okj.carmechanic.entities.Javitas;
import hu.njszg.okj.carmechanic.entities.Szerelo;
import hu.njszg.okj.carmechanic.repository.JavitasRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class JavitasService {

    private final JavitasRepository javitasRepository;

    public List<Javitas> getJavitasokRendezve(){
        return javitasRepository.getJavitasok();
    }

    public Javitas getJavitasById(Long id){
        return javitasRepository.getJavitasById(id);
    }

    public void javitasokFajlbaKiir(){
        List<Javitas> javitasok = javitasRepository.getJavitasok();
        //ToDo CSV fájlba írást megcsinálni
        // localdatetime osztály használata
    }

    public List<Javitas> getJavitasokSzereloNevMinAr(String szerelo, int minar){
        return javitasRepository.getJavitasokBySzereloMinAr(szerelo, minar);
    }

    public void mentes(Javitas javitasDto){
        try {
            Szerelo szerelo = javitasRepository.getSzereloNevAlapjan(javitasDto.getSzerelo().getNev());
            Autos autos = javitasRepository.getAutosNevAlapjan(javitasDto.getAutos().getNev());
            Javitas dbJavitas = new Javitas();
            dbJavitas.setDatum(LocalDate.now());
            dbJavitas.setJavido(javitasDto.getJavido());
            dbJavitas.setIranyar(javitasDto.getIranyar());
            dbJavitas.setAutos(autos);
            dbJavitas.setSzerelo(szerelo);
            javitasRepository.javitasMentes(dbJavitas);
        }
        catch (Exception e){
            //ToDo: elegáns exception kezelés, ha nem találja a szerelőt vagy az autóst
            e.printStackTrace();
        }
    }
}
