package br.comunicador.logica;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.primefaces.event.CloseEvent;

@ManagedBean(name = "atualizaBean")
public class Atualiza {

	
	
	public void handleClose(CloseEvent event) {
		String s = event.getComponent().getClientId();
		
		FacesMessage msg = new FacesMessage("Pedido na lista");
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}
	
	public void completeArea(String query) {
		System.out.println("okkkk");
	}

	// move os arquivos para pasta backup
	public void move(String dir, String arquivo) {
		String nomeArquivo = null;
		FTPClient ftp = new FTPClient();
		try {
			ftp.connect("ftp.lojakelma.com.br");

			// verifica se conectou com sucesso!
			if (FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
				ftp.login("site1368285974", "kelma@12");
				
				String is = "/Pedidos/"+dir;
				ftp.changeWorkingDirectory(dir);
				//  move os arquivos para pasta backup no ftp
				boolean b = ftp.rename(dir+"/"+arquivo,  dir+"/Backup/"+arquivo); 
				System.out.println(b);
				
				
			} else {
				// erro ao se conectar
				ftp.disconnect();
				System.out.println("Conexão recusada");
				System.exit(1);
			}
			


			ftp.disconnect();
			System.out.println("Fim. Tchau!");
		} catch (Exception e) {
			System.out.println("Ocorreu um erro: " + e);
			System.exit(1);
		}
	}

}
