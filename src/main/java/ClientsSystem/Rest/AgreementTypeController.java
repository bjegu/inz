package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.AgreementType;
import ClientsSystem.Domain.Repository.AgreementTypeRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/agrtype")
public class AgreementTypeController {

    @Autowired
    public AgreementTypeRepositoryI agreementTypeRepository;

    @GetMapping ("/showall")
    public Page<AgreementType> showAll(){
        return agreementTypeRepository.findAll(PageRequest.of(0,2));
    }

    @PostMapping("addModify")
    public AgreementType addType(@RequestBody() AgreementType agreementType){
        return agreementTypeRepository.save(agreementType);
    }
}
