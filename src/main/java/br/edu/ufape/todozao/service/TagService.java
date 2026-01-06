package br.edu.ufape.todozao.service;

import br.edu.ufape.todozao.exception.TagAlreadyExistsException;
import br.edu.ufape.todozao.exception.TagNotFoundException;
import br.edu.ufape.todozao.exception.UnauthorizedTagAccessException;
import br.edu.ufape.todozao.model.Tag;
import br.edu.ufape.todozao.model.User;
import br.edu.ufape.todozao.repository.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagService {

    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Transactional
    public Tag criarTag(String name, String color, User user) {

        if (tagRepository.existsByNameAndUserId(name, user.getId())) {
            throw new TagAlreadyExistsException();
        }

        return tagRepository.save(
                Tag.builder()
                        .name(name)
                        .color(color)
                        .user(user)
                        .build()
        );
    }

    public List<Tag> listarTagsDoUsuario(User user) {
        return tagRepository.findAllByUserId(user.getId());
    }

    @Transactional
    public void deletarTag(Long tagId, User user) {

        Tag tag = tagRepository.findById(tagId)
                .orElseThrow(TagNotFoundException::new);

        if (!tag.getUser().getId().equals(user.getId())) {
            throw new UnauthorizedTagAccessException();
        }

        tagRepository.delete(tag);
    }

}
