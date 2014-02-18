package br.comunicador.logica;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.SocketException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;
import org.primefaces.event.CloseEvent;
import org.primefaces.event.SelectEvent;

import br.comunicador.objetos.Item;
import br.comunicador.objetos.Pedido;
import br.comunicador.objetos.Produto;


@ManagedBean
@SessionScoped
public class tabBean implements Runnable{  
	private Produto produto;  
	String ip = "lojakelma.com.br";
	int porta = 21;
	String usuario = "site1368285974";
	String senha = "kelma@12";
	String diretorio = "/Pedidos/";
	String destino = "C:/Users/Cledson/Desktop/Comunicador/Pedidos/";
	FTPClient ftp;
	String email = "" ;
	 String hora;
	
	public  String[] cabecaPedido;
	
	
    private List<String> tabs;
    private List<Item> itens;
    private ArrayList<Produto> lista;
    private List<Pedido> pedidos = new ArrayList<Pedido>();
    private Pedido  selectedCar ;
    XML xml;
  
    public tabBean() {  
    	ftp = new FTPClient();
        tabs = new ArrayList<String>();
        getDiretorios() ;
        lista  = new ArrayList<Produto>();

        itens = new ArrayList<Item>();

    }  
  
    public List<String> getTabs() {  
        return tabs;  
    }  
    
    public List<Item> getItens() {
   
        return itens;  
    } 
    
    
    //  retorna o cabeçalho do pedido
    public String[] getCabeca() {
       return cabecaPedido;  
   } 
    
    public List<Produto> getLista() {  
        return lista;  
    } 
    
    public List<Pedido> getPedidos() {  
        return pedidos;  
    }
    
    public Pedido getSelectedCar() {  
        return selectedCar;  
    } 
    
    public String delete() {  
        pedidos.remove(selectedCar); 
      
        Atualiza a = new Atualiza();
        a.move(selectedCar.getDiretorio(), selectedCar.getNome());
        
		//  Lembrar de modoficar este codigo ( Pode ser com case )
		if (selectedCar.getDiretorio().contains("Eduardo")){
		  email = "esasimoes03@terra.com.br"; 
		}else if (selectedCar.getRca().contains("Alan")){
			 email = "alansadao@hotmail.com";
		}else if (selectedCar.getRca().contains("Miqueias")){
			 email = "miqueiaskelma@gmail.com";
		}else if (selectedCar.getRca().contains("Marcos")){
			 email = "marcosac22@gmail.com";
		}else if (selectedCar.getRca().contains("Carlos")){ 
			 email = "carloskelma@gmail.com";
		}else if (selectedCar.getRca().contains("CarlosSilva")){ 
			 email = " cal_psilva@hotmail.com";
		}else if (selectedCar.getRca().contains("Laelia")){
			 email = "laeliafrazao@gmail.com";
		}else if (selectedCar.getRca().contains("")){
			email = "marketing@kelma.com.br";
		}
		else if (selectedCar.getRca().contains("Cledson")){
			email = "marketing@kelma.com.br";
		}
		else if (selectedCar.getRca().contains("Neide")){
			email = "neide985@hotmail.com"; 
		}
		if (!email.equals("")){

		 Thread t = new Thread(new MailTester(email,selectedCar));
		 System.out.println("t criada");
		 t.start();		
		}	
		selectedCar.getRca();

        System.out.println(email);
     return "a";
    }
    
    public void setSelectedCar(Pedido selectedCar) {  
        this.selectedCar = selectedCar;  
    }
    
    public void removeItem(Pedido item) {
        lista.remove(item);
        System.out.println("a");
     }
    
    public void handleClose(CloseEvent event) {  
          System.out.println("okkkk");
       
    }  
    
