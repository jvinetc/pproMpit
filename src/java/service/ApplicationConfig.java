/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Natalia
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        // following code can be used to customize Jersey 1.x JSON provider:
        try {
            Class jacksonProvider = Class.forName("org.codehaus.jackson.jaxrs.JacksonJsonProvider");
            resources.add(jacksonProvider);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(service.PproAnexoDocumentoFacadeREST.class);
        resources.add(service.PproDocumentoFacadeREST.class);
        resources.add(service.PproEntidadFinancieraFacadeREST.class);
        resources.add(service.PproEstadoDocumentoFacadeREST.class);
        resources.add(service.PproFormaPagoFacadeREST.class);
        resources.add(service.PproMenuFacadeREST.class);
        resources.add(service.PproModuloFacadeREST.class);
        resources.add(service.PproModuloPerfilFacadeREST.class);
        resources.add(service.PproPerfilFacadeREST.class);
        resources.add(service.PproPersonaFacadeREST.class);
        resources.add(service.PproProveedorFacadeREST.class);
        resources.add(service.PproRelEntidadProveedorFacadeREST.class);
        resources.add(service.PproRelPerfilMenuFacadeREST.class);
        resources.add(service.PproRelUsuarioPerfilFacadeREST.class);
        resources.add(service.PproTipoAnexoFacadeREST.class);
        resources.add(service.PproTipoDocumentoFacadeREST.class);
        resources.add(service.PproTipoPersonaFacadeREST.class);
        resources.add(service.PproTipoProveedorFacadeREST.class);
        resources.add(service.PproUsuarioFacadeREST.class);
    }
    
}
