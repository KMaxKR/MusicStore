package ks.msx.MusicStore.endpoint;

import jakarta.servlet.http.HttpServletResponse;
import ks.msx.MusicStore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@AllArgsConstructor
public class Controller {
    private final UserService userService;

    @RequestMapping("/")
    public String mainPage(){
        return "Main page";
    }

    @RequestMapping("/***")
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/");
    }
}
