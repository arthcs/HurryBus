package hurrybus.model;

/**
 *	Classe que define o modelo de evento
 * 
 * @author            Arthur Silveira
 * @author            Dener Kemele
 * 
 */
public class Evento {
    
	private int Id;
	private Usuario usuario;
	private String embarqueHora; 
	private String desembarqueHora;
	private Integer embarqueLatitude, embarqueLongitude; 
	private Integer desembarqueLatitude, desembarqueLongitude;
	private Integer nota; 
	private String TAG;

	
    /**
     * @return retorno da variável usuario
     */
	public Usuario getUsuario() {
		return usuario;
	}
	
    /**
     * @param usuario inicializa a variavel usuario
     */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
    /**
     * @return retorno da variável embarqueHora
     */
    public String getEmbarqueHora() {
        return embarqueHora;
    }

    /**
     * @param embarqueHora inicializa a variavel embarqueHora
     */
    public void setEmbarqueHora(String embarqueHora) {
        this.embarqueHora = embarqueHora;
    }

    /**
     * @return retorno da variável desembarqueHora
     */
    public String getDesembarqueHora() {
        return desembarqueHora;
    }

    /**
     * @param desembarqueHora inicializa a variavel hora_desmbarque
     */
    public void setDesembarqueHora(String hora) {
        this.desembarqueHora = hora;
    }

    /**
     * @return retorno da variável id
     */
    public int getId() {
		return Id;
	}

    /**
     * @param id inicializa a variavel id
     */
	public void setId(int id) {
		Id = id;
	}

	/**
     * @return retorno da variável emb_lat
     */
	public Integer getEmbarqueLatitude() {
		return embarqueLatitude;
	}

    /**
     * @param emb_lat inicializa a variavel emb_lat
     */
	public void setEmbarqueLatitude(Integer emb_lat) {
		this.embarqueLatitude = emb_lat;
	}

	/**
     * @return retorno da variável emb_lon
     */
	public Integer getEmbarqueLongitude() {
		return embarqueLongitude;
	}

    /**
     * @param emb_lon inicializa a variavel emb_lon
     */
	public void setEmbarqueLongitude(Integer emb_lon) {
		this.embarqueLongitude = emb_lon;
	}

	/**
     * @return retorno da variável desembarqueLatitude
     */
	public Integer getDesembarqueLatitude() {
		return desembarqueLatitude;
	}

    /**
     * @param desembarqueLatitude inicializa a variavel desembarqueLatitude
     */
	public void setDesembarqueLatitude(Integer desembarqueLatitude) {
		this.desembarqueLatitude = desembarqueLatitude;
	}

	/**
     * @return retorno da variável desembarqueLongitude
     */
	public Integer getDesembarqueLongitude() {
		return desembarqueLongitude;
	}
	
    /**
     * @param desembarqueLongitude inicializa a variavel desembarqueLongitude
     */
	public void setDesembarqueLongitude(Integer desembarqueLongitude) {
		this.desembarqueLongitude = desembarqueLongitude;
	}

	/**
     * @return retorno da variável TAG
     */
	public String getTAG() {
		return TAG;
	}

    /**
     * @param TAG inicializa a variavel TAG
     */
	public void setTAG(String tAG) {
		TAG = tAG;
	}

	/**
     * @return retorno da variável nota
     */
    public Integer getNota() {
        return nota;
    }

    /**
     * @param nota inicializa a variavel nota
     */
    public void setNota(Integer nota) {
        this.nota = nota;
    }
    

	@Override
	public String toString() {
		return "Evento [Id=" + Id + ", idUser=" + usuario.getId() + ", embarqueHora=" + embarqueHora + ", desembarqueHora="
				+ desembarqueHora + ", embarqueLatitude=" + embarqueLatitude + ", embarqueLongitude=" + embarqueLongitude + ", desembarqueLatitude=" + desembarqueLatitude
				+ ", desembarqueLongitude=" + desembarqueLongitude + ", nota=" + nota + ", TAG=" + TAG + "]";
	}
    
}
