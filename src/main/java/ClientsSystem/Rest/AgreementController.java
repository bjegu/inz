package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.Agreement;
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

    public final Integer AGREEMENT_PAGE_SIZE = 10;

    @Autowired
    public AgreementService agreementService;

    @GetMapping("/")
    public Page<Agreement> showAll(@RequestParam (required = false, defaultValue = "0") Integer page) {
        return agreementService.findAll(PageRequest.of(page, AGREEMENT_PAGE_SIZE));
    }

    @PostMapping("/")
    public Agreement addContract(@RequestBody() Agreement agreement) {
        return agreementService.save(agreement);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteContract(@PathVariable() UUID id) {
        agreementService.deleteById(id);
    }
}

