package alemaof.dio.academia.academiadigital.service.Impl;

import alemaof.dio.academia.academiadigital.entity.Aluno;
import alemaof.dio.academia.academiadigital.entity.Matricula;
import alemaof.dio.academia.academiadigital.entity.form.MatriculaForm;
import alemaof.dio.academia.academiadigital.repository.AlunoRepository;
import alemaof.dio.academia.academiadigital.repository.MaticulaRepository;
import alemaof.dio.academia.academiadigital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MaticulaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;


    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();

        matricula.setAluno(aluno);
        return matriculaRepository.save(matricula);
    }

    @Override
    public Matricula get(Long id) {
        return matriculaRepository.findById(id).get();
    }

    @Override
    public List<Matricula> getAll(String bairro) {
        if (bairro == null) {
            return matriculaRepository.findAll();
        } else {
            return matriculaRepository.findByAlunoBairro(bairro);
        }
    }

    @Override
    public void delete(Long id) {
        matriculaRepository.deleteById(id);
    }
}
