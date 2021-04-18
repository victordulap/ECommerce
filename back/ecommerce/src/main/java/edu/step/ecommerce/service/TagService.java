package edu.step.ecommerce.service;

import edu.step.ecommerce.model.Tag;
import edu.step.ecommerce.model.dto.TagDTO;
import edu.step.ecommerce.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TagService {
    private TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public TagDTO save(TagDTO tagDTO) {
        Tag tag = new Tag(tagDTO.getId(), tagDTO.getName());
        return TagDTO.from(this.tagRepository.save(tag));
    }

    public Set<TagDTO> findAll() {
        return this.tagRepository.findAll()
                .stream()
                .map(tag -> TagDTO.from(tag))
                .collect(Collectors.toSet());
    }
}
