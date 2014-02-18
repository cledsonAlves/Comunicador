package br.comunicador.objetos;

/**
 * 
 * @author c.santos
 *   Objeto Produto   ---  >   ManipulaBanco 
 *
 */

public class Produto {
	private String codigo;
	private String descricao;
	private String dun13;
	private String dun14;
	private String ncm;
	private String estoque1;
	private String estoque2;

	public String getEstoque1() {
		return estoque1;
	}
	public void setEstoque1(String estoque1) {
		this.estoque1 = estoque1;
	}
	public String getEstoque2() {
		return estoque2;
	}
	public void setEstoque2(String estoque2) {
		this.estoque2 = estoque2;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getDun13() {
		return dun13;
	}
	public void setDun13(String dun13) {
		this.dun13 = dun13;
	}
	public String getDun14() {
		return dun14;
	}
	public void setDun14(String dun14) {
		this.dun14 = dun14;
	}
	public String getNcm() {
		return ncm;
	}
	public void setNcm(String ncm) {
		this.ncm = ncm;
	}
	

}
