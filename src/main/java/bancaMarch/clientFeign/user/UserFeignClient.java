package bancaMarch.clientFeign.user;

import bancaMarch.dto.users.UserDTO;
import ch.qos.logback.core.net.server.Client;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "users-service", url = "postgresql://localhost:5432")
public interface UserFeignClient {

    @GetMapping("/client")
    List<UserDTO> getAllClients();

    @GetMapping("/client/dni/{dni}")
    Client getClientByDNI(@PathVariable("dni") String dni);

    @RequestMapping(method = RequestMethod.GET,value = "/client/{id}")
    Client getClientById(@PathVariable("id") Long id);
}
