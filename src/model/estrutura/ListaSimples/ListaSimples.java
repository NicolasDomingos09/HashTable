package model.estrutura.ListaSimples;

public class ListaSimples {
	private NoSimples primeiro = null;
	private NoSimples ultimo = null;
		
	public void append(String elemento) {
		NoSimples novo = new NoSimples(elemento);
		
		if(this.primeiro == null) {
			this.primeiro = novo;
			this.ultimo = novo;
		}else {
			NoSimples anterior = this.ultimo;
			anterior.setProximo(novo);
			this.ultimo = novo;
		}
	}

	public NoSimples getNode(int index) throws Exception {
		if(this.primeiro == null)
			throw new Exception("A lista está vazia");
			
		NoSimples buffer = this.primeiro;
		int i = 0;
		
		for(i = 0; i < index; i++) {
			if(buffer.getProximo() == null) {
				break;
			}
			buffer = buffer.getProximo();
		}
		
		if(i < index)
			throw new Exception("Índice não encontrado");
		
		return buffer;
	}
	
	public int index(String nome) throws Exception {
		if(this.primeiro == null) {
			throw new Exception("A lista está vazia");
		}
		
		if(this.primeiro.getElemento().equals(nome)){
			return 0;
		}else {
			NoSimples buffer = this.primeiro;
			int i = 0;
			
			while(buffer.getProximo() != null) {
				++i;
				buffer = buffer.getProximo();
				
				if(buffer.getElemento().equals(nome))
					break;
			}
			
			if(!(buffer.getElemento().equals(nome))) {
				throw new Exception("Elemento não encontrado");
			}
			
			return i;
		}
	}
	
	public void remove(String nome) throws Exception{
		if(this.primeiro == null)
			throw new Exception("A lista está vazia");
		
		if(this.primeiro.getElemento().equals(nome)) {
			NoSimples removido = this.primeiro;
			NoSimples novoPrimeiro = removido.getProximo();
			
			removido.setElemento(null);
			removido.setProximo(null);

			this.primeiro = novoPrimeiro;
		}else {
			int index = this.index(nome);
			NoSimples removido = getNode(index);
			NoSimples anterior = getNode((index-1));
			NoSimples proximo = removido.getProximo();

			anterior.setProximo(proximo);
			
			removido.setElemento(null);
			removido.setProximo(null);
		}
	}
	
	public int getSize() {
		if(this.primeiro == null)
			return 0;
		
		int i = 0;
		NoSimples buffer = this.primeiro;
		while(buffer.getProximo() != null) {
			++i;
			buffer = buffer.getProximo(); 
		}
		
		return i;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		NoSimples buffer = this.primeiro;
		
		builder.append(buffer.getElemento());
		while(buffer.getProximo() != null) {
			builder.append(",");
			buffer = buffer.getProximo();
			builder.append(buffer.getElemento());
		}
		builder.append("]");
		
		return builder.toString();
		
	}
}
