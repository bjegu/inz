package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.AgreementType;
import ClientsSystem.Domain.Service.AgreementTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ClientsSystem.Infrastructure.security.SecurityUtils.HAS_ADMIN_PERMISSION;

@RestController
@RequestMapping("api/agrtype")
@PreAuthorize(HAS_ADMIN_PERMISSION)
public class AgreementTypeController {

    @Autowired
    private AgreementTypeService agreementTypeService;

    @GetMapping ("/showall")
    public List<AgreementType> showAll(){
        return agreementTypeService.findAll(PageRequest.of(0,2)).getContent();
    }

    @PostMapping("addModify")
    public AgreementType addType(@RequestBody() AgreementType agreementType){
        return agreementTypeService.save(agreementType);
    }
}
