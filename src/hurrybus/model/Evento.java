package hurrybus.model;

/**
 *
 * @author Dener
 * @update Arthur Silveira
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
     * @return the hora_embarque
     */
    public String getHora_embarque() {
        return hora_embarque;
    }

    /**
     * @param hora_embarque the hora_embarque to set
     */
    public void setHora_embarque(String hora_embarque) {
        this.hora_embarque = hora_embarque;
    }

    /**
     * @return the hora_desembarque
     */
    public String getHora_desembarque() {
        return hora_desembarque;
    }

    /**
     * @param hora the hora_desembarque to set
     */
    public void setHora_desembarque(String hora) {
        this.hora_desembarque = hora;
    }

    public int getId() {
		return Id;
	}

	@Override
	public String toString() {
		return "Evento [Id=" + Id + ", Id_user=" + usuario.getId() + ", hora_embarque=" + hora_embarque + ", hora_desembarque="
				+ hora_desembarque + ", emb_lat=" + emb_lat + ", emb_lon=" + emb_lon + ", desemb_lat=" + desemb_lat
				+ ", desemb_lon=" + desemb_lon + ", nota=" + nota + ", TAG=" + TAG + "]";
	}

	public void setId(int id) {
		Id = id;
	}

	public Integer getEmb_lat() {
		return emb_lat;
	}

	public void setEmb_lat(Integer emb_lat) {
		this.emb_lat = emb_lat;
	}

	public Integer getEmb_lon() {
		return emb_lon;
	}

	public void setEmb_lon(Integer emb_lon) {
		this.emb_lon = emb_lon;
	}

	public Integer getDesemb_lat() {
		return desemb_lat;
	}

	public void setDesemb_lat(Integer desemb_lat) {
		this.desemb_lat = desemb_lat;
	}

	public Integer getDesemb_lon() {
		return desemb_lon;
	}

	public void setDesemb_lon(Integer desemb_lon) {
		this.desemb_lon = desemb_lon;
	}

	public String getTAG() {
		return TAG;
	}

	public void setTAG(String tAG) {
		TAG = tAG;
	}

	/**
     * @return the nota
     */
    public Integer getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(Integer nota) {
        this.nota = nota;
    }
    
}
