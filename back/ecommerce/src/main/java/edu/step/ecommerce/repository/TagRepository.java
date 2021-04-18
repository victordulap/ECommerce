package edu.step.ecommerce.repository;

import edu.step.ecommerce.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Integer> {
}
