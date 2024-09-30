package model.estrutura.ListaDupla;

public class ListaDupla {
	private NoDuplo primeiro = null;
	private NoDuplo ultimo = null;

	public ListaDupla() {
		this.primeiro = new NoDuplo('A');
		this.ultimo = new NoDuplo('Z');
		this.setAnteriores();
		this.setProximos();
	}
	
	private void setAnteriores() {
		String alfa = "BCDEFGHIJKLMNOPQRSTUVWXY";  
		//Alfabeto sem A nem Z, eles vão ser criados manualmente para que possamos definir os ponteiros
		char[] alfaChar = alfa.toCharArray();
		
		NoDuplo bufferAnterior = this.primeiro;
		
		for(char letra : alfaChar) {
			NoDuplo node = new NoDuplo(letra);
			node.setAnterior(bufferAnterior);
			bufferAnterior = node;
		}
		this.ultimo.setAnterior(bufferAnterior);
	}
	
	private void setProximos() {
		NoDuplo bufferProximo = this.ultimo;
		NoDuplo node = this.ultimo.getAnterior();
		
		while(node != this.primeiro) {
			node.setProximo(bufferProximo);
			bufferProximo = node;
			node = node.getAnterior();
		}
		this.primeiro.setProximo(bufferProximo);
	}
	
	public void adicionaPessoa(String nome) {
		char letraNode = nome.charAt(0);
		NoDuplo buffer = this.primeiro;
		
		while(buffer.getProximo() != null) {
			if(letraNode == buffer.getLetra()) {
				buffer.listaNomes.append(nome);
				break;
			}
			buffer = buffer.getProximo();
		}
		//System.out.println(buffer.listaNomes.toString());
	}
	
	public void localizaPessoa(String nome) throws Exception {
		int indexNode = localizaNode(nome);
		NoDuplo buffer = this.primeiro;
		
		for(int i = 0; i < indexNode; i++) {
			if(buffer.getLetra() == nome.charAt(0)) {
				break;
			}
			buffer = buffer.getProximo();
		}
		
		int indexNome = buffer.listaNomes.index(nome);
		System.out.println(nome + " está no arquivo: " + (indexNode + 1) + " na linha " + (indexNome+1));
	}
	
	private int localizaNode(String nome) {
		char letraNode = nome.charAt(0);
		if(letraNode == this.primeiro.getLetra())
			return 0;
		
		int i = 0;
		NoDuplo buffer = this.primeiro;
		while(buffer.getLetra() != letraNode) {
			++i;
			buffer = buffer.getProximo();
		}
		return i;
	}
	
	public void removerPessoa(String nome) throws Exception {
		char letraNode = nome.charAt(0);
		NoDuplo buffer = this.primeiro;
		
		while(buffer.getProximo() != null) {
			if(buffer.getLetra() == letraNode) {
				buffer.listaNomes.remove(nome);
				System.out.println(buffer.listaNomes.toString());
				break;
			}
		}
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		NoDuplo buffer = this.primeiro;
		
		builder.append(buffer.getLetra());
		while(buffer.getProximo() != null) {
			builder.append(",");
			buffer = buffer.getProximo();
			builder.append(buffer.getLetra());
		}
		builder.append("]");
		
		return builder.toString();
		
	}
}