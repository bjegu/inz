package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.Agreement;
import ClientsSystem.Domain.Repository.AgreementRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("api/agreement")
public class AgreementController {

    @Autowired
    public AgreementRepositoryI agreementRepository;

    @GetMapping("/allcontracts")
    public Page<Agreement> showAll() {
        return agreementRepository.findAll(PageRequest.of(0, 2));
    }

    @PostMapping("/addmodify")
    public Agreement addContract(@RequestBody() Agreement agreement) {
        return agreementRepository.save(agreement);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContract(@PathVariable() UUID id) {
        agreementRepository.deleteById(id);
    }
}

