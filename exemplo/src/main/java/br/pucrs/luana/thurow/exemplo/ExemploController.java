package br.pucrs.luana.thurow.exemplo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/biblioteca")
public class ExemploController {

    List<Livro> livros = new ArrayList<>();

    public ExemploController() {
        livros.add(new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien", 200));
        livros.add(new Livro(2, "Dom Casmurro", "Machado de Assis", 1999));
        livros.add(new Livro(3, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", 1983));
    }

    @PostMapping("/cadastro")
    public String cadastroLivro(@RequestBody Livro livro) {
        return "Livro cadastrado com sucesso: " + livro.getTitulo();
    }    

    @GetMapping("/")
    public String getMensagemInicial() {
        return "Aplicação Spring-Boot funcionando!";
    }

    @GetMapping("/livros")
    public List<Livro> getLivros() {
        return livros;
    }
}
