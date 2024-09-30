package model.estrutura.ListaSimples;

public class NoSimples {
	private String elemento;
	private NoSimples proximo;
	
	public NoSimples(String elemento) {
		this.elemento = elemento;
		this.proximo = null;
	}

	public String getElemento() {
		return elemento;
	}

	public void setElemento(String elemento) {
		this.elemento = elemento;
	}

	public NoSimples getProximo() {
		return proximo;
	}

	public void setProximo(NoSimples proximo) {
		this.proximo = proximo;
	}
}
