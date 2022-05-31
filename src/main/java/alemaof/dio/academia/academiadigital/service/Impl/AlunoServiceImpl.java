package alemaof.dio.academia.academiadigital.service.Impl;

import alemaof.dio.academia.academiadigital.entity.Aluno;
import alemaof.dio.academia.academiadigital.entity.AvaliacaoFisica;
import alemaof.dio.academia.academiadigital.entity.form.AlunoForm;
import alemaof.dio.academia.academiadigital.entity.form.AlunoUpdateForm;
import alemaof.dio.academia.academiadigital.infra.utils.JavaTimeUtils;
import alemaof.dio.academia.academiadigital.repository.AlunoRepository;
import alemaof.dio.academia.academiadigital.repository.AvaliacaoFisicaRepository;
import alemaof.dio.academia.academiadigital.service.IAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AlunoServiceImpl implements IAlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

    @Override
    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        aluno.setNome(form.getNome());
        aluno.setCpf(form.getCpf());
        aluno.setBairro(form.getBairro());
        aluno.setDataDeNascimento(form.getDataDeNascimento());

        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno get(Long id) {
        return alunoRepository.findById(id).get();
    }

    @Override
    public List<Aluno> getAll(String dataDeNascimento) {
        if (dataDeNascimento == null) {
            return alunoRepository.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(dataDeNascimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return alunoRepository.findByDataDeNascimento(localDate);
        }
    }

    @Override
    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        Aluno aluno = alunoRepository.findById(id).get();
        aluno.setNome(formUpdate.getNome());
        aluno.setBairro(formUpdate.getBairro());
        aluno.setDataDeNascimento(formUpdate.getDataDeNascimento());
        return alunoRepository.save(aluno);
    }

    @Override
    public void delete(Long id) {
        alunoRepository.deleteById(id);

    }

    @Override
    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
        Aluno aluno = alunoRepository.findById(id).get();
        return aluno.getAvaliacoes();
    }
}
