package server.electronics.user.domain;

import org.springframework.data.repository.Repository;

interface RoleRepository extends Repository<Role, Long> {
    Role save(Role role);
}
