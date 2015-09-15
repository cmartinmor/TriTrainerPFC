package es.tri.dao.model;

import java.util.Date;

public class TriTTest {
    private Integer idTest;

    private Integer idEntreno;

    private Integer tiempo;

    private Integer FCinicial;

    private Integer FCMax;

    private Integer FCMedia;

    private Date fecha_baja;

    private Integer id_tipo_test;

    private Integer id_entreno_ejercicio;

    public Integer getIdTest() {
        return idTest;
    }

    public void setIdTest(Integer idTest) {
        this.idTest = idTest;
    }

    public Integer getIdEntreno() {
        return idEntreno;
    }

    public void setIdEntreno(Integer idEntreno) {
        this.idEntreno = idEntreno;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public Integer getFCinicial() {
        return FCinicial;
    }

    public void setFCinicial(Integer FCinicial) {
        this.FCinicial = FCinicial;
    }

    public Integer getFCMax() {
        return FCMax;
    }

    public void setFCMax(Integer FCMax) {
        this.FCMax = FCMax;
    }

    public Integer getFCMedia() {
        return FCMedia;
    }

    public void setFCMedia(Integer FCMedia) {
        this.FCMedia = FCMedia;
    }

    public Date getFecha_baja() {
        return fecha_baja;
    }

    public void setFecha_baja(Date fecha_baja) {
        this.fecha_baja = fecha_baja;
    }

    public Integer getId_tipo_test() {
        return id_tipo_test;
    }

    public void setId_tipo_test(Integer id_tipo_test) {
        this.id_tipo_test = id_tipo_test;
    }

    public Integer getId_entreno_ejercicio() {
        return id_entreno_ejercicio;
    }

    public void setId_entreno_ejercicio(Integer id_entreno_ejercicio) {
        this.id_entreno_ejercicio = id_entreno_ejercicio;
    }
}