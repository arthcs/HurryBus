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
	private String hora_embarque; 
	private String hora_desembarque;
	private Integer emb_lat, emb_lon; 
	private Integer desemb_lat, desemb_lon;
	private Integer nota; 
	private String TAG;

	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
    /**
     * @return retorno da variável hora_embarque
     */
    public String getHora_embarque() {
        return hora_embarque;
    }

    /**
     * @param hora_embarque inicializa a variavel hora_embarque
     */
    public void setHora_embarque(String hora_embarque) {
        this.hora_embarque = hora_embarque;
    }

    /**
     * @return retorno da variável hora_desembarque
     */
    public String getHora_desembarque() {
        return hora_desembarque;
    }

    /**
     * @param hora_desembarque inicializa a variavel hora_desmbarque
     */
    public void setHora_desembarque(String hora) {
        this.hora_desembarque = hora;
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
	public Integer getEmb_lat() {
		return emb_lat;
	}

    /**
     * @param emb_lat inicializa a variavel emb_lat
     */
	public void setEmb_lat(Integer emb_lat) {
		this.emb_lat = emb_lat;
	}

	/**
     * @return retorno da variável emb_lon
     */
	public Integer getEmb_lon() {
		return emb_lon;
	}

    /**
     * @param emb_lon inicializa a variavel emb_lon
     */
	public void setEmb_lon(Integer emb_lon) {
		this.emb_lon = emb_lon;
	}

	/**
     * @return retorno da variável desemb_lat
     */
	public Integer getDesemb_lat() {
		return desemb_lat;
	}

    /**
     * @param desemb_lat inicializa a variavel desemb_lat
     */
	public void setDesemb_lat(Integer desemb_lat) {
		this.desemb_lat = desemb_lat;
	}

	/**
     * @return retorno da variável desemb_lon
     */
	public Integer getDesemb_lon() {
		return desemb_lon;
	}
	
    /**
     * @param desemb_lon inicializa a variavel desemb_lon
     */
	public void setDesemb_lon(Integer desemb_lon) {
		this.desemb_lon = desemb_lon;
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
		return "Evento [Id=" + Id + ", Id_user=" + usuario.getId() + ", hora_embarque=" + hora_embarque + ", hora_desembarque="
				+ hora_desembarque + ", emb_lat=" + emb_lat + ", emb_lon=" + emb_lon + ", desemb_lat=" + desemb_lat
				+ ", desemb_lon=" + desemb_lon + ", nota=" + nota + ", TAG=" + TAG + "]";
	}
    
}
