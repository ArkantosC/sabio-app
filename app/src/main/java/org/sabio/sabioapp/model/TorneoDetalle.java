

package org.sabio.sabioapp.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TorneoDetalle {

    private Integer torneo_detalle_id;
    private Torneo torneo;
    private String fecha_vigencia;
    private String archivo_torneo_detalle;
    private List<Object> equipos = null;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getTorneoDetalleId() {
        return torneo_detalle_id;
    }

    public void setTorneoDetalleId(Integer torneoDetalleId) {
        this.torneo_detalle_id = torneoDetalleId;
    }

    public Torneo getTorneo() {
        return torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    public String getFechaVigencia() {
        return fecha_vigencia;
    }

    public void setFechaVigencia(String fechaVigencia) {
        this.fecha_vigencia = fechaVigencia;
    }

    public String getArchivoTorneoDetalle() {
        return archivo_torneo_detalle;
    }

    public void setArchivoTorneoDetalle(String archivoTorneoDetalle) {
        this.archivo_torneo_detalle = archivoTorneoDetalle;
    }

    public List<Object> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Object> equipos) {
        this.equipos = equipos;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
