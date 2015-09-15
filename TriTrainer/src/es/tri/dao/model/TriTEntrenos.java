package es.tri.dao.model;

import java.util.Date;

public class TriTEntrenos {
    private Integer id_entreno_ejercicio;

    private Integer id_entreno;

    private Integer id_ejercicio;

    private Date fecha_baja;

    private Integer valoracion;

    private Integer pulsaciones;

    private Integer conseguido;

    private Integer tiempo;

    private Integer intensidad;

    private Integer distancia;

    private Integer series;

    private Integer repeticiones;

    private Integer descanso;

    private Date fecha;

    private Integer diaSemana;

    private Integer semana;

    private Integer sensacion;

    private Integer peso;

    private Integer pulsacionesMedias;

    public Integer getId_entreno_ejercicio() {
        return id_entreno_ejercicio;
    }

    public void setId_entreno_ejercicio(Integer id_entreno_ejercicio) {
        this.id_entreno_ejercicio = id_entreno_ejercicio;
    }

    public Integer getId_entreno() {
        return id_entreno;
    }

    public void setId_entreno(Integer id_entreno) {
        this.id_entreno = id_entreno;
    }

    public Integer getId_ejercicio() {
        return id_ejercicio;
    }

    public void setId_ejercicio(Integer id_ejercicio) {
        this.id_ejercicio = id_ejercicio;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public Integer getPulsaciones() {
        return pulsaciones;
    }

    public void setPulsaciones(Integer pulsaciones) {
        this.pulsaciones = pulsaciones;
    }

    public Integer getConseguido() {
        return conseguido;
    }

    public void setConseguido(Integer conseguido) {
        this.conseguido = conseguido;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public Integer getIntensidad() {
        return intensidad;
    }

    public void setIntensidad(Integer intensidad) {
        this.intensidad = intensidad;
    }

    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    public Integer getSeries() {
        return series;
    }

    public void setSeries(Integer series) {
        this.series = series;
    }

    public Integer getRepeticiones() {
        return repeticiones;
    }

    public void setRepeticiones(Integer repeticiones) {
        this.repeticiones = repeticiones;
    }

    public Integer getDescanso() {
        return descanso;
    }

    public void setDescanso(Integer descanso) {
        this.descanso = descanso;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(Integer diaSemana) {
        this.diaSemana = diaSemana;
    }

    public Integer getSemana() {
        return semana;
    }

    public void setSemana(Integer semana) {
        this.semana = semana;
    }

    public Integer getSensacion() {
        return sensacion;
    }

    public void setSensacion(Integer sensacion) {
        this.sensacion = sensacion;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getPulsacionesMedias() {
        return pulsacionesMedias;
    }

    public void setPulsacionesMedias(Integer pulsacionesMedias) {
        this.pulsacionesMedias = pulsacionesMedias;
    }
}