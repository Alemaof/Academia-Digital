package alemaof.dio.academia.academiadigital.controller;

import alemaof.dio.academia.academiadigital.entity.Matricula;
import alemaof.dio.academia.academiadigital.entity.form.MatriculaForm;
import alemaof.dio.academia.academiadigital.service.Impl.MatriculaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaServiceImpl service;

    @PostMapping
    public Matricula create(@Valid @RequestBody MatriculaForm form){
        return service.create(form);
    }

    @RequestMapping
    public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro){
        return service.getAll(bairro);
    }

    @RequestMapping("/")
    public Matricula getMatricula(@Param(value = "id") Long id){
        return service.get(id);
    }

    @DeleteMapping
    public void  deleteMatricula(@Param(value = "id") Long id){
        service.delete(id);
    }


}
