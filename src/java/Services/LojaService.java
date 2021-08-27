package Services;

import Model.Carro;
import com.google.gson.Gson;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import main.ApplicationConfig;

@Path("loja")

public class LojaService {

    @GET
    @Path("lucro-total")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ObterLucroTotal(@PathParam("lucro-total") int id) {
        double ValorTotal = 0;
        for (Carro carro : ApplicationConfig.ListaCarro) {
            if (carro.isVendido()) {
                ValorTotal += carro.getPreco();
            }
        }

//        for (int i = 0; i < ApplicationConfig.ListaCarro.size(); i++) {
//            if (ApplicationConfig.ListaCarro.get(i).isVendido() == true) {
//                ValorTotal += ApplicationConfig.ListaCarro.get(i).getPreco();
//            }
//
//        }
        double lucro = ValorTotal * (ApplicationConfig.PORCENTAGEM_LUCRO / 100.0);
        return Response.status(201).entity(new Gson().toJson(lucro)).build();
    }

    @GET
    @Path("carros-disponiveis")
    @Produces(MediaType.APPLICATION_JSON)
    public Response MostrarCarrosDisponiveis(@PathParam("carros-disponiveis") int id) {
        ArrayList<Carro> listaCarrosDisponiveis = new ArrayList<>();
        for (Carro carro : ApplicationConfig.ListaCarro) {
            if (!carro.isVendido()) {
                listaCarrosDisponiveis.add(carro);
            }
        }

        return Response.status(200).entity(new Gson().toJson(listaCarrosDisponiveis)).build();
    }

}
