# rsa-body-spring-boot
## 使用方式
导入对应的MAVEN包:

```
 <dependency>
      <groupId>com.barcke.y</groupId>
      <artifactId>rsa-body-spring-boot</artifactId>
      <version>1.0.0</version>
</dependency>
```
导入对应的包后开启配置项:
```
rsa:
  encrypt:
    open: true # 是否开启加密 true  or  false
    showLog: true # 是否打印加解密log true  or  false 默认false
    timestampCheck: true #是否开启时间校验 默认false
    publicKey: #公钥信息
    privateKey: #私钥信息
```
可以使用如下方法生产公私钥:
```
import com.barcke.y.rsa.util.RSAUtil

//用于生产公私钥 返回值为对应的公私钥信息 生成后请保管好
RSAUtil.genKeyPair();
```

开启配置项后在项目中使用注解:
```
@Encrypt //加密
@Decrypt(required = true, timeout = 30000L) //解密 required默认关闭,timeout超时时间设置
```
示例:
![](https://imgkr.cn-bj.ufileos.com/11593bc0-ef37-403a-85d5-0e8a9d80d07a.png)
**注意传参方式为“application/json”加密会对整个回参加密,解密会对整个入参解密.**

前端加解密可以同步公私钥信息、不过需要注意RSA的长度加密为117解密为256超长是会报错的~
前端加解密可参考如下:
```
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使用jsencrypt执行OpenSSL的RSA加密，解密</title>
</head>
<!--引入jsencrypt.js-->
<script src="https://cdn.bootcss.com/jsencrypt/3.0.0-beta.1/jsencrypt.js"></script>
<script type="text/javascript">
//公钥
var PUBLIC_KEY = 'MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC8HMr2CBpoZPm3t9tCVlrKtTmI4jNJc7/HhxjIEiDjC8czP4PV+44LjXvLYcSV0fwi6nE4LH2c5PBPEnPfqp0g8TZeX+bYGvd70cXee9d8wHgBqi4k0J0X33c0ZnW7JruftPyvJo9OelYSofBXQTcwI+3uIl/YvrgQRv6A5mW01QIDAQAB';
//私钥
var PRIVATE_KEY = 'MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALwcyvYIGmhk+be320JWWsq1OYjiM0lzv8eHGMgSIOMLxzM/g9X7jguNe8thxJXR/CLqcTgsfZzk8E8Sc9+qnSDxNl5f5tga93vRxd5713zAeAGqLiTQnRffdzRmdbsmu5+0/K8mj056VhKh8FdBNzAj7e4iX9i+uBBG/oDmZbTVAgMBAAECgYEAmgNU5NTDkj9B+Pnt6UU8doSjw3+3j+bV2K2yS3QUOvAUus/Ax7x6ktjWxzCXvDY9IfUil2RNv9vtKEAqYLCWjc+lf8PV/yH1b7NEgyeAPBXtAJRoOnmYL2bdPW92kP9KgxJruF6Dz/C5AmMOncsvq8ABD+9Darn4p8dwj2ZC4O0CQQDf/AHmZsQokEItfCy4mHS9UbxbfIhEUv1ApPh/+Sr7NkJkHWYCtBQo+8jKO6zurAZQgWBPD1XX2UE4R+VIiZazAkEA1wAqtMvGhccyRZr+6kpkpDIa8+9jOE+nGUzqTDvgCID6as8AzOONFVVK6m/UUqkhcJ8Qu1pF36BGojy5BX2KVwJBAJSFpbji0hXXupowqfLp3RcgmNbNWAp+QUJZYhJx5cdYbmO2fssyH+AhPT6knYJR/YnqkDM8hv6vKCkqu2YDHjMCQAOA8TE5EOclM+CGghj3VWSHnIDVKdzFD4gOBNNxNlltIKeU8AJmwunSFgJ0CBXAw9a+ANvMwM7AIeaK7sj0HskCQAvxfDCq7gaNx+pfu0FHG8Gix08A/A6foggBl1fVu+L9sr9ZuOQ3HbXnl28F9ewuB9xdjnLUDjp7W7U0pB+vKoQ=';
//使用公钥加密
var encrypt = new JSEncrypt();
//encrypt.setPrivateKey('-----BEGIN RSA PRIVATE KEY-----'+PRIVATE_KEY+'-----END RSA PRIVATE KEY-----');
encrypt.setPublicKey('-----BEGIN PUBLIC KEY-----' + PUBLIC_KEY + '-----END PUBLIC KEY-----');
var str = {
"uid":"1223334",
"pwd":"asd"
}
var encrypted = encrypt.encrypt(JSON.stringify(str));
console.log('加密前数据:%o', str);
console.log('加密后数据:%o', encrypted);
//使用私钥解密
var decrypt = new JSEncrypt();
//decrypt.setPublicKey('-----BEGIN PUBLIC KEY-----' + PUBLIC_KEY + '-----END PUBLIC KEY-----');
decrypt.setPrivateKey('-----BEGIN RSA PRIVATE KEY-----'+PRIVATE_KEY+'-----END RSA PRIVATE KEY-----');
var uncrypted = decrypt.decrypt(encrypted);
console.log('解密后数据:%o', uncrypted);
</script>

</html>
```

