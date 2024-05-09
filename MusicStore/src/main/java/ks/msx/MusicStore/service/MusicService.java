package ks.msx.MusicStore.service;

import ks.msx.MusicStore.entity.MusicDTO;
import ks.msx.MusicStore.entity.MusicE;
import ks.msx.MusicStore.repository.MusicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class MusicService {
    private final MusicRepository musicRepository;

    public MusicE getMusicByName(String name){
        return musicRepository.getMusicByName(name);
    }

    public List<MusicE> returnMusicBySearch(String searchName){
        String name = searchNameF(searchName);
        return musicRepository.getMusicBySearchName(name);
    }

    public void saveMusic(MusicDTO dto, File file){
        // file -> byte[]
        try{
            FileInputStream inputStream = new FileInputStream(file);
        }catch (FileNotFoundException e){
            e.getStackTrace();
        }
        String searchName = searchNameF(dto.getName());
        musicRepository.save(
                MusicE.builder()
                        .name(dto.getName())
                        .author(dto.getAuthor())
                        .date(new Date())
                        .file(null)
                        .searchName(searchName)
                        .build()
        );
    }

    private String searchNameF(String searchName){
        String n = searchName.toLowerCase();
        char[] search = n.toCharArray();
        List<Character> list = new ArrayList<>();
        for (char c : search) {
            String m = String.valueOf(c);
            if (!m.equals(" ") || !m.isBlank()) {
                list.add(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (char c : list){
            builder.append(c);
        }
        return builder.toString();
    }
}
