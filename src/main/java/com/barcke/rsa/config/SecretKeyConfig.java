package com.barcke.rsa.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

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
@ConfigurationProperties(prefix = "rsa.encrypt")
@Configuration
public class SecretKeyConfig {

    private String privateKey;

    private String publicKey;

    private String charset = "UTF-8";

    private boolean open = true;

    private boolean showLog = false;

    /**
     * 请求数据时间戳校验时间差
     * 超过指定时间的数据认定为伪造
     */
    private boolean timestampCheck = false;

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isShowLog() {
        return showLog;
    }

    public void setShowLog(boolean showLog) {
        this.showLog = showLog;
    }

    public boolean isTimestampCheck() {
        return timestampCheck;
    }

    public void setTimestampCheck(boolean timestampCheck) {
        this.timestampCheck = timestampCheck;
    }
}
