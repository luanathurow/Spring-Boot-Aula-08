package br.pucrs.luana.thurow.exemplo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController

@RequestMapping("/biblioteca")
public class ExemploController {

    List<Livro> livros = new ArrayList<>();

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }

    @GetMapping("/")
    public String getMensagemInicial() {
    return "Aplicacao Spring-Boot funcionando!";
    }
    @GetMapping("/livros")
    public String getLivros() {
    return "fd";
    }

}
