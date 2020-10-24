package br.com.zup.estrelas.alunos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.estrelas.alunos.dto.MensagemDTO;
import br.com.zup.estrelas.alunos.entity.Aluno;
import br.com.zup.estrelas.alunos.service.AlunoService;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

	@Autowired
	AlunoService alunoService;

	MensagemDTO mensagemDTO;

	@PostMapping
	public MensagemDTO insereAluno(@RequestBody Aluno aluno) {
		return this.alunoService.insereAluno(aluno);
	}

	@GetMapping(path = "/{matricula}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Optional<Aluno> buscaAluno(@PathVariable Long matricula) {
		return alunoService.buscaAluno(matricula);
	}

	@GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
	public List<Aluno> buscaAlunos() {
		return (List<Aluno>) alunoService.buscaAlunos();
	}

	@DeleteMapping(path = "/{matricula}")
	public MensagemDTO removeAluno(@PathVariable Long matricula) {
		return this.alunoService.removeAluno(matricula);

	}

	@PutMapping
	public MensagemDTO alteraImformaçõesAluno(@RequestBody Aluno aluno) {
		return this.alunoService.alteraImformaçõesAluno(aluno);
	}

	@GetMapping(path = "/cpf/{cpf}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Aluno BuscarPorCpf(@PathVariable String cpf) {
		return alunoService.BuscarPorCpf(cpf);
	}

}