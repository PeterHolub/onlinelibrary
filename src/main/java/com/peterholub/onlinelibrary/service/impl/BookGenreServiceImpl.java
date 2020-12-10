package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.BookGenre;
import com.peterholub.onlinelibrary.model.key.BookGenreKey;
import com.peterholub.onlinelibrary.repository.BookGenreRepository;
import com.peterholub.onlinelibrary.service.BookGenreService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;

@Service
@Transactional
@Getter
public class BookGenreServiceImpl implements BookGenreService {

    @Autowired
    private BookGenreRepository bookGenreRepository;

    @Override
    public BookGenre getBookGenre(Serializable id) {
        return getBookGenreRepository().getOne((BookGenreKey) id);
    }

    @Override
    public void saveBookGenre(BookGenre bookGenre) {
        getBookGenreRepository().save(bookGenre);
    }

    @Override
    public void deleteBookGenre(Serializable id) {
        getBookGenreRepository().delete((BookGenre) id);
    }
}
