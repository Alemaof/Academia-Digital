package alemaof.dio.academia.academiadigital.controller;

import alemaof.dio.academia.academiadigital.entity.AvaliacaoFisica;
import alemaof.dio.academia.academiadigital.entity.form.AvaliacaoFisicaForm;
import alemaof.dio.academia.academiadigital.entity.form.AvaliacaoFisicaUpdateForm;
import alemaof.dio.academia.academiadigital.service.Impl.AvaliacaoFisicaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

	@Autowired
	private AvaliacaoFisicaImpl avaliacaoFisicaService;

	@PostMapping
	public AvaliacaoFisica create(@Valid @RequestBody AvaliacaoFisicaForm form) {
		return avaliacaoFisicaService.create(form);
	}

	@GetMapping("/")
	public AvaliacaoFisica get(@Param(value = "id") Long id){
		return avaliacaoFisicaService.get(id);
	}

	@PutMapping
	public AvaliacaoFisica update(@Valid @Param(value = "id") Long id, @RequestBody AvaliacaoFisicaUpdateForm form){
		return avaliacaoFisicaService.update(id, form);
	}

	@GetMapping
	public List<AvaliacaoFisica> getAll(){
		return avaliacaoFisicaService.getAll();
	}

	@DeleteMapping
	public void deleteAvaliacao(Long id){
		avaliacaoFisicaService.delete(id);
	}
}
