package br.comunicador.logica;

import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;


@ManagedBean
@SessionScoped

public class Ftp {
	String ip = "lojakelma.com.br";
	int porta = 21;
	String usuario = "site1368285974";
	String senha = "kelma@12";
	String diretorio = "/Pedidos/";
	String destino = "C:/Users/Cledson/Desktop/Comunicador/Pedidos/";
	FTPClient ftp;
    private List<String> tabs;

	public Ftp() {
		ftp = new FTPClient();
		tabs = new ArrayList<String>();
		System.out.println("cont");
	}

	// retorna os diretorios

	public ArrayList<String> getDiretorios() {
		ArrayList<String> lista = null;
		ArrayList<String> diretorio = null;
		try {
			ftp.connect(ip, porta);
			if (FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
				ftp.login(usuario, senha);
				ftp.enterLocalPassiveMode();

				if (ftp.isConnected()) {
					System.out.println("conectado servidor ftp..");
					lista = new ArrayList<String>();
					diretorio = new ArrayList<String>();

					ftp.changeWorkingDirectory("/Pedidos");
					// pegando os diretorios do ftp
					FTPFile[] dir = ftp.listFiles();
					
					for (int i = 0; i < dir.length; i++) {
						if(!dir[i].getName().contains(".") && dir[i].isDirectory()){
							System.out.println(dir[i].getName());
						}
						
						String is = "/Pedidos/"+dir[i].getName();
						ftp.changeWorkingDirectory(is);
						
						//  verifica dentro de cada pasta
						FTPFile[] files = ftp.listFiles();
						for (int j = 0; j < files.length; j++) {
						
							
							if(files.length > 0 && files[j].isFile()){
								System.out.println(is);
								System.out.println(files[j].getName());
							}
							
						}
						
						
					
					}
					
				
							

			
				}
			}
			return diretorio;

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return lista;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return lista;
		} finally {
			try {
				ftp.logout();
				ftp.disconnect();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//  retorna os diretórios
    public List<String> getTabs() {  
    	System.out.println("ok");
        return tabs;  
    } 
    


	public static void main(String[] args) {
		Ftp ftp = new Ftp();
		ArrayList<String> lista = ftp.getDiretorios();


	}

}
