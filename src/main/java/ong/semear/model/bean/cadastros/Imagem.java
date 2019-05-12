package ong.semear.model.bean.cadastros;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="IMAGEM")
public class Imagem implements Serializable {
	
	 private static final long serialVersionUID = 1L;
	 
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Basic(optional = false)
	    @Column(name = "ID")
	    private Integer id;
	    @Column(name = "CAMINHO")
	    private String caminho;
	    @ManyToOne(cascade = CascadeType.ALL)
	    private Aluno aluno;
	    
	    
	    
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getCaminho() {
			return caminho;
		}
		public void setCaminho(String caminho) {
			this.caminho = caminho;
		}
		public Aluno getAluno() {
			return aluno;
		}
		public void setAluno(Aluno aluno) {
			this.aluno = aluno;
		}
		
		
		@Override
	    public String toString() {
	        return "org.semear.model.bean.cadastros.Imagem[id=" + id + "]";
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
			Imagem other = (Imagem) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}
	    
	    
	    
	    

}
