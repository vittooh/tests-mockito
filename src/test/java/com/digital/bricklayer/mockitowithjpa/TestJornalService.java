package com.digital.bricklayer.mockitowithjpa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TestJornalService {


    @Mock
    JornalRepository jornalRepository;

    @InjectMocks
    JornalService jornalService;

    @Test
    public void deveSalvarNoBanco(){
        //give
        Jornal jornal = new Jornal("Se inscreve no canal", LocalDateTime.now());


        JornalRepository j = Mockito.mock(JornalRepository.class);

        //when
        jornalService.salvaJornal(jornal);


        //then
        Mockito.verify(jornalRepository,Mockito.times(1))
                .save(jornal);

    }

    @Test
    public void deveRealizaralteracaoComsucesso(){


        //give
        List<Long> ids = List.of(1L);
        List<Jornal> jornais = new ArrayList<>();
        Jornal jornal = new Jornal(1L,"Curte o video",LocalDateTime.now().plusDays(-1));
        jornais.add(jornal);
        ArgumentCaptor<List<Jornal>> argumentCaptor = ArgumentCaptor.forClass(List.class);

        Mockito.when(jornalRepository.findByids(ids))
                .thenReturn(jornais);

        //when
        jornalService.alteraDataNMaisUm(ids);

        //then
        Mockito.verify(jornalRepository,Mockito.times(1))
                .saveAll(argumentCaptor.capture());


        argumentCaptor.getValue().stream().forEach(jornalPersistido ->{
            Assertions.assertEquals(LocalDateTime.now().getDayOfMonth(),jornalPersistido.getDataPublicacao().getDayOfMonth() );
        });

        Assertions.assertEquals(1,argumentCaptor.getValue().size());


    }

}
