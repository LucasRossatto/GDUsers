package models;

public class Usuario {

	private int intId;
	
	private String strNome;
	private String strSenha;
	
	public Usuario(int intId, String strNome, String strSenha) {
		this.intId = intId;
		this.strNome = strNome;
		this.strSenha = strSenha;
	}

	public int getIntId() {
		return intId;
	}

	public void setIntId(int intId) {
		this.intId = intId;
	}

	public String getStrNome() {
		return strNome;
	}

	public void setStrNome(String strNome) {
		this.strNome = strNome;
	}

	public String getStrSenha() {
		return strSenha;
	}

	public void setStrSenha(String strSenha) {
		this.strSenha = strSenha;
	}
	
	@Override
	public String toString() {
		return intId + ";" + strNome + ";" + strSenha;
	}
	
	
}
