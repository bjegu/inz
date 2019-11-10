package ClientsSystem.Domain.Service;

import ClientsSystem.Domain.Model.Address;
import ClientsSystem.Domain.Repository.AddressRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AddressRepositoryI addressRepository;

    @Transactional
    public Page<Address> findAll(PageRequest of) {
        return addressRepository.findAll(of);
    }

    @Transactional
    public Address save(Address address) {
        return addressRepository.save(address);
    }

    @Transactional
    public void deleteById(UUID id) {
        addressRepository.deleteById(id);
    }
}
