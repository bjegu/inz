package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.AgreementType;
import ClientsSystem.Domain.Service.AgreementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/agrtype")
public class AgreementTypeController {

    @Autowired
    public AgreementTypeService agreementTypeService;

    @GetMapping ("/showall")
    public List<AgreementType> showAll(){
        return agreementTypeService.findAll(PageRequest.of(0,100)).getContent();
    }

    @PostMapping("addModify")
    public AgreementType addType(@RequestBody() AgreementType agreementType){
        return agreementTypeService.save(agreementType);
    }
}
