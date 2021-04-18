package edu.step.ecommerce.repository;

import edu.step.ecommerce.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
