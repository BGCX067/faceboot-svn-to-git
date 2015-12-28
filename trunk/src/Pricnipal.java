import java.util.ArrayList;
import java.util.List;

import br.com.faceboot.dao.FacebookDAO;
import br.com.faceboot.dao.ProdutoDAO;
import br.com.faceboot.model.Facebook;
import br.com.faceboot.model.Produto;
import br.com.faceboot.site.Robo;

public class Pricnipal {

	public static void main(String[] args) {

		Robo robo = new Robo();

		try {
			robo.setUp();
		} catch (Exception e) {
			System.out.println("Erro ao abrir firefox.");
			e.printStackTrace();
		}

		Facebook facebook = new Facebook();
		FacebookDAO facebookDAO = new FacebookDAO();

		boolean logado = false;

		// Criando lista de usuarios ativos do Facebook
		List<Facebook> listaFaces = new ArrayList<Facebook>();
		listaFaces = facebookDAO.getAtivos();

		// Logando no facebook
		
		while (logado == false) {
			int faceId = (int) (Math.random() * listaFaces.size());
			facebook = listaFaces.get(faceId);

			try {

				robo.logar(facebook.getEmail(), facebook.getSenha());
				//System.out.println("OK - Logou: "+ facebook.getEmail());
				logado = true;
				facebook.setErro(0);
				facebookDAO.salvar(facebook);

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Erro ao fazer login: "+ facebook.getEmail());
				facebook.setErro(facebook.getErro() + 1);
				facebookDAO.salvar(facebook);
				logado = false;

			}

		}
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		
		for(Produto produto : produtoDAO.getAtivos()){
			 try {
				 robo.postar(produto.getLink(), produto.getTexto());
				 produto.setErro(0);
				 produtoDAO.salvar(produto);
				 
				 } catch (Exception e) {
					 
				 e.printStackTrace();
				 System.out.println("Erro ao postar - Produto: "+ produto.getDescricao());
				 
				 produto.setErro(produto.getErro()+1);
				 produtoDAO.salvar(produto);
			 }	
		}

		try {
			robo.tearDown();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao fechar o firefox");
		}
	}
}
