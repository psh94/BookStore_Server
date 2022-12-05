package com.psh.controller.admin;

import com.psh.exception.ExistSameBookException;
import com.psh.model.book.AttachImage;
import com.psh.model.book.Book;
import com.psh.model.book.BookInfo;
import com.psh.model.book.BookUpdateParam;
import com.psh.service.BookService;
import com.psh.service.ImageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static com.psh.utill.HttpResponses.*;

@RestController
@Slf4j
@RequestMapping("/admin/book")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    private final ImageService imageService;


    @PostMapping("/Enroll")
    public ResponseEntity<Void> bookEnroll(@Valid @ModelAttribute Book book){
        boolean existedBook = bookService.isExistBookIsbn(book.getIsbn());
        if(existedBook) {
            throw new ExistSameBookException("이미 등록된 책입니다.");
        }
        bookService.bookEnroll(book);
        return RESPONSE_OK;
    }

    @GetMapping("/{isbn}")
    public BookInfo bookDetail(@PathVariable String isbn){
       return bookService.bookGet(isbn);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> bookUpdate(@Valid @ModelAttribute BookUpdateParam param){
        boolean existedBook = bookService.isExistBookIsbn(param.getIsbn());
        if(existedBook) {
            throw new ExistSameBookException("같은 ISBN으로는 등록할 수 없습니다.");
        }
        bookService.bookUpdate(param);
        return RESPONSE_OK;
    }


    // image 테이블은 book 테이블의 bookId를 외래키로 받기 때문에 book 테이블의 데이터가 사라지면 에러가 발생한다.
    // 그렇기 때문에 bookId를 갖고 있는 book의 데이터를 지우기에 앞서 image의 데이터를 먼저 지워야 한다.

    @PostMapping("/delete")
    public ResponseEntity<Void> bookDelete(@Valid Book book){

        //이미지 정보를 먼저 지워준다.
        List<AttachImage> fileList = imageService.getAttachInfo(book.getBookId());

        if(fileList != null) {

            List<Path> pathList = new ArrayList();

            fileList.forEach(vo ->{

                // 원본 이미지
                Path path = Paths.get("C:\\upload", vo.getUploadPath(), vo.getUuid() + "_" + vo.getFileName());
                pathList.add(path);

                // 섬네일 이미지
                path = Paths.get("C:\\upload", vo.getUploadPath(), "s_" + vo.getUuid()+"_" + vo.getFileName());
                pathList.add(path);

            });

            pathList.forEach(path ->{
                path.toFile().delete();
            });
        }

        // 상품을 제거한다.
        if(book.getIsbn() != null){
            bookService.bookDelete(book);
            return RESPONSE_OK;
        }
        return RESPONSE_CONFLICT;
    }


}
