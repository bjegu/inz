package ClientsSystem.Infrastructure.security;

import static ClientsSystem.Infrastructure.security.UserDetailsServiceImpl.ADMIN_PERMISSION;

public class SecurityUtils {

    public static final String HAS_ADMIN_PERMISSION = "hasAuthority('" + ADMIN_PERMISSION + "')";

}
