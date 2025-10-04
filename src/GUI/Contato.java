package GUI;

public class Contato {

	//variáveis de instância
	private String nome;
	private String telefone;
	private String endereco;
	private String email;
	private String cpf;
	
	public Contato() {
		
	}

	

	public Contato(String nome, String telefone, String endereco, String email, String cpf) {
		this.nome = nome;
		this.telefone = telefone;
		this.endereco = endereco;
		this.email = email;
		this.cpf = cpf;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	@Override
	public String toString() {
		return "Contato [nome=" + nome + ", telefone=" + telefone + ", endereco=" + endereco + ", email=" + email + "]";
	}
	
	
}
