package com.barcke.rsa.annotation;

import com.barcke.rsa.advice.EncryptRequestBodyAdvice;
import com.barcke.rsa.advice.EncryptResponseBodyAdvice;
import com.barcke.rsa.config.SecretKeyConfig;
import org.springframework.context.annotation.Import;

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
 * @projectName rsa-body-spring-boot
 * @className EncryptRequestException
 * @author Barcke
 * @date 2020/7/27 15:20
 * @version 1.0
 * @slogan: 源于生活 高于生活
 * @description:
 **/
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@Import({SecretKeyConfig.class,
        EncryptResponseBodyAdvice.class,
        EncryptRequestBodyAdvice.class})
public @interface EnableSecurity{

}
