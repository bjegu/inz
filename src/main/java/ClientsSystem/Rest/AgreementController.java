package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.Agreement;
import ClientsSystem.Domain.Repository.AgreementRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/agreement")
public class AgreementController {

    @Autowired
    public AgreementRepositoryI agreementRepository;

    @GetMapping("/allcontracts")
    public Page<Agreement> showAll(){
        return agreementRepository.findAll(PageRequest.of(0,2));
    }

    @PostMapping("/addcontract")
    public Agreement addContract(@RequestBody() Agreement agreement){
        return agreementRepository.save(agreement);
    }

}
