package br.com.zup.estrelas.alunos.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Aluno {

	@Id
	private Long matricula;

	@Column(nullable = false)
	private String nome;

	@Column(name = "data_nascimento")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dataNascimento;

	@Column(unique = true)
	private String cpf;

	@Column(name = "valor_mensalidade", nullable = false)
	private Float valorMensalidade;

	public long getMatricula() {
		return matricula;
	}

	public void setMatricula(long matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Float getValorMensalidade() {
		return valorMensalidade;
	}

	public void setValorMensalidade(Float valorMensalidade) {
		this.valorMensalidade = valorMensalidade;
	}

}
