
package main;

import Model.Carro;
import java.util.ArrayList;
import java.util.Set;
import javax.ws.rs.core.Application;


@javax.ws.rs.ApplicationPath("v1")
public class ApplicationConfig extends Application {
    
    public static ArrayList<Carro> ListaCarro = new ArrayList<>();
    public static int CONTADOR_ID = 1;
    public static int PORCENTAGEM_LUCRO = 15;

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Services.CarroService.class);
        resources.add(Services.LojaService.class);
        resources.add(main.GenericResource.class);
    }
    
}
