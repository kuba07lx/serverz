package server.electronics.product.domain;

import server.electronics.product.dto.ProductDto;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;

class InMemoryProductRepository implements ProductRepository{

    ConcurrentHashMap<Long, Product> map = new ConcurrentHashMap<>();

    @Override
    public Product save(Product product) {
        map.put(product.dto().getId(), product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return map.values().stream()
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        requireNonNull(id);
        map.remove(id);
    }

    @Override
    public Optional<Product> findById(Long id) {
        requireNonNull(id);
        Product product = map.get(id);

        return Optional.of(product);
    }
}
