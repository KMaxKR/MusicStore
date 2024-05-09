package ks.msx.MusicStore.repository;

import ks.msx.MusicStore.entity.MusicE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<MusicE, Long> {

    MusicE getMusicByName(String name);
}
