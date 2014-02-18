package br.comunicador.logica;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.mail.MessagingException;

import br.comunicador.objetos.Item;
import br.comunicador.objetos.Pedido;

/**
 * Created by IntelliJ IDEA.
 * User: Marcio Ballem
 * Date: 15/02/2011
 * Time: 11:20:06
 * To change this template use File | Settings | File Templates.
 */
public class MailTester implements Runnable {
	private static String cabecalho[] = XML.cabeca;
	 static List<Item> lista;
	 static Pedido pedido;
	String rca;

	
	  public MailTester(String rca, Pedido pedido){
		  this.rca = rca;  
		  this.pedido = pedido;
		  this.lista = pedido.getItens();
		  
		  
		 
		
    }

    private static String textMessage() {
        return  "Leia o novo tutorial JavaMail do Programando com Java.\n" +
                "Saiba como enviar emails com anexo, em formato texto e html.\n" +
                "Envie seu email para mais de um destinatario.";
    }

    private static String htmlMessage() {
    	
    	/**
    	 * cabeca = XML.cabeca;
			txtRca.setText(cabeca[0]);
			txtRazao.setText(cabeca[2]);
			txtNumPed.setText(cabeca[3]);
			txtdataVenda.setText(cabeca[4]);
			txtEndereco.setText(cabeca[1]);
			txtCidade.setText(cabeca[11]);
			txtPrazo.setText(cabeca[6]);
			txtQtdItens.setText(cabeca[7]);
    	 */
    	
    //  obter hora atual do sistema
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");  
    	
    	String s = "<html> \n"+
    	 "\t<head>\n" +
    	 "\t</head> \n" +
    	  "\t<body> \n"+
    	  "\t<li>Nº Pedido :"+ pedido.getNumero()+"</li>"+
    	  "\t<li>Data Venda :"+pedido.getDataVenda()+"</li>"+
    	  "\t<li>RCA:"+pedido.getRca()+"</li>"+
    	  "\t<li>Cliente :"+pedido.getCodCli()+" - "+pedido.getNomeCli()+"</li>"+
    	  "\t<li>Qtd Itens :"+pedido.getQtItens()+"</li>"+
    	  "\t<li>Observação :"+pedido.getObs()+"</li>"+
    	  "\t<li>Hora e data que foi impresso o pedido : "+sdf.format(new Date())+"</li>"+
    	  "\t::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::"+
        "<table>"+
    
          "<tr><td>Codigo</td><td>Descricao</td><td>Qtd</td><td>Vl.Unit</td><td>Vl.Total</td><tr><br>";
    	double total = 0;
    	for(int i=0; i<lista.size();i++){
        s = s + "<tr><td>"+lista.get(i).getCodigo()+ "</td><td>"+lista.get(i).getDescricao()+"</td><td>"+lista.get(i).getQtd()+"</td><td>"+lista.get(i).getVlUnitario()+"</td><td>"+lista.get(i).getVlTotal()+"<td><tr>";		
        total = total + lista.get(i).getVlTotal();
    	}
    	
    	
    	
    	s = s+  "</table>"+
    	"\t::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::<br>"+
    	"::::::::::::::::::::::::::: :::::: :::::  :::::::::::::::::::::::::::::::::</body>"+
    	
    	"</html>";
    	 
        //  imprime o cabeçalho   ....
    	
        
        return   s;
      
      /**  "<html> \n" +
                "\t<head>\n" +
                "\t\t<title>Email no formato HTML com Javamail!</title> \n" +
                "\t</head> \n" +
                "\t<body> \n" +
                "\t\t<div style='background-color:orange; width:28%; height:100px;'>\n" +
                "\t\t\t<ul>  \n" +
                "\t\t\t\t<li>Leia o novo tutorial JavaMail do Programando com Java.</li> \n" +
                "\t\t\t\t<li>Aprenda como enviar emails com anexos.</li>\n" +
                " \t\t\t\t<li>Aprenda como enviar emails em formato texto simples ou html.</li> \n" +
                "\t\t\t\t<li>Aprenda como enviar seu email para mais de um destinatario.</li>\n" +
                "\t\t\t</ul> \n" +
                "\t\t\t<p>Visite o blog \n" +
                "\t\t\t\t<a href='http://mballem.wordpress.com/' target='new'>Programando com Java</a>\n" +
                "\t\t\t</p>\n" +
                "\t\t</div>\t\n" +
                "\t\t<div style='background-color:FFFFF; width:28%; height:50px;' align='center'>\n" +
                "\t\t\tDownload do JavaMail<br/>\n" +
                "\t\t\t<a href='http://www.oracle.com/technetwork/java/javaee/index-138643.html'>\n" +
                "\t\t\t\t<img src='http://www.oracleimg.com/admin/images/ocom/hp/oralogo_small.gif'/>\n" +
                "\t\t\t</a> \n" +
                "\t\t</div>\t\t\n" +
                "\t</body> \n" +
                "</html>";**/
		       
		    /**    "<html> \n"+
		        "\t<head>\n"+
		        "\t\t<title>Espelho Pedidos</title>\n"+
		        "\t<body>\n"+
		        "\t</body>"+
		        "</html>"+
		        "REPRESENTANTE : "
		        +"CÓDIGO DO CLIENTE : "
		        +"CLIENTE : "
		        +"NUMERO PEDIDO : "
		        +"DATA VENDA : "
		        +"PAGAMENTO"
		        +"COND. PAGAMENTO : "
		        +"TABELA  : "
		        +"TIPO PAGAMENTO  : "
		       +"OPERAÇÃO :";**/
		   
    }

	@Override
	public void run() {
		  
        MailJava mj = new MailJava();
        mj.setSmtpHostMail("smtp.kelma.com.br");
        mj.setSmtpPortMail("587");
        mj.setSmtpAuth("true");
        mj.setSmtpStarttls("true");
        mj.setUserMail("kelma029@kelma.com.br");
        mj.setFromNameMail("Sistema Forca de Vendas - Android");
        mj.setPassMail("kelma@2012");
        mj.setCharsetMail("ISO-8859-1");
        mj.setSubjectMail(" ® Espelho Pedidos - E-mail automatico, Não responder. ");
        mj.setBodyMail(htmlMessage());
        mj.setTypeTextMail(MailJava.TYPE_TEXT_HTML);

        Map<String, String> map = new HashMap<String, String>();
        map.put("vendas@kelma.com.br", "Vendas");
        map.put("marketing@kelma.com.br", "Cledson - Marketing");
        map.put(rca, "Representante");
     
        mj.setToMailsUsers(map);
        List<String> files = new ArrayList<String>();
         // files.add("src/Imagens/logo.png");
       // files.add("C:\\images\\hover_next.png");
       // files.add("C:\\images\\hover_prev.png");

        mj.setFileMails(files);

        try {
            new MailJavaSender().senderMail(mj);
            System.out.println("email enviado para " + rca);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("erro ao enviar o email para " + rca + e);
        } catch (MessagingException e) {
        	System.out.println("erro ao enviar o email para " + rca + e);
            e.printStackTrace();  
        }
		
	}
}
