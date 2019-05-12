package ong.semear.model.bean.cadastros;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import com.sun.istack.Nullable;

@Entity
@Table(name="ALUNO")
public class Aluno implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	 
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "ID")
	    private Integer id;
	    @Column(name = "NOME")
	    private String nome;
	    @Column(name = "DATA_MATRICULA")
	    @Temporal(TemporalType.DATE)
	    private Date dataMatricula;
	    @Column(name = "DATA_NASCIMENTO")
	    @Temporal(TemporalType.DATE)
	    private Date dataNascimento;
	    @Column(name = "N_MATRICULA")
	    private String nmatricula;
	    @Column(name = "GRUPO")
	    private String grupo;
	    @Column(name = "TURNO")
	    private String turno;
	    
	    
	    @Column(name = "CERTIDAO")
	    private String certidao;
	    @Column(name = "CARTORIO")
	    private String CARTORIO;
	    @Column(name = "TERMO")
	    private String termo;
	    @Column(name = "RG_NUMERO")
	    private String rg_numero;
	    @Column(name = "RG_ORGAO")
	    private String rg_orgao;
	    @Column(name = "RG_DATEMISSAO")
	    @Temporal(TemporalType.DATE)
	    private Date rg_dataemissao;
	    @Column(name = "CPF")
	    @CPF(message="CPF informado esta errado.")
	    @NotBlank(message="Preencha o campo CPF")
	    private String cpf;
	    @Column(name = "NATURALIDADE")
	    private String natural;
	    
	    	    
	    @Column(name = "LOGRADOURO")
	    private String logradouro;
	    @Column(name = "NUMERO")
	    private String numero;
	    @Column(name = "COMPLEMENTO")
	    private String complemento;
	    @Column(name = "BAIRRO")
	    private String bairro;
	    @Column(name = "CIDADE")
	    private String cidade;
	    @Column(name = "CEP")
	    private String cep;
	    @Column(name = "FONE")
	    private String fone;
	    
	    
	    @Column(name = "NOME_PAI")
	    private String nome_pai;
	    @Column(name = "NOME_MAE")
	    private String nome_mae;
	    @Column(name = "CASA_PROPRIA")
	    private String casa_propria;
	    @Column(name = "QTO_FAMILIA")
	    private String qto_familia;
	    @Column(name = "QTO_FAMILIA_MAIORES")
	    private String qto_familia_maiores;
	    @Column(name = "QTO_FAMILIA_MENORES")
	    private String qto_familia_menores;
	    @Column(name = "PAI_SEPARADOS")
	    private String pai_separado;
	    @Column(name = "DIA_VISITA")
	    private String dia_visita;
	    @Column(name = "NOME_ESCOLA")
	    private String nome_escola;
	    @Column(name = "ANO_CURSANDO")
	    private String ano_cursando;
	    @Column(name = "TURMA")
	    private String turma;
	    @Column(name = "TURNO_2")
	    private String turno_2;
	    @Column(name = "BENEFICIO")
	    private String beneficio;
	    @Column(name = "NIS")
	    private String nis;
	    @Column(name = "RACA_COR")
	    private String raca_cor;
	    @Column(name = "NIS_ALUNO")
	    private String nis_aluno;
	    @Column(name = "SAUDE_ESF")
	    private String saude_esf;
	    @Column(name = "CRAS_REF")
	    private String cras_ref;
	    @Column(name = "CURSO_PRETENDIDO")
	    private String curso_pretendido;
	    @Column(name = "OBS_FILIACAO")
	    private String obs_filiacao;
	    
	    	    
	    @Column(name = "MEDICACAO")
	    private String medicacao;
	    @Column(name = "ALERGIA")
	    private String alergia;
	    @Column(name = "COMPORTAMENTO_CASA")
	    private String comportamento_casa;
	    @Column(name = "COMPORTAMENTO_ESCOLA")
	    private String comportamento_escola;
	    @Column(name = "MEDIA_ESCOLAR")
	    private String media_escolar;
	    @Column(name = "PRIORITARIO")
	    private String prioritario;
	    
	    
	    @Column(name = "RG_PAI")
	    private String rg_pai;
	    @Temporal(TemporalType.DATE)
	    @Column(name = "DATA_NASCIMENTO_PAI")
	    private Date data_nascimento_pai;
	    @Column(name = "NATURAL_PAI")
	    private String natural_pai;
	    @Column(name = "UF_PAI")
	    private String uf_pai;
	    @Column(name = "CPF_PAI")
	    private String cpf_pai;
	    @Column(name = "TITULO_PAI")
	    private String titulo_pai;
	    @Column(name = "ZONA_PAI")
	    private String zona_pai;
	    @Column(name = "SECAO_PAI")
	    private String secao_pai;
	    @Column(name = "MUNICIPIO_PAI")
	    private String municipio_pai;
	    @Column(name = "UF_TITULO_PAI")
	    private String uf_titulo_pai;
	    @Temporal(TemporalType.DATE)
	    @Column(name = "DATA_EMISSAO_TITULO_PAI")
	    private Date data_emissao_titulo_pai;
	    @Column(name = "LOCAL_TRAB_PAI")
	    private String local_trab_pai;
	    @Column(name = "FONE_PAI")
	    private String fone_pai;
	    
	    
	    @Column(name = "RG_MAE")
	    private String rg_mae;
	    @Temporal(TemporalType.DATE)
	    @Column(name = "DATA_NASCIMENTO_MAE")
	    private Date data_nascimento_mae;
	    @Column(name = "NATURAL_MAE")
	    private String natural_mae;
	    @Column(name = "UF_MAE")
	    private String uf_mae;
	    @Column(name = "CPF_MAE")
	    private String cpf_mae;
	    @Column(name = "TITULO_MAE")
	    private String titulo_mae;
	    @Column(name = "ZONA_MAE")
	    private String zona_mae;
	    @Column(name = "SECAO_MAE")
	    private String secao_mae;
	    @Column(name = "MUNICIPIO_MAE")
	    private String municipio_mae;
	    @Column(name = "UF_TITULO_MAE")
	    private String uf_titulo_mae;
	    @Temporal(TemporalType.DATE)
	    @Column(name = "DATA_EMISSAO_TITULO_MAE")
	    private Date data_emissao_titulo_mae;
	    @Column(name = "LOCAL_TRAB_MAE")
	    private String local_trab_mae;
	    @Column(name = "FONE_MAE")
	    private String fone_mae;
	    @OneToMany(fetch = FetchType.LAZY, mappedBy = "aluno", cascade = CascadeType.ALL)
	    private Set<Imagem> listaImagem;
	    
	    
	    
	    
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public Date getDataMatricula() {
			return dataMatricula;
		}
		public void setDataMatricula(Date dataMatricula) {
			this.dataMatricula = dataMatricula;
		}
		public Date getDataNascimento() {
			return dataNascimento;
		}
		public void setDataNascimento(Date dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
		public String getNmatricula() {
			return nmatricula;
		}
		public void setNmatricula(String nmatricula) {
			this.nmatricula = nmatricula;
		}
		public String getGrupo() {
			return grupo;
		}
		public void setGrupo(String grupo) {
			this.grupo = grupo;
		}
		public String getTurno() {
			return turno;
		}
		public void setTurno(String turno) {
			this.turno = turno;
		}
		public String getCertidao() {
			return certidao;
		}
		public void setCertidao(String certidao) {
			this.certidao = certidao;
		}
		public String getCARTORIO() {
			return CARTORIO;
		}
		public void setCARTORIO(String cARTORIO) {
			CARTORIO = cARTORIO;
		}
		public String getTermo() {
			return termo;
		}
		public void setTermo(String termo) {
			this.termo = termo;
		}
		public String getRg_numero() {
			return rg_numero;
		}
		public void setRg_numero(String rg_numero) {
			this.rg_numero = rg_numero;
		}
		public String getRg_orgao() {
			return rg_orgao;
		}
		public void setRg_orgao(String rg_orgao) {
			this.rg_orgao = rg_orgao;
		}
		public Date getRg_dataemissao() {
			return rg_dataemissao;
		}
		public void setRg_dataemissao(Date rg_dataemissao) {
			this.rg_dataemissao = rg_dataemissao;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getNatural() {
			return natural;
		}
		public void setNatural(String natural) {
			this.natural = natural;
		}
		public String getLogradouro() {
			return logradouro;
		}
		public void setLogradouro(String logradouro) {
			this.logradouro = logradouro;
		}
		public String getNumero() {
			return numero;
		}
		public void setNumero(String numero) {
			this.numero = numero;
		}
		public String getComplemento() {
			return complemento;
		}
		public void setComplemento(String complemento) {
			this.complemento = complemento;
		}
		public String getBairro() {
			return bairro;
		}
		public void setBairro(String bairro) {
			this.bairro = bairro;
		}
		public String getCidade() {
			return cidade;
		}
		public void setCidade(String cidade) {
			this.cidade = cidade;
		}
		public String getCep() {
			return cep;
		}
		public void setCep(String cep) {
			this.cep = cep;
		}
		public String getFone() {
			return fone;
		}
		public void setFone(String fone) {
			this.fone = fone;
		}
		public String getNome_pai() {
			return nome_pai;
		}
		public void setNome_pai(String nome_pai) {
			this.nome_pai = nome_pai;
		}
		public String getNome_mae() {
			return nome_mae;
		}
		public void setNome_mae(String nome_mae) {
			this.nome_mae = nome_mae;
		}
	
		public String getQto_familia() {
			return qto_familia;
		}
		public void setQto_familia(String qto_familia) {
			this.qto_familia = qto_familia;
		}
		public String getQto_familia_maiores() {
			return qto_familia_maiores;
		}
		public void setQto_familia_maiores(String qto_familia_maiores) {
			this.qto_familia_maiores = qto_familia_maiores;
		}
		public String getQto_familia_menores() {
			return qto_familia_menores;
		}
		public void setQto_familia_menores(String qto_familia_menores) {
			this.qto_familia_menores = qto_familia_menores;
		}
		
		public String getDia_visita() {
			return dia_visita;
		}
		public void setDia_visita(String dia_visita) {
			this.dia_visita = dia_visita;
		}
		public String getNome_escola() {
			return nome_escola;
		}
		public void setNome_escola(String nome_escola) {
			this.nome_escola = nome_escola;
		}
		public String getAno_cursando() {
			return ano_cursando;
		}
		public void setAno_cursando(String ano_cursando) {
			this.ano_cursando = ano_cursando;
		}
		public String getTurma() {
			return turma;
		}
		public void setTurma(String turma) {
			this.turma = turma;
		}
		public String getTurno_2() {
			return turno_2;
		}
		public void setTurno_2(String turno_2) {
			this.turno_2 = turno_2;
		}
		public String getBeneficio() {
			return beneficio;
		}
		public void setBeneficio(String beneficio) {
			this.beneficio = beneficio;
		}
		public String getNis() {
			return nis;
		}
		public void setNis(String nis) {
			this.nis = nis;
		}
		public String getRaca_cor() {
			return raca_cor;
		}
		public void setRaca_cor(String raca_cor) {
			this.raca_cor = raca_cor;
		}
		public String getNis_aluno() {
			return nis_aluno;
		}
		public void setNis_aluno(String nis_aluno) {
			this.nis_aluno = nis_aluno;
		}
		public String getSaude_esf() {
			return saude_esf;
		}
		public void setSaude_esf(String saude_esf) {
			this.saude_esf = saude_esf;
		}
		public String getCras_ref() {
			return cras_ref;
		}
		public void setCras_ref(String cras_ref) {
			this.cras_ref = cras_ref;
		}
		public String getCurso_pretendido() {
			return curso_pretendido;
		}
		public void setCurso_pretendido(String curso_pretendido) {
			this.curso_pretendido = curso_pretendido;
		}
		public String getObs_filiacao() {
			return obs_filiacao;
		}
		public void setObs_filiacao(String obs_filiacao) {
			this.obs_filiacao = obs_filiacao;
		}
		public String getMedicacao() {
			return medicacao;
		}
		public void setMedicacao(String medicacao) {
			this.medicacao = medicacao;
		}
		public String getAlergia() {
			return alergia;
		}
		public void setAlergia(String alergia) {
			this.alergia = alergia;
		}
		public String getComportamento_casa() {
			return comportamento_casa;
		}
		public void setComportamento_casa(String comportamento_casa) {
			this.comportamento_casa = comportamento_casa;
		}
		public String getComportamento_escola() {
			return comportamento_escola;
		}
		public void setComportamento_escola(String comportamento_escola) {
			this.comportamento_escola = comportamento_escola;
		}
		public String getMedia_escolar() {
			return media_escolar;
		}
		public void setMedia_escolar(String media_escolar) {
			this.media_escolar = media_escolar;
		}
		public String getPrioritario() {
			return prioritario;
		}
		public void setPrioritario(String prioritario) {
			this.prioritario = prioritario;
		}
		public String getRg_pai() {
			return rg_pai;
		}
		public void setRg_pai(String rg_pai) {
			this.rg_pai = rg_pai;
		}
		public Date getData_nascimento_pai() {
			return data_nascimento_pai;
		}
		public void setData_nascimento_pai(Date data_nascimento_pai) {
			this.data_nascimento_pai = data_nascimento_pai;
		}
		public String getNatural_pai() {
			return natural_pai;
		}
		public void setNatural_pai(String natural_pai) {
			this.natural_pai = natural_pai;
		}
		public String getUf_pai() {
			return uf_pai;
		}
		public void setUf_pai(String uf_pai) {
			this.uf_pai = uf_pai;
		}
		public String getCpf_pai() {
			return cpf_pai;
		}
		public void setCpf_pai(String cpf_pai) {
			this.cpf_pai = cpf_pai;
		}
		public String getTitulo_pai() {
			return titulo_pai;
		}
		public void setTitulo_pai(String titulo_pai) {
			this.titulo_pai = titulo_pai;
		}
		public String getZona_pai() {
			return zona_pai;
		}
		public void setZona_pai(String zona_pai) {
			this.zona_pai = zona_pai;
		}
		public String getSecao_pai() {
			return secao_pai;
		}
		public void setSecao_pai(String secao_pai) {
			this.secao_pai = secao_pai;
		}
		public String getMunicipio_pai() {
			return municipio_pai;
		}
		public void setMunicipio_pai(String municipio_pai) {
			this.municipio_pai = municipio_pai;
		}
		public String getUf_titulo_pai() {
			return uf_titulo_pai;
		}
		public void setUf_titulo_pai(String uf_titulo_pai) {
			this.uf_titulo_pai = uf_titulo_pai;
		}
		public Date getData_emissao_titulo_pai() {
			return data_emissao_titulo_pai;
		}
		public void setData_emissao_titulo_pai(Date data_emissao_titulo_pai) {
			this.data_emissao_titulo_pai = data_emissao_titulo_pai;
		}
		public String getLocal_trab_pai() {
			return local_trab_pai;
		}
		public void setLocal_trab_pai(String local_trab_pai) {
			this.local_trab_pai = local_trab_pai;
		}
		public String getFone_pai() {
			return fone_pai;
		}
		public void setFone_pai(String fone_pai) {
			this.fone_pai = fone_pai;
		}
		public String getRg_mae() {
			return rg_mae;
		}
		public void setRg_mae(String rg_mae) {
			this.rg_mae = rg_mae;
		}
		public Date getData_nascimento_mae() {
			return data_nascimento_mae;
		}
		public void setData_nascimento_mae(Date data_nascimento_mae) {
			this.data_nascimento_mae = data_nascimento_mae;
		}
		public String getNatural_mae() {
			return natural_mae;
		}
		public void setNatural_mae(String natural_mae) {
			this.natural_mae = natural_mae;
		}
		public String getUf_mae() {
			return uf_mae;
		}
		public void setUf_mae(String uf_mae) {
			this.uf_mae = uf_mae;
		}
		public String getCpf_mae() {
			return cpf_mae;
		}
		public void setCpf_mae(String cpf_mae) {
			this.cpf_mae = cpf_mae;
		}
		public String getTitulo_mae() {
			return titulo_mae;
		}
		public void setTitulo_mae(String titulo_mae) {
			this.titulo_mae = titulo_mae;
		}
		public String getZona_mae() {
			return zona_mae;
		}
		public void setZona_mae(String zona_mae) {
			this.zona_mae = zona_mae;
		}
		public String getSecao_mae() {
			return secao_mae;
		}
		public void setSecao_mae(String secao_mae) {
			this.secao_mae = secao_mae;
		}
		public String getMunicipio_mae() {
			return municipio_mae;
		}
		public void setMunicipio_mae(String municipio_mae) {
			this.municipio_mae = municipio_mae;
		}
		public String getUf_titulo_mae() {
			return uf_titulo_mae;
		}
		public void setUf_titulo_mae(String uf_titulo_mae) {
			this.uf_titulo_mae = uf_titulo_mae;
		}
		public Date getData_emissao_titulo_mae() {
			return data_emissao_titulo_mae;
		}
		public void setData_emissao_titulo_mae(Date data_emissao_titulo_mae) {
			this.data_emissao_titulo_mae = data_emissao_titulo_mae;
		}
		public String getLocal_trab_mae() {
			return local_trab_mae;
		}
		public void setLocal_trab_mae(String local_trab_mae) {
			this.local_trab_mae = local_trab_mae;
		}
		public String getFone_mae() {
			return fone_mae;
		}
		public void setFone_mae(String fone_mae) {
			this.fone_mae = fone_mae;
		}
		public String getCasa_propria() {
			return casa_propria;
		}
		public void setCasa_propria(String casa_propria) {
			this.casa_propria = casa_propria;
		}
		public String getPai_separado() {
			return pai_separado;
		}
		public void setPai_separado(String pai_separado) {
			this.pai_separado = pai_separado;
		}	   
		
			
		
		public Set<Imagem> getListaImagem() {
			return listaImagem;
		}
		public void setListaImagem(Set<Imagem> listaImagem) {
			this.listaImagem = listaImagem;
		}
		@Override
		public String toString() {
		     return "org.semear.model.bean.cadastros.Aluno[id=" + id + "]";
		    }
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Aluno other = (Aluno) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
	    
	    
	    
	    
	

}
