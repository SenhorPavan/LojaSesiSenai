package Services;

import Model.Carro;
import com.google.gson.Gson;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import main.ApplicationConfig;

@Path("carro")

public class CarroService {

    @GET
    @Path("buscar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ObterTodosCarros(@PathParam("buscar") int id) {

        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(new Gson().toJson(ApplicationConfig.ListaCarro)).build();

    }

    @POST
    @Path("inserir")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response InserirCarro(JsonObject body) {

        String renavan = body.getString("renavan");
        String modelo = body.getString("modelo");
        String cor = body.getString("cor");
        int ano = body.getInt("ano");
        double preco =  (double) body.getInt("preco");
        boolean vendido = body.getBoolean("vendido");
        Carro c = new Carro(renavan, modelo, cor, ano, preco, vendido);
        ApplicationConfig.ListaCarro.add(c);
        return Response.status(201).entity(new Gson().toJson(c)).build();

    }

    @PUT
    @Path("editar")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response EditarCarro(JsonObject body, @PathParam("editar") int id) {

        for (int i = 0; i < ApplicationConfig.ListaCarro.size(); i++) {
            if (id == ApplicationConfig.ListaCarro.get(i).getId()) {
                String renavan = body.getString("renavan");
                String modelo = body.getString("modelo");
                String cor = body.getString("cor");
                int ano = body.getInt("ano");
                double preco = body.getInt("preco");
                boolean vendido = body.getBoolean("vendido");
                Carro c = new Carro(renavan, modelo, cor, ano, preco, vendido);
                return Response.status(Response.Status.NO_CONTENT).build();
            }
        }

        return Response.status(400).build();
    }
    
    @DELETE
    @Path("deletar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response DeletarCarro(@PathParam("deletar") int id){
    
            for (int i = 0; i < ApplicationConfig.ListaCarro.size(); i++) {
            if (id == ApplicationConfig.ListaCarro.get(i).getId()) {
                ApplicationConfig.ListaCarro.remove(i);
                return Response.status(Response.Status.NO_CONTENT).build();
            }
        }
        return Response.status(400).build();
    
}
    
}
