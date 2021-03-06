package ClientsSystem.Rest;

import ClientsSystem.Domain.Model.Agreement;
import ClientsSystem.Domain.Service.AgreementService;
import ClientsSystem.Infrastructure.security.IAuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    private PageRequest preparePageRequest(Integer page, String order, String sort) {
        if (page == -1) {
            return PageRequest.of(0, 9999, Sort.by(Sort.Direction.fromString(order), sort));
        }
        return PageRequest.of(page, AGREEMENT_PAGE_SIZE, Sort.by(Sort.Direction.fromString(order), sort));
    }

    @GetMapping("/")
    @PreAuthorize(HAS_ADMIN_PERMISSION)
    public Page<Agreement> showAll(@RequestParam (required = false, defaultValue = "0") Integer page,
                                   @RequestParam(required = false, defaultValue = "agreementNo") String sort,
                                   @RequestParam(required = false, defaultValue = "ASC") String order,
                                   @RequestParam(required = false) String search) {
        return agreementService.findAll(preparePageRequest(page, order,sort), search);
    }

    @GetMapping("/client")
    public Page<Agreement> client(@RequestParam (required = false, defaultValue = "0") Integer page) {
        String userEmail = (String) authenticationFacade.getAuthentication().getPrincipal();
        return agreementService.getByClient(userEmail, PageRequest.of(page, AGREEMENT_PAGE_SIZE));
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

