package com.digital.bricklayer.mockitowithjpa;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Jornal {

    @Id
    private Long id;

    private String tituloPrincipal;

    private LocalDateTime dataPublicacao;

    public Jornal() {
    }

    public Jornal(String tituloPrincipal, LocalDateTime dataPublicacao) {
        this.tituloPrincipal = tituloPrincipal;
        this.dataPublicacao = dataPublicacao;
    }

    public Jornal(Long id, String tituloPrincipal, LocalDateTime dataPublicacao) {
        this.id = id;
        this.tituloPrincipal = tituloPrincipal;
        this.dataPublicacao = dataPublicacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTituloPrincipal() {
        return tituloPrincipal;
    }

    public void setTituloPrincipal(String tituloPrincipal) {
        this.tituloPrincipal = tituloPrincipal;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
