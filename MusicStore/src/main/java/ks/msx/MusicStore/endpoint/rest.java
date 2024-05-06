package ks.msx.MusicStore.endpoint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@AllArgsConstructor
@RestController
public class rest {

    @GetMapping("/info")
    public String info(Principal principal){
        return principal.toString();
    }
}
