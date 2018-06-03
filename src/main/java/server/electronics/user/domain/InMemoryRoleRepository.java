package server.electronics.user.domain;

import java.util.concurrent.ConcurrentHashMap;

class InMemoryRoleRepository implements RoleRepository {

    ConcurrentHashMap<Integer, Role> map = new ConcurrentHashMap<>();

    @Override
    public Role save(Role role) {
        return map.put(role.getRoleId(), role);
    }
}
