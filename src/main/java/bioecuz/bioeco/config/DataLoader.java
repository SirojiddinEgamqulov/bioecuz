package bioecuz.bioeco.config;

import bioecuz.bioeco.entity.Home;
import bioecuz.bioeco.entity.Role;
import bioecuz.bioeco.entity.User;
import bioecuz.bioeco.entity.enums.RoleName;
import bioecuz.bioeco.repository.HomeRepository;
import bioecuz.bioeco.repository.RoleRepository;
import bioecuz.bioeco.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DataLoader implements CommandLineRunner {
    final
    UserRepository userRepository;
    final
    RoleRepository roleRepository;
    final
    PasswordEncoder passwordEncoder;
    final
    HomeRepository homeRepository;

    @Value("${spring.datasource.initialization-mode}")
    private String initMode;

    @Autowired
    public DataLoader(UserRepository userRepository, RoleRepository roleRepository,
                      @Lazy PasswordEncoder passwordEncoder, HomeRepository homeRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.homeRepository = homeRepository;
    }

    @Override
    public void run(String... args) {
        if (initMode.equals("always")) {
            Stream<Role> roleStream = Arrays.stream(RoleName.values()).map(roleName -> roleRepository.save(new Role(null, roleName)));
            userRepository.save(
                    new User(
                            "Sirojiddin",
                            "Egamqulov",
                            "MrSirojiddin@outlook.com",
                            "+998998520211",
                            passwordEncoder.encode("root123"),
                            roleStream.collect(Collectors.toSet()),
                            true)
            );
            userRepository.save(
                    new User(
                            "Admin",
                            "Admin",
                            "admin@gmail.com",
                            "+998998520211",
                            passwordEncoder.encode("root123"),
                            roleRepository.findAllByRoleName(RoleName.ROLE_ADMIN),
                            true)
            );
            homeRepository.save(new Home());
        }
    }

    @Bean
    PasswordEncoder getEncoder() {
        return new BCryptPasswordEncoder();
    }
}
