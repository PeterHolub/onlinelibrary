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

@Service
@Transactional
@Getter
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author getAuthor(Serializable id) {
        return getAuthorRepository().getOne((Long) id);
    }

    @Override
    public void saveAuthor(Author author) {
        getAuthorRepository().save(author);

    }

    @Override
    public void deleteAuthor(Serializable id) {
        getAuthorRepository().deleteById((Long) id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return getAuthorRepository().findAll();
    }
}
