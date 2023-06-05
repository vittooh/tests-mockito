package com.digital.bricklayer.mockitowithjpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JornalService {

    private final JornalRepository jornalRepository;
    private final Logger logger = LoggerFactory.getLogger(JornalService.class);

    public JornalService(JornalRepository jornalRepository) {
        this.jornalRepository = jornalRepository;
    }


    public Jornal salvaJornal(Jornal jornal) {
        return jornalRepository.save(jornal);
    }

    public void alteraDataNMaisUm(List<Long> ids){
        List<Jornal> persistir = new ArrayList<>();
        jornalRepository.findByids(ids).forEach(jornal ->{
            jornal.setDataPublicacao(jornal.getDataPublicacao().plusDays(1));
            persistir.add(jornal);
        });

        jornalRepository.saveAll(persistir);
    }
}
