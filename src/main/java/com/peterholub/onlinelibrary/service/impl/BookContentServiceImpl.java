package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.BookContent;
import com.peterholub.onlinelibrary.repository.BookContentRepository;
import com.peterholub.onlinelibrary.service.BookContentService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;

@Service
@Transactional
@Getter
public class BookContentServiceImpl implements BookContentService {

    @Autowired
    private BookContentRepository bookContentRepository;

    @Override
    public BookContent getBookContent(Serializable id) {
        return getBookContentRepository().getOne((Long) id);
    }

    @Override
    public void saveBookContent(BookContent bookContent) {
        getBookContentRepository().save(bookContent);
    }

    @Override
    public void deleteBookContent(Serializable id) {
        getBookContentRepository().deleteById((Long) id);
    }
}
