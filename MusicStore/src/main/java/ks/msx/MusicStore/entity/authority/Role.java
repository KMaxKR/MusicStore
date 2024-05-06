package ks.msx.MusicStore.entity.authority;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
public enum Role {
    USER(Set.of(Permissions.READ, Permissions.WRITE)),
    ROOT(Set.of(Permissions.READ, Permissions.WRITE));

    @Getter
    private final Set<Permissions> getPermissions;

    public List<SimpleGrantedAuthority> authorityList() {
        List<SimpleGrantedAuthority> list = new ArrayList<>(
                getGetPermissions()
                        .stream()
                        .map(permissions -> new SimpleGrantedAuthority(permissions.name()))
                        .toList());
        list.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return list;
    }

}
