package edu.step.ecommerce.repository;

import edu.step.ecommerce.model.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Integer> {
}
