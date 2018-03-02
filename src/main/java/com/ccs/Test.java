package com.ccs;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.commons.codec.binary.Base64;

/**
 * @title Test
 * @description TODO
 * @date 2013-7-2
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCVxjt1gGInUGF+QqUj4+2sYQHms8EqUD4"+
        "j5AP+L4XKGGDRuHhxcg/Co6vhMWn7tUqyFiLLR/Y0idiHKCV/OySjAyu1xzdmb85hY4/zfck"+
        "OUQ1roSFdqcRGNRTczRtlJ00WohN0Ezei8p081n08L5q0tllSTI+G6BLKzJrTaCIX+QIDAQAB";
        String ENCODING = "UTF-8";
        String KEY_ALGORITHM = "RSA";
        String version = "02";
        String token="e345dc371fe49707fe498141f12e0b1b";
        String username = "尚德128";
        //sendTime应该从https://api.baidu.com/sem/sms/ServerTime获取，而不是直接使用自己的系统时间
        long sendTime = System.currentTimeMillis();
        StringBuilder builder = new StringBuilder();
        builder.append(token);
        builder.append("###");
        builder.append(username);
        builder.append("###");
        builder.append(sendTime);
        String str = builder.toString();
        byte[] data;
        try {
            data = str.getBytes(ENCODING);
            byte[] publicKeyBytes = Base64.decodeBase64(publicKey.getBytes(ENCODING));
            X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
            Key key = keyFactory.generatePublic(x509KeySpec);
            Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encryptBytes = cipher.doFinal(data);
            String encryptStr = Base64.encodeBase64String(encryptBytes);
            //这个打印出来的是最终使用的token
            System.out.println(version+encryptStr);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }
    }
}