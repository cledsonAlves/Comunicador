package br.comunicador.baseDados;

import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.primefaces.model.map.LatLng;

import br.comunicador.objetos.Rca;

/**
 * 
 * @author Cledson Classe responsavel por toda manipulação do banco
 * 
 */

public class ManipulaBanco extends Banco {
	ResultSet rs = null;
	private PreparedStatement stmt;
	Statement st;
	Connection conexao;

	public ManipulaBanco() {

	}

	// busca dados
	public ArrayList<Rca> getRca() {
		ArrayList<Rca> lista = new ArrayList<Rca>();

		String sql = "Select * from RCA";
		// Gera a conexão ..
		conexao = super.criaConexao();

		try {
			st = conexao.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Rca rca = new Rca();
				rca.setCodigo(rs.getString(1));
				rca.setNome(rs.getString(2));
				rca.setEmail(rs.getString(3));
				rca.setDiretorio(rs.getString(4));
				rca.setTelefone(rs.getString(5));
				lista.add(rca);

			}

			// fechando conexões
			st.close();
			rs.close();
			conexao.close();
			return lista;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public String[]  buscaCordenanda(){
		 Point p = new Point();
		 
		 p.setLocation(2122.2544, 2222);
		 p.getX();
		 LatLng coordenada = new LatLng(-33.10815111110, -45.95970883560045); 
		System.out.println("conectado metodo");
		return new String[]{"-33.10815111110","-45.95970883560045"};
	}

	// Método teste
	public static void main(String[] args) {
		ManipulaBanco mb = new ManipulaBanco();
		mb.criaConexao();
		ArrayList<Rca> lista = mb.getRca();
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getDiretorio());
		}
		{

		}

	}

}
