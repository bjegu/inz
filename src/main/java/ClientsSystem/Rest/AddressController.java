package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.Address;
import ClientsSystem.Domain.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static ClientsSystem.Infrastructure.security.SecurityUtils.HAS_ADMIN_PERMISSION;

@RestController
@RequestMapping("api/address")
@PreAuthorize(HAS_ADMIN_PERMISSION)
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/alladdresses")
    public Page<Address> showAll(){
        return addressService.findAll(PageRequest.of(0,10));
    }

    @PostMapping("/addmodify")
    public Address addAddress(@RequestBody() Address address){
        return addressService.save(address);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable() UUID id) {
        addressService.deleteById(id);
    }
}
