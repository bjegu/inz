package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.Agreement;
import ClientsSystem.Domain.Service.AgreementService;
import ClientsSystem.Infrastructure.security.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

import static ClientsSystem.Infrastructure.security.SecurityUtils.HAS_ADMIN_PERMISSION;


@RestController
@RequestMapping("api/agreement")
public class AgreementController {

    public final Integer AGREEMENT_PAGE_SIZE = 10;

    @Autowired
    private AgreementService agreementService;

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @GetMapping("/")
    @PreAuthorize(HAS_ADMIN_PERMISSION)
    public Page<Agreement> showAll(@RequestParam (required = false, defaultValue = "0") Integer page) {
        return agreementService.findAll(PageRequest.of(page, AGREEMENT_PAGE_SIZE));
    }

    @GetMapping("/client")
    public Page<Agreement> showAClient(@RequestParam (required = false, defaultValue = "0") Integer page) {
        String userEmail = (String) authenticationFacade.getAuthentication().getPrincipal();
        return agreementService.getByClient(userEmail, PageRequest.of(0, 4));
    }

    @PostMapping("/")
    @PreAuthorize(HAS_ADMIN_PERMISSION)
    public Agreement addContract(@RequestBody() Agreement agreement) {
        return agreementService.save(agreement);
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize(HAS_ADMIN_PERMISSION)
    public void deleteContract(@PathVariable() UUID id) {
        agreementService.deleteById(id);
    }
}

