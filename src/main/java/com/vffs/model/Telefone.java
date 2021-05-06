package com.vffs.model;

public class Telefone{	
	
	private Integer id;	
	private Integer ddd;	
	private String numero;	
	private String tipo;
	private Integer idUsuario;	
	
	public Telefone() {		
	}
		
	public Telefone(Integer id, Integer ddd, String numero, String tipo) {
		this.id = id;
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
	}
	
	public Telefone(Integer ddd, String numero, String tipo) {
		this.ddd = ddd;
		this.numero = numero;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}
	
	public Integer getDdd() {
		return ddd;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public String getTipo() {
		return tipo;
	}
		
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
		
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	@Override
	public String toString() {
		return "Telefone [ddd=" + ddd + ", numero=" + numero + ", tipo=" + tipo + ", idUsuario=" + idUsuario + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ddd == null) ? 0 : ddd.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		Telefone other = (Telefone) obj;
		if (ddd == null) {
			if (other.ddd != null)
				return false;
		} else if (!ddd.equals(other.ddd))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}
	
	
	
	
}
