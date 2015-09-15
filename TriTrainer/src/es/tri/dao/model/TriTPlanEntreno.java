package es.tri.dao.model;

public class TriTPlanEntreno {
    private Integer id_plan;

    private Integer id_tipo_entreno;

    private Integer fuerza;

    private Integer velocidad;

    private Integer tecnica;

    private Integer ritmo;

    private Integer id_disciplina;

    public Integer getId_plan() {
        return id_plan;
    }

    public void setId_plan(Integer id_plan) {
        this.id_plan = id_plan;
    }

    public Integer getId_tipo_entreno() {
        return id_tipo_entreno;
    }

    public void setId_tipo_entreno(Integer id_tipo_entreno) {
        this.id_tipo_entreno = id_tipo_entreno;
    }

    public Integer getFuerza() {
        return fuerza;
    }

    public void setFuerza(Integer fuerza) {
        this.fuerza = fuerza;
    }

    public Integer getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(Integer velocidad) {
        this.velocidad = velocidad;
    }

    public Integer getTecnica() {
        return tecnica;
    }

    public void setTecnica(Integer tecnica) {
        this.tecnica = tecnica;
    }

    public Integer getRitmo() {
        return ritmo;
    }

    public void setRitmo(Integer ritmo) {
        this.ritmo = ritmo;
    }

    public Integer getId_disciplina() {
        return id_disciplina;
    }

    public void setId_disciplina(Integer id_disciplina) {
        this.id_disciplina = id_disciplina;
    }
}