package hurrybus.model;

import java.sql.Timestamp;

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
	private Timestamp embarqueHora; 
	private Timestamp desembarqueHora;
	private double embarqueLatitude, embarqueLongitude; 
	private double desembarqueLatitude, desembarqueLongitude;
	private Integer nota; 
	private String tag;

	
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
    public Timestamp getEmbarqueHora() {
        return embarqueHora;
    }

    /**
     * @param embarqueHora inicializa a variavel embarqueHora
     */
    public void setEmbarqueHora(Timestamp embarqueHora) {
        this.embarqueHora = embarqueHora;
    }

    /**
     * @return retorno da variável desembarqueHora
     */
    public Timestamp getDesembarqueHora() {
        return desembarqueHora;
    }

    /**
     * @param desembarqueHora inicializa a variavel hora_desmbarque
     */
    public void setDesembarqueHora(Timestamp hora) {
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
	public double getEmbarqueLatitude() {
		return embarqueLatitude;
	}

    /**
     * @param emb_lat inicializa a variavel emb_lat
     */
	public void setEmbarqueLatitude(double emb_lat) {
		this.embarqueLatitude = emb_lat;
	}

	/**
     * @return retorno da variável emb_lon
     */
	public double getEmbarqueLongitude() {
		return embarqueLongitude;
	}

    /**
     * @param emb_lon inicializa a variavel emb_lon
     */
	public void setEmbarqueLongitude(double emb_lon) {
		this.embarqueLongitude = emb_lon;
	}

	/**
     * @return retorno da variável desembarqueLatitude
     */
	public double getDesembarqueLatitude() {
		return desembarqueLatitude;
	}

    /**
     * @param desembarqueLatitude inicializa a variavel desembarqueLatitude
     */
	public void setDesembarqueLatitude(double desembarqueLatitude) {
		this.desembarqueLatitude = desembarqueLatitude;
	}

	/**
     * @return retorno da variável desembarqueLongitude
     */
	public double getDesembarqueLongitude() {
		return desembarqueLongitude;
	}
	
    /**
     * @param desembarqueLongitude inicializa a variavel desembarqueLongitude
     */
	public void setDesembarqueLongitude(double desembarqueLongitude) {
		this.desembarqueLongitude = desembarqueLongitude;
	}

	/**
     * @return retorno da variável tag
     */
	public String getTag() {
		return tag;
	}

    /**
     * @param tag inicializa a variavel tag
     */
	public void setTag(String tag) {
		this.tag = tag;
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
				+ ", desembarqueLongitude=" + desembarqueLongitude + ", nota=" + nota + ", tag=" + tag + "]";
	}
    
}
