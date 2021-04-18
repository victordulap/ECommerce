package edu.step.ecommerce.repository;

import edu.step.ecommerce.model.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SizeRepository extends JpaRepository<Size, Integer> {
}
