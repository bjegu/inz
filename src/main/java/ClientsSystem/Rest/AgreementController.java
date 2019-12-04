package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.Agreement;
import ClientsSystem.Domain.Repository.AgreementRepositoryI;
import ClientsSystem.Domain.Service.AgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("api/agreement")
public class AgreementController {

    @Autowired
    public AgreementService agreementService;

    @GetMapping("/")
    public List<Agreement> showAll() {
        return agreementService.findAll(PageRequest.of(0, 4)).getContent();
    }

    @PostMapping("/addmodify")
    public Agreement addContract(@RequestBody() Agreement agreement) {
        return agreementService.save(agreement);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContract(@PathVariable() UUID id) {
        agreementService.deleteById(id);
    }
}

