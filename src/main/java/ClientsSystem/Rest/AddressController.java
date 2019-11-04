package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.Address;
import ClientsSystem.Domain.Repository.AddressRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/address")
public class AddressController {

    @Autowired
    public AddressRepositoryI addressRepository;

    @GetMapping("/alladdresses")
    public Page<Address> showAll(){
        return addressRepository.findAll(PageRequest.of(0,2));
    }

    @PostMapping("/add")
    public Address addAddress(@RequestBody() Address address){
        return addressRepository.save(address);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteAddress(@PathVariable() UUID id) {
        addressRepository.deleteById(id);
    }
}
