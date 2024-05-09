package ks.msx.MusicStore.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MusicDTO {
    private String name;
    private String author;
    private File file;
}
