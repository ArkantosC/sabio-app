

package org.sabio.sabioapp.model;

import java.util.HashMap;
import java.util.Map;

public class Torneo {

    private Integer torneo_id;
    private String nombre_torneo;
    private Pais pais;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getTorneoId() {
        return torneo_id;
    }

    public void setTorneoId(Integer torneoId) {
        this.torneo_id = torneoId;
    }

    public String getNombreTorneo() {
        return nombre_torneo;
    }

    public void setNombreTorneo(String nombreTorneo) {
        this.nombre_torneo = nombreTorneo;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
