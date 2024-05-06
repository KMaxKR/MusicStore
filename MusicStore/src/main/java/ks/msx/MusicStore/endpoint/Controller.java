package ks.msx.MusicStore.endpoint;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ks.msx.MusicStore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import java.io.IOException;

@org.springframework.stereotype.Controller
@AllArgsConstructor
public class Controller {
    private final UserService userService;
    private final AuthenticationManager manager;

    @RequestMapping("/")
    public String mainPage(){
        return "main";
    }

    @RequestMapping("/login")
    public String redirect() {
        return "login";
    }

    @PostMapping("/authentication")
    public void loginProcess(@RequestParam(name = "username")String username,
                             @RequestParam(name = "password")String password,
                             HttpServletResponse response,
                             HttpServletRequest request) throws IOException, ServletException {
        //Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        //SecurityContextHolder.getContext().setAuthentication(authentication);
        request.login(username, password);
        System.out.println(SecurityContextHolder.getContext().getAuthentication().isAuthenticated());
        System.out.println(SecurityContextHolder.getContext().getAuthentication().getDetails());
        response.setStatus(200);
        response.sendRedirect("/");
    }
}
