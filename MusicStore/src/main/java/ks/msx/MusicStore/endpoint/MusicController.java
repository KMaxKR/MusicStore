package ks.msx.MusicStore.endpoint;

import jakarta.servlet.http.HttpServletResponse;
import ks.msx.MusicStore.entity.MusicDTO;
import ks.msx.MusicStore.service.MusicService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@AllArgsConstructor
@Controller
public class MusicController {
    private final MusicService musicService;

    @RequestMapping("/music/save")
    public void saveMusic(@RequestBody MusicDTO dto,
                          HttpServletResponse response) throws IOException {
        try{
            musicService.saveMusic(dto);
            response.setStatus(200);
            response.sendRedirect("/music/save/success");
        }catch (Exception e){
            response.sendRedirect("/music/save/fail");
        }
    }

    @RequestMapping("/music/save/success")
    public String getSuccessRedirectPage(Model model){
        model.addAttribute("title", "title");
        return "success_redirect_page.html";
    }

    @RequestMapping("/music/save/fail")
    public String getFailedRedirectPage(){
        return "";
    }
}
