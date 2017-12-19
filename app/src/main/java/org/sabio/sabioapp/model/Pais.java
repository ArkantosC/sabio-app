
package org.sabio.sabioapp.model;

import java.util.HashMap;
import java.util.Map;

public class Pais {

    private Integer paisId;
    private String nombre_pais;
    private String bandera_icono;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getPaisId() {
        return paisId;
    }

    public void setPaisId(Integer paisId) {
        this.paisId = paisId;
    }

    public String getNombrePais() {
        return nombre_pais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombre_pais = nombrePais;
    }

    public String getBanderaIcono() {
        return bandera_icono;
    }

    public void setBanderaIcono(String banderaIcono) {
        this.bandera_icono = banderaIcono;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
