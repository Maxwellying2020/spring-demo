package com.example.demo.busi.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * <p>
 * <b>Class name</b>: ScheduleService
 * </p>
 * <p>
 * <b>Class description</b>: Class description goes here.
 * </p>
 * <p>
 * <b>Author</b>: zhang ying
 * </p>
 * <b>Change History</b>:<br/>
 * <p>
 *
 * <pre>
 * Date          Author       Revision     Comments
 * ----------    ----------   --------     ------------------
 * 2019-07-11    zhang ying        1.0          Initial Creation
 *
 * </pre>
 *
 * @author zhang ying
 * @date 2019-07-11
 * </p>
 */
@Slf4j
@Component
public class ScheduleService extends BaseService {

    @Scheduled(cron = "${dmp.schedule.timer.cron}")
    public void testScheduled() {
        log.info("testScheduled: " + LocalTime.now().toString());
    }
}
