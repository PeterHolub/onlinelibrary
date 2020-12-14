package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.Author;
import com.peterholub.onlinelibrary.repository.AuthorRepository;
import com.peterholub.onlinelibrary.service.AuthorService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Getter
public class AuthorServiceImpl implements AuthorService {

    final private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(
    AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> getAuthor(Long id) {
        return getAuthorRepository().findById(id);
    }

    @Override
    public void saveAuthor(Author author) {
        getAuthorRepository().save(author);

    }

    @Override
    public void deleteAuthor(Long id) {
        getAuthorRepository().deleteById(id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return getAuthorRepository().findAll();
    }
}
