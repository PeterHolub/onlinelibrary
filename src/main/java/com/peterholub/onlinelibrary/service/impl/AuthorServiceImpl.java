package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.Author;
import com.peterholub.onlinelibrary.repository.AuthorRepository;
import com.peterholub.onlinelibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    @Autowired
   private AuthorRepository authorRepository;

    @Override
    public Author getAuthor(Serializable id) {
        return authorRepository.getOne((Long) id);
    }

    @Override
    public void createAuthor(Author author) {
        authorRepository.save(author);

    }

    @Override
    public void updateAuthor(Author author) {
        authorRepository.save(author);

    }

    @Override
    public void deleteAuthor(Serializable id) {
        authorRepository.deleteById((Long) id);
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
}