    public String getHora(){
    	return hora;
    }
    
    
    public void getDiretorios() {
		ArrayList<String> lista = null;
		ArrayList<String> diretorio = null;
		int y = 0;
		try {
			ftp.connect(ip, porta);
			if (FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
				ftp.login(usuario, senha);
				ftp.enterLocalPassiveMode();

				if (ftp.isConnected()) { 
				    hora = new SimpleDateFormat("HH:mm").format(new Date());  
					System.out.println(hora + " hs  conectado servidor ftp..");
					lista = new ArrayList<String>();
					diretorio = new ArrayList<String>();

					ftp.changeWorkingDirectory("/Pedidos");
					// pegando os diretorios do ftp
					FTPFile[] dir = ftp.listFiles();
					
					
					
					//  formatando celulas
						DecimalFormat df = new DecimalFormat("0.00");
					
					for (int i = 0; i < dir.length; i++) {
						
						String is = "/Pedidos/"+dir[i].getName();
						ftp.changeWorkingDirectory(is);
					
						//  verifica dentro de cada pasta
						FTPFile[] files = ftp.listFiles();
						
						
						for (int j = 0; j < files.length; j++) {
						
							
							if(files.length > 0 && files[j].isFile()){
								Pedido pedido = new Pedido();
								pedido.setNome(files[j].getName());
								pedido.setRca(dir[i].getName());
								pedido.setDiretorio(is);
								
							
								// Copia os arquivos para a maquina local 
								String destino = "K:/Vendas/Pedidos/"
									+pedido.getRca()+"/" +files[j].getName() ;
								
									OutputStream os = new FileOutputStream(destino);
									ftp.retrieveFile(files[j].getName(), os);
									
									//  move os arquivos para pasta backup no ftp
									//boolean b = ftp.rename(files[j].getName(),  is+"/Backup/"+files[j].getName()); 
									
									//System.out.println( b);
									os.close();
									leitura(destino);
									
									
									pedido.setItens(itens);
									pedido.setRca(dir[i].getName());
									pedido.setCodCli(XML.cabeca[1]);
									pedido.setNomeCli(XML.cabeca[2]);
									pedido.setNumero(XML.cabeca[3]);
									pedido.setDataVenda(XML.cabeca[4]);
									pedido.setPrazo(XML.cabeca[5]);
									pedido.setTabela(XML.cabeca[6]);
									pedido.setQtItens(XML.cabeca[7]);
									
									
									String vlTotal = df.format(Double.parseDouble(XML.cabeca[8]));
					
									pedido.setVlTotal(vlTotal);
									pedido.setTpPagamento(XML.cabeca[9]);
									pedido.setTpVenda(XML.cabeca[10]);
									pedido.setObs(XML.cabeca[11]);
								pedidos.add(pedido);
								//System.out.println(files[j].getName());
							}
							
						}
						
						
						if (!dir[i].getName().contains(".") && dir[i].isDirectory()) {
							tabs.add(dir[i].getName());

						}
					}

				}
			}
		

		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
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
    
    public void onRowSelect(SelectEvent event) {  
        FacesMessage msg = new FacesMessage("Car Selected", ((Pedido) event.getObject()).getNome());  

        FacesContext.getCurrentInstance().addMessage(null, msg);  
    } 
    
    //  mensagens ...
    public void addInfo(ActionEvent actionEvent) {  
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"", "Viviane Paciência, em desenvolvimento :)"));  
    } 
    
    
    public void leitura(String path){
    	//String path = "C:/Users/Cledson/Desktop/teste.xml";
    	Vector<Item> lista = new Vector<Item>();
	xml = new XML();
		

		itens = xml.leitura(path);
		this.cabecaPedido = xml.cabeca;
		double vlTotal = 0;
	
		
		for (int i = 0; i < itens.size(); i++) {
			vlTotal = vlTotal + itens.get(i).getVlTotal();
		}
		
		
		// Limitar a duas casas decimais
		DecimalFormat df = new DecimalFormat("0.00");

		// item final....
		Item it = new Item();
		it.setCodigo(0000);
		it.setDescricao("Valor Total do Pedido : " + df.format(vlTotal));
		it.setQtd(000);
		itens.add(it);
		System.out.println("read");
		
    }

	@Override
	public void run() {
		
		new MailTester(email,selectedCar);	
		System.out.println("executei");
	}
    
    
}  