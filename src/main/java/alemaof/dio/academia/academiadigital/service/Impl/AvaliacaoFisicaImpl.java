package alemaof.dio.academia.academiadigital.service.Impl;

import alemaof.dio.academia.academiadigital.entity.Aluno;
import alemaof.dio.academia.academiadigital.entity.AvaliacaoFisica;
import alemaof.dio.academia.academiadigital.entity.form.AvaliacaoFisicaForm;
import alemaof.dio.academia.academiadigital.entity.form.AvaliacaoFisicaUpdateForm;
import alemaof.dio.academia.academiadigital.repository.AlunoRepository;
import alemaof.dio.academia.academiadigital.repository.AvaliacaoFisicaRepository;
import alemaof.dio.academia.academiadigital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaImpl implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        avaliacaoFisica.setAluno(aluno);
        avaliacaoFisica.setPeso(form.getPeso());
        avaliacaoFisica.setAltura(form.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public AvaliacaoFisica get(Long id) {
        return avaliacaoFisicaRepository.findById(id).get();
    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaRepository.findById(id).get();
        avaliacaoFisica.setPeso(formUpdate.getPeso());
        avaliacaoFisica.setAltura(formUpdate.getAltura());

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public void delete(Long id) {
        avaliacaoFisicaRepository.deleteById(id);
    }
}
