package com.example.demo.busi.model;

import com.example.demo.busi.model.enums.EDataAction;
import com.example.demo.busi.model.enums.EDataAttr;
import com.example.demo.busi.model.enums.EDataEntity;
import com.example.demo.busi.model.enums.EDataId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

/**
 * <p>
 * <b>Class name</b>: SecurityLogInfo
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
 * 2019-04-19    zhang ying        1.0          Initial Creation
 *
 * </pre>
 *
 * @author zhang ying
 * @date 2019-04-19
 * </p>
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SecurityLogInfo {
    private String sourceIp;

    private Long operatorId;

    private EDataEntity entity;

    private EDataAction act;

    private EDataId idType;

    private String id;

    private Date operateTime;

    private Map<EDataAttr, String> attrs;
}
