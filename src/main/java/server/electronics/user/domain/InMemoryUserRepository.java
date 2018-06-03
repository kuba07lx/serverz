package server.electronics.user.domain;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

class InMemoryUserRepository implements UserRepository {

    ConcurrentHashMap<Long, User> map = new ConcurrentHashMap<>();

    @Override
    public User save(User user) {

        map.put(user.dto().getId(), user);
        return user;
    }

    @Override
    public List<User> findAll() {
        return map.values().stream()
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return map.values().stream()
                .filter(user -> user.dto().getUsername().equals(username))
                .findAny();
    }

    @Override
    public boolean existsByUsername(String username) {
      return map.values().stream()
              .filter(user -> user.dto().getUsername().equals(username))
              .findAny()
              .isPresent();
    }

    @Override
    public boolean existsByEmail(String email) {
        return map.values().stream()
                .filter(user -> user.dto().getEmail().equals(email))
                .findAny()
                .isPresent();
    }

}
