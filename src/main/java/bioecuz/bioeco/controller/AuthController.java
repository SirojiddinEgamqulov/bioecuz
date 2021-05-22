package bioecuz.bioeco.controller;

import bioecuz.bioeco.entity.Role;
import bioecuz.bioeco.entity.User;
import bioecuz.bioeco.payload.ApiResponse;
import bioecuz.bioeco.payload.JwtToken;
import bioecuz.bioeco.payload.ReqLogin;
import bioecuz.bioeco.repository.UserRepository;
import bioecuz.bioeco.security.CurrentUser;
import bioecuz.bioeco.security.JwtTokenProvider;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

import static bioecuz.bioeco.entity.enums.RoleName.ROLE_ADMIN;
import static bioecuz.bioeco.entity.enums.RoleName.ROLE_SUPER_ADMIN;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    final
    AuthenticationManager authenticate;

    final
    JwtTokenProvider jwtTokenProvider;

    final
    UserRepository userRepository;

    final
    PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticate, JwtTokenProvider jwtTokenProvider, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.authenticate = authenticate;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/login")
    private HttpEntity<?> logIn(@RequestBody ReqLogin reqLogIn) {
        try {
            Authentication authentication = authenticate.authenticate(new
                    UsernamePasswordAuthenticationToken(reqLogIn.getUsername().replace(" ", ""), reqLogIn.getPassword().replace(" ", "")));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            User user = (User) authentication.getPrincipal();
            String token = jwtTokenProvider.generateToken(user);
            return ResponseEntity.ok(new JwtToken(token));
        } catch (Exception e) {
            return ResponseEntity.status(401).body(new ApiResponse("username or password  error", false));
        }
    }

    @GetMapping("/me")
    private HttpEntity<?> me(@CurrentUser User user) {
        if (user != null)
            user.setPassword(null);
        return ResponseEntity.status(user != null ? 200 : 409).body(user);
    }
}
