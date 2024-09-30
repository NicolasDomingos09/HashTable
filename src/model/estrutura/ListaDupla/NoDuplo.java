package model.estrutura.ListaDupla;
import model.estrutura.ListaSimples.ListaSimples;

public class NoDuplo {
	private char letra;
	ListaSimples listaNomes;
	private NoDuplo proximo;
	private NoDuplo anterior;
	
	public NoDuplo(char letra) {
		this.letra = letra;
		this.anterior = null;
		this.proximo = null;
		this.listaNomes = new ListaSimples();
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public NoDuplo getProximo() {
		return proximo;
	}

	public void setProximo(NoDuplo proximo) {
		this.proximo = proximo;
	}

	public NoDuplo getAnterior() {
		return anterior;
	}

	public void setAnterior(NoDuplo anterior) {
		this.anterior = anterior;
	}
}
