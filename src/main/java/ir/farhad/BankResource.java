package ir.farhad;

import org.eclipse.microprofile.config.inject.ConfigProperties;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

@Path(value = "/banks")
public class BankResource {

    @ConfigProperty(name = "bank.name")
    private String name;

    @ConfigProperties(prefix = "bank-support")
    private BankSupportConfig bankSupportConfig;

    @Inject
    private BankSupportConfigMapping bankSupportConfigMapping;


    @GET
    @Path(value = "/name")
    @Produces(value = MediaType.TEXT_PLAIN)
    public String getName(){
        return name;
    }

    @GET
    @Path(value = "/support")
    @Produces(value =MediaType.APPLICATION_JSON)
    public Map<String,String> getSupport(){
        Map<String,String> map=new HashMap<>();
        map.put("email", bankSupportConfig.getEmail());
        map.put("phone", bankSupportConfig.getPhone());
        return map;
    }

    @GET
    @Path(value = "/support-mapping")
    @Produces(value =MediaType.APPLICATION_JSON)
    public Map<String,String> getSupportMapping(){
        Map<String,String> map=new HashMap<>();
        map.put("email", bankSupportConfigMapping.business().email());
        map.put("phone", bankSupportConfigMapping.business().phone());
        return map;
    }



}
