package hurrybus.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *	Classe que define o modelo de Usuario
 * 
 * @author            Arthur Silveira
 * @author            Dener Kemele
 * 
 */
public class Usuario {

    private String name;
    private String email;
    private String senha;
    private int id = -1;

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
     * @return Retorna a variável nome
     */
    public String getName() {
        return name;
    }

    /**
     * @param name inicializa a variável nome
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return retorna a variável email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email inicializa a variável email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return retorna a variável senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha inicializa a variável senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
	@Override
	public String toString() {
		return "Usuario [name=" + name + ", email=" + email + ", senha=" + senha + ",  id=" + id
				+ "]";
	}

}
