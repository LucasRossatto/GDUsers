package models;

public class Produto {

	private long Produtoid;
	private String strNome;
	private double doublePreco;
	private int intQuantidade;
	

	public Produto(long produtoid, String strNome, double doublePreco, int intQuantidade) {
		this.Produtoid = produtoid;
		this.strNome = strNome;
		this.doublePreco = doublePreco;
		this.intQuantidade = intQuantidade;
	}
	
	public long getProdutoid() {
		return Produtoid;
	}

	public void setProdutoid(long produtoid) {
		Produtoid = produtoid;
	}
	public String getStrNome() {
		return strNome;
	}
	public void setStrNome(String strNome) {
		this.strNome = strNome;
	}
	public double getDoublePreco() {
		return doublePreco;
	}
	public void setDoublePreco(double doublePreco) {
		this.doublePreco = doublePreco;
	}
	public int getIntQuantidade() {
		return intQuantidade;
	}
	public void setIntQuantidade(int intQuantidade) {
		this.intQuantidade = intQuantidade;
	}
	
	public String toString() {
		return Produtoid + ";" + strNome + ";" + doublePreco+ ";" + intQuantidade;
	}
	
	

	
	
}
