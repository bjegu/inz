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

    @Autowired
    public AgreementService agreementService;

    @GetMapping("/")
    public Page<Agreement> showAll(@RequestParam (required = false, defaultValue = "1") Integer page) {
        return agreementService.findAll(PageRequest.of(page, 3));
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

