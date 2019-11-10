package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.Address;
import ClientsSystem.Domain.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/address")
public class AddressController {

    @Autowired
    public AddressService addressService;

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
