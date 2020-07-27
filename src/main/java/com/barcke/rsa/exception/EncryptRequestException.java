package com.barcke.rsa.exception;

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
public class EncryptRequestException extends RuntimeException {

    public EncryptRequestException(String msg) {
        super(msg);
    }
}
