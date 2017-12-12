
package si.fri.rso.sporocilniSistem;

import com.kumuluz.ee.common.runtime.EeRuntime;
import org.eclipse.microprofile.metrics.annotation.Metered;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;



@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("sporocilniSistem")
@ApplicationScoped
public class SporocilniSistemResource {

    @Inject
    private RestProperties restProperties;

    @GET
    @Metered
    public Response getAllSporocila() {
        List<Sporocilo> sporocila = Database.getSporocila();
        return Response.ok(sporocila).build();
    }

    @GET
    @Path("{idPrejemnik}")
    public Response getSporocilaPrejemnik(@PathParam("idPrejemnik") String idPrejemnik) {
        Sporocilo sporocilo = Database.getSporociloPrejemnik(idPrejemnik);
        return sporocilo != null
                ? Response.ok(sporocilo).build()
                : Response.status(Response.Status.NOT_FOUND).build();
    }

    @POST
    public Response addNewSporocilo(Sporocilo sporocilo) {
        Database.addSporocilo(sporocilo);
        return Response.ok(sporocilo).build();
    }

    @DELETE
    @Path("{idPrejemnik}")
    public Response deleteSporocilo(@PathParam("idPrejemnik") String idPrejemnik) {
        Database.deleteSporocilo(idPrejemnik);
        return Response.ok(Response.Status.OK).build();
    }

    @POST
    @Path("healthy")
    public Response setHealth(Boolean healthy) {
        restProperties.setHealthy(healthy);
        return Response.ok().build();
    }

    @POST
    @Path("load")
    public Response loadOrder(Integer n) {

        for (int i = 1; i <= n; i++) {
            fibonacci(i);
        }

        return Response.status(Response.Status.OK).build();
    }

    private long fibonacci(int n) {
        if (n <= 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }

    @GET
    @Path("instanceid")
    public Response getInstanceId() {

        String instanceId =
                "{\"instanceId\" : \"" + EeRuntime.getInstance().getInstanceId() + "\"}";

        return Response.ok(instanceId).build();
    }
}
