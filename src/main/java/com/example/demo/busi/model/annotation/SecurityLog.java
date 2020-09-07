package com.example.demo.busi.model.annotation;

import com.example.demo.busi.model.enums.EDataAction;
import com.example.demo.busi.model.enums.EDataEntity;
import com.example.demo.busi.model.enums.EDataId;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * <b>Class name</b>: SecurityLog
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
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SecurityLog {
    /** 实体类型 */
    EDataEntity entity() default EDataEntity.USER;

    /** 操作 */
    EDataAction action() default EDataAction.ADD;

    /** id类型 */
    EDataId idType() default EDataId.ID;

    /** ID路径，支持SPEL表达式
     * 这里只能是"#..."的格式，ExpressionParser对格式有严格的要求，否则无法解析。
     *
     * */

    String idPath() default "#id";

    String test = "testxxx";

    String test() default "haha";
}
