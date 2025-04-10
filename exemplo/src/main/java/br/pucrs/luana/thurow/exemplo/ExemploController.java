package br.pucrs.luana.thurow.exemplo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/biblioteca")
public class ExemploController {

    List<Livro> livros = new ArrayList<>();

    public ExemploController() {
        livros.add(new Livro(1, "Jogos Vorazes", "Luana Thurow", 2000));
        livros.add(new Livro(2, "Turma da Monica", "Mauricio de Souza", 1950));
        livros.add(new Livro(3, "Harry Potter", "J.K. Rowling", 1983));
    }

    @GetMapping("/livrosautor")
    public List<Livro> getLivrosDoAutor(@RequestParam(value = "autor") String autor) {
        return livros.stream()
            .filter(livro->livro.getAutor().equals(autor))
            .toList();
    }

    @PostMapping("/novolivro")
    public boolean cadastraLivroNovo(@RequestBody final Livro livro) {
    livros.add(livro);
    return true;
    }

    @GetMapping("/livrotitulo/{titulo}")
    public ResponseEntity<Livro> getLivroTitulo(@PathVariable("titulo") String titulo) {
    Livro resp = livros.stream()
    .filter(livro->livro.getTitulo().equals(titulo))
    .findFirst()
    .orElse(null); 
    return ResponseEntity
    .status(HttpStatus.OK)
    .body(resp);
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
