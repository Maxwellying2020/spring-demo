package com.example.demo.busi.service;

import com.example.demo.busi.model.SecurityLogInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * <p>
 * <b>Class name</b>: LogService
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
 * 2019-12-24    zhang ying        1.0          Initial Creation
 *
 * </pre>
 *
 * @author zhang ying
 * @date 2019-12-24
 * </p>
 */
@Service
@Slf4j
public class LogService extends BaseService {

    @EventListener(SecurityLogInfo.class)
    public void receiveLogEvent(SecurityLogInfo logInfo) {

        log.info("receive log event!");
        //TODO
    }
}
