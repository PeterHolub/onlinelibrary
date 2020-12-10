package com.peterholub.onlinelibrary.service.impl;

import com.peterholub.onlinelibrary.model.BookImage;
import com.peterholub.onlinelibrary.repository.BookImageRepository;
import com.peterholub.onlinelibrary.service.BookImageService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.Serializable;

@Service
@Transactional
@Getter
public class BookImageServiceImpl implements BookImageService {

    @Autowired
    private BookImageRepository bookImageRepository;

    @Override
    public BookImage getBookImage(Serializable id) {
        return getBookImageRepository().getOne((Long) id);
    }

    @Override
    public void saveBookImage(BookImage bookImage) {
        getBookImageRepository().save(bookImage);
    }

    @Override
    public void deleteBookImage(Serializable id) {
        getBookImageRepository().deleteById((Long) id);
    }

}
