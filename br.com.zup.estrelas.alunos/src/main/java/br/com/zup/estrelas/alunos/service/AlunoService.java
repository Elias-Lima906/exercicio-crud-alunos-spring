package br.com.zup.estrelas.alunos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.estrelas.alunos.dto.MensagemDTO;
import br.com.zup.estrelas.alunos.entity.Aluno;
import br.com.zup.estrelas.alunos.repository.AlunoRepository;

@Service
public class AlunoService {
	
	private static final String ALUNO_EXCLUIDO_COM_SUCESSO = "ALUNO EXCLUÍDO COM SUCESSO!";
	private static final String INFORMAÇÕES_ALTERADAS_COM_SUCESSO = "INFORMAÇÕES ALTERADAS COM SUCESSO!";
	private static final String ALUNO_NÃO_ENCONTRADO = "ALUNO NÃO ENCONTRADO!";
	private static final String ALUNO_EXISTENTE = "ALUNO JÁ EXISTE NO BANCO DE DADOS!";
	private static final String ALUNO_ADICIONADO_COM_SUCESSO = "ALUNO ADICIONADO COM SUCESSO!";

	
	@Autowired
	AlunoRepository repository;

	public MensagemDTO insereAluno(Aluno aluno) {
		if (repository.existsById(aluno.getMatricula())) {
			
			return new MensagemDTO(ALUNO_EXISTENTE);
		}
		repository.save(aluno);
		return new MensagemDTO(ALUNO_ADICIONADO_COM_SUCESSO);
	}

	public Optional<Aluno> buscaAluno(Long matricula) {
		if(this.repository.existsById(matricula)) {
		return this.repository.findById(matricula);
		}
		return null;
	}

	public List<Aluno> buscaAlunos() {
		if ((List<Aluno>) repository.findAll() == null) {
			return (List<Aluno>) repository.findAll();
		}
		return (List<Aluno>) repository.findAll();
	}
	
	public MensagemDTO removeAluno(Long matricula) {

		if (repository.existsById(matricula)) {
			this.repository.deleteById(matricula);
			return new MensagemDTO(ALUNO_EXCLUIDO_COM_SUCESSO);
		}
		return new MensagemDTO(ALUNO_NÃO_ENCONTRADO);
	}

	public MensagemDTO alteraImformaçõesAluno(Aluno aluno) {
		if (repository.existsById(aluno.getMatricula())) {
			 this.repository.save(aluno);
			 return new MensagemDTO(INFORMAÇÕES_ALTERADAS_COM_SUCESSO);
		}
		return new MensagemDTO(ALUNO_NÃO_ENCONTRADO);
	}

	public Aluno BuscarPorCpf(String cpf) {
		return repository.findByCpf(cpf);
	}
}