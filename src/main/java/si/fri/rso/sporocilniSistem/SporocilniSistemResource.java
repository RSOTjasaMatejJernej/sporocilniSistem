
package si.fri.rso.sporocilniSistem;

import com.kumuluz.ee.common.runtime.EeRuntime;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.json.JSONArray;
import org.json.JSONObject;

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

    /*@GET
    @Path("info")
    public Response info() {

        JSONObject json = new JSONObject();

        JSONArray clani = new JSONArray();
        clani.put("tj9557");
        clani.put("jj2744");
        clani.put("mp9119");

        JSONArray mikrostoritve = new JSONArray();
        mikrostoritve.put("http://169.51.24.248:32112/v1/katalogProfilov/");
        mikrostoritve.put("http://169.51.24.248:32620/v1/upravljanjeProfilov/1");
        mikrostoritve.put("http://169.51.24.248:31039/v1/obvestilniSistem/");
        mikrostoritve.put("http://169.51.24.248:30133/v1/sporocilniSistem/");

        JSONArray github = new JSONArray();
        github.put("https://github.com/RSOTjasaMatejJernej/katalogProfilov");
        github.put("https://github.com/RSOTjasaMatejJernej/upravljanjeProfilov");
        github.put("https://github.com/RSOTjasaMatejJernej/obvestilniSistem");
        github.put("https://github.com//RSOTjasaMatejJernej/sporocilniSistem");

        JSONArray dockerhub = new JSONArray();
        dockerhub.put("https://hub.docker.com/r/tjasaj/katalog-profilov");
        dockerhub.put("https://hub.docker.com/r/tjasaj/upravljanje-profilov");
        dockerhub.put("https://hub.docker.com/r/tjasaj/obvestilni-sistem");
        dockerhub.put("https://hub.docker.com/r/tjasaj/sporocilni-sistem");

        JSONArray travis = new JSONArray();
        travis.put("https://travis-ci.org/RSOTjasaMatejJernej/katalogProfilov");
        travis.put("https://travis-ci.org/RSOTjasaMatejJernej/upravljanjeProfilov");
        travis.put("https://travis-ci.org/RSOTjasaMatejJernej/obvestilniSistem");
        travis.put("https://travis-ci.org/RSOTjasaMatejJernej/sporocilniSistem");

        json.put("clani", clani);
        json.put("opis_projekta", "Nas projekt implementira socialno omrezje.");
        json.put("mikrostoritve", mikrostoritve);
        json.put("github", github);
        json.put("travis", travis);
        json.put("dockerhub", dockerhub);

        return Response.ok(json.toString()).build();
    }*/

    @GET
    @Path("{idPosiljateljidPrejemnik}")
    public Response getPogovor(@PathParam("idPosiljateljidPrejemnik") String idPosiljateljidPrejemnik) {
        List<Sporocilo> sporocila = Database.getPogovor(idPosiljateljidPrejemnik);
        return sporocila != null
                ? Response.ok(sporocila).build()
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
