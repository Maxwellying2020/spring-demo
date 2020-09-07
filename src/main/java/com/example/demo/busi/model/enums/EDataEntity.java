package com.example.demo.busi.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * <p>
 * <b>Class name</b>: EDataEntity
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

/**
 * 日志记录模块
 */
public enum EDataEntity {
    //用户
    USER;

    @JsonValue
    public String getEntity() {
        return name();
    }

    @JsonCreator
    public static EDataEntity create(String entity) {
        for (EDataEntity value : EDataEntity.values()) {
            if (value.getEntity().equals(entity)) {
                return value;
            }
        }
        return null;
    }

}
