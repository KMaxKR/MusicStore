package ks.msx.MusicStore.service;

import ks.msx.MusicStore.entity.MusicE;
import ks.msx.MusicStore.repository.MusicRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MusicService {
    private final MusicRepository musicRepository;

    public MusicE getMusicByName(String name){
        return musicRepository.getMusicByName(name);
    }
}
