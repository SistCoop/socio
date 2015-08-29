package org.sistcoop.socio.services.resources.admin;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.PathParam;

import org.sistcoop.socio.admin.client.resource.AutorizadoResource;
import org.sistcoop.socio.models.AutorizadoModel;
import org.sistcoop.socio.models.AutorizadoProvider;
import org.sistcoop.socio.models.utils.ModelToRepresentation;
import org.sistcoop.socio.representations.idm.AutorizadoRepresentation;
import org.sistcoop.socio.services.managers.AutorizadoManager;

@Stateless
public class AutorizadoResourceImpl implements AutorizadoResource {

    @PathParam("autorizado")
    private String autorizado;

    @Inject
    private AutorizadoProvider autorizadoProvider;

    @Inject
    private AutorizadoManager autorizadoManager;

    private AutorizadoModel getAutorizadoModel() {
        return autorizadoProvider.findById(autorizado);
    }

    @Override
    public AutorizadoRepresentation autorizado() {
        AutorizadoRepresentation rep = ModelToRepresentation.toRepresentation(getAutorizadoModel());
        if (rep != null) {
            return rep;
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public void update(AutorizadoRepresentation representation) {
        autorizadoManager.update(getAutorizadoModel(), representation);
    }

    @Override
    public void enable() {
        throw new NotFoundException();
    }

    @Override
    public void disable() {
        autorizadoManager.disable(getAutorizadoModel());
    }

    @Override
    public void remove() {
        throw new NotFoundException();
    }

}
