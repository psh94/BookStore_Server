package com.psh.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BatchTest {

    @Scheduled(cron = "0 * * * * *") // 1분으로 설정
    public void batchMethodTest() throws Exception{
        log.warn("배치 테스트");
        log.warn("------------");
    }

}
