package ClientsSystem.Infrastructure.security;

import ClientsSystem.Domain.Model.Client;
import ClientsSystem.Domain.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.util.Objects.isNull;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Value("${admin.username}")
    private String adminUsername;
    @Value("${admin.password}")
    private String adminPassword;

    public static final String ADMIN_PERMISSION = "ADMIN_PERMISSION";

    @Autowired
    private ClientService clientService;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        if (Objects.equals(userName, adminUsername)) {
            return new User(adminUsername, adminPassword, Collections.singletonList(new SimpleGrantedAuthority(ADMIN_PERMISSION)));
        }
        Client applicationUser = clientService.findByEmail(userName).orElseThrow(() -> new UsernameNotFoundException(userName));
        return new User(applicationUser.getEmail(),
                isNull(applicationUser.getPesel()) ?
                        bCryptPasswordEncoder.encode(applicationUser.getRegon().toString()) :
                        bCryptPasswordEncoder.encode(applicationUser.getPesel().toString()),
                Collections.emptyList());
    }
}
