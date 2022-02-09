package ru.vlapin.experiments.neoflextrading.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.experiments.neoflextrading.model.Cat;

public interface CatRepository extends JpaRepository<Cat, UUID> {
}
