package com.psh.task;

import com.psh.mapper.ImageMapper;
import com.psh.model.book.AttachImage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TaskTest {

    @Autowired
    private ImageMapper imageMapper;



    private String getFolderYesterDay() {

        // 1. 폴더가 있는 경로를 문자열로 얻는 메서드를 작성

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cal = Calendar.getInstance();

        cal.add(Calendar.DATE, -1);

        String str = sdf.format(cal.getTime());

        return str.replace("-", File.separator);

    }

    @Test
    public void taskTest() {

        //DB에 저장된 리스트
        List<AttachImage> fileList = imageMapper.checkFileList();

        System.out.println("fileList : ");
        fileList.forEach(list -> System.out.println(list));
        System.out.println("========================================");

        //디렉토리(폴더)에 저장된 리스트
        List<Path> checkFilePath = new ArrayList<Path>();

        fileList.forEach(attachImage -> {
            Path path = Paths.get("C:\\upload", attachImage.getUploadPath(), attachImage.getUuid() + "_" + attachImage.getFileName());
            checkFilePath.add(path);
        });

        System.out.println("checkFilePath : ");
        checkFilePath.forEach(list -> System.out.println(list));
        System.out.println("========================================");

        // 디렉토리(폴더)에 저장된 썸네일 리스트
        fileList.forEach(attachImage -> {
            Path path = Paths.get("C:\\upload", attachImage.getUploadPath(), "s_" + attachImage.getUuid() + "_" + attachImage.getFileName());
            checkFilePath.add(path);
        });

        System.out.println("checkFilePath(썸네일 이미지 정보 추가 후) : ");
        checkFilePath.forEach(list -> System.out.println(list));
        System.out.println("========================================");





        File targetDir = Paths.get("C:\\upload", getFolderYesterDay()).toFile();
        File[] targetFile = targetDir.listFiles();

        System.out.println("targetFile : ");
        for(File file : targetFile) {
            System.out.println(file);
        }


        List<File> removeFileList = new ArrayList<File>(Arrays.asList(targetFile));

        for(File file : targetFile){
            checkFilePath.forEach(checkFile ->{
                if(file.toPath().equals(checkFile))
                    removeFileList.remove(file);
            });
        }

        for(File file : removeFileList) {
            file.delete();
        }
    }
}
