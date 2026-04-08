package softuni.adoptdontshop.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


@Component
public class InitHashedPassword implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;

    public InitHashedPassword(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println(passwordEncoder.encode("12345"));
    }
}


