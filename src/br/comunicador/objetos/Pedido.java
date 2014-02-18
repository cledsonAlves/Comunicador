package br.comunicador.objetos;

import java.util.List;

public class Pedido {

	private String nome;
	private String rca;
	private String numero;
	private String prazo;
	private String tabela;
	private String dataVenda;
	private String codCli;
	private String nomeCli;
	private String tpVenda;
	private String obs;
	private String tpPagamento;
	private String qtItens;
	private String vlTotal;
	private String diretorio;
	
	
	

	public String getDiretorio() {
		return diretorio;
	}

	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}

	public String getQtItens() {
		return qtItens;
	}

	public void setQtItens(String qtItens) {
		this.qtItens = qtItens;
	}

	public String getVlTotal() {
		return vlTotal;
	}

	public void setVlTotal(String vlTotal) {
		this.vlTotal = vlTotal;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getPrazo() {
		return prazo;
	}

	public void setPrazo(String prazo) {
		this.prazo = prazo;
	}

	public String getTabela() {
		return tabela;
	}

	public void setTabela(String tabela) {
		this.tabela = tabela;
	}

	public String getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(String dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getCodCli() {
		return codCli;
	}

	public void setCodCli(String codCli) {
		this.codCli = codCli;
	}

	public String getNomeCli() {
		return nomeCli;
	}

	public void setNomeCli(String nomeCli) {
		this.nomeCli = nomeCli;
	}

	public String getTpVenda() {
		return tpVenda;
	}

	public void setTpVenda(String tpVenda) {
		this.tpVenda = tpVenda;
	}

	public String getObs() {
		return obs;
	}

	public void setObs(String obs) {
		this.obs = obs;
	}

	public String getTpPagamento() {
		return tpPagamento;
	}

	public void setTpPagamento(String tpPagamento) {
		this.tpPagamento = tpPagamento;
	}

	private List<Item> itens;

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public String getRca() {
		return rca;
	}

	public void setRca(String rca) {
		this.rca = rca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
