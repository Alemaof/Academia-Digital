package alemaof.dio.academia.academiadigital.controller;

import alemaof.dio.academia.academiadigital.entity.Aluno;
import alemaof.dio.academia.academiadigital.entity.AvaliacaoFisica;
import alemaof.dio.academia.academiadigital.entity.form.AlunoForm;
import alemaof.dio.academia.academiadigital.entity.form.AlunoUpdateForm;
import alemaof.dio.academia.academiadigital.service.Impl.AlunoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @GetMapping
    public List<Aluno> getAll(@RequestParam(value = "dataDeNascimento", required = false) String dataDeNascimento) { return service.getAll(dataDeNascimento);}

    @PostMapping
    public Aluno create(@Valid @RequestBody AlunoForm form) { return service.create(form);}

    @GetMapping("/avaliacoes/")
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(@RequestParam(value = "id") Long id) {
        return service.getAllAvaliacaoFisicaId(id);
    }

    @PutMapping
    public Aluno atualizaAluno(@Valid @RequestParam(value = "id") Long id, @RequestBody AlunoUpdateForm form) {
        return service.update(id, form);
    }

    @GetMapping("/")
    public Aluno getAluno(@RequestParam(value = "id") Long id){
        return service.get(id);
    }

    @DeleteMapping
    public void deleteAluno(Long id){
        service.delete(id);
    }
}
