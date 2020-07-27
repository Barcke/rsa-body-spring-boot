package com.barcke.rsa.annotation;

import java.lang.annotation.*;

/**
 *                  ,;,,;
 *                ,;;'(    社
 *      __      ,;;' ' \   会
 *   /'  '\'~~'~' \ /'\.)  主
 * ,;(      )    /  |.     义
 *,;' \    /-.,,(   ) \    码
 *     ) /       ) / )|    农
 *     ||        ||  \)
 *     (_\       (_\
 *
 * @author Barcke
 * @date 2020/7/27 15:20
 * @version 1.0
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Decrypt{

    /**
     * 请求参数一定要是加密内容
     */
    boolean required() default false;

    /**
     * 请求数据时间戳校验时间差
     * 超过(当前时间-指定时间)的数据认定为伪造
     * 注意应用程序需要捕获 {@link EncryptRequestException} 异常
     */
    long timeout() default 3000;
}
