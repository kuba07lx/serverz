

        package server.electronics.user.domain;

        import org.springframework.boot.ApplicationRunner;
        import org.springframework.context.annotation.Bean;
        import org.springframework.security.crypto.password.PasswordEncoder;
        import org.springframework.stereotype.Component;

@Component
public class AdminCreator {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleRepository roleRepository;

    public AdminCreator(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Bean
    ApplicationRunner addAdmin(){
        return args -> {

            if (!userRepository.findByUsername("admin").isPresent()){

                User admin = new User(1l, "admin",
                        passwordEncoder.encode("admin"), "admin@wp.pl");

                Role role = Role.builder()
                        .roleId(1)
                        .name("ROLE_ADMIN")
                        .build();

                admin.getUserRoles().add(new UserRole(admin, role));
                userRepository.save(admin);
                roleRepository.save(role);
            }
        };
    }
}
