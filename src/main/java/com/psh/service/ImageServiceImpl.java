package com.psh.service;

import com.psh.mapper.ImageMapper;
import com.psh.model.book.AttachImage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService{

    private final ImageMapper imageMapper;

    @Override
    public void imageEnroll(AttachImage attachImage) {
        imageMapper.imageEnroll(attachImage);
    }

    @Override
    public List<AttachImage> getAttachList(int bookId) {
        return imageMapper.getAttachList(bookId);
    }

    @Transactional
    @Override
    public void deleteImageAll(int bookId) {
        imageMapper.deleteImageAll(bookId);
    }

    @Override
    public List<AttachImage> getAttachInfo(int bookId) {
        return imageMapper.getAttachInfo(bookId);
    }
}
