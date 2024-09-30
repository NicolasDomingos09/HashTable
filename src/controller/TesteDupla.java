package controller;
import model.estrutura.ListaDupla.ListaDupla;
public class TesteDupla {
	
	public static void main(String[] args) {
		ListaDupla lista = new ListaDupla();
		lista.adicionaPessoa("Adelaide");
		lista.adicionaPessoa("Adalberto");
		lista.adicionaPessoa("Arnaldo");
		lista.adicionaPessoa("Brunilda");
		lista.adicionaPessoa("Dede");
		lista.adicionaPessoa("Armaro");
		
		try {
			lista.localizaPessoa("Dede");
			lista.removerPessoa("Adalberto");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//System.out.println(lista.toString());
	}
}
