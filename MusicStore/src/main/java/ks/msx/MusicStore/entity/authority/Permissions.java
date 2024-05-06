package ks.msx.MusicStore.entity.authority;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Permissions {
    READ("READ"),
    WRITE("WRITE");

    @Getter
    private final String getPermissions;
}
