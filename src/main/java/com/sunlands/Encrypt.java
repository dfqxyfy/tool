package com.sunlands;/*
 * ��ʾ����360���� �������� ��http://bbs.360safe.com/home.php?mod=space&uid=10606016�������ṩ  
 * ֻ�贫��,password �� apiSecret �����ɻ��AES ���ܺ������.
 * ����֤�ǿ��Է���clientLogin�������ҳɹ�����accessToken��sesseionToken��. 
*/
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class Encrypt {
        /**
         * 
         * @param s:Ҫ���м��ܵ��ַ���
         * @return  �ַ�����md5ֵ
         */
        public static String getMd5(String s) {
                char hexChar[] = {'0', '1', '2', '3', '4', '5', '6', 
                                '7', '8' , '9', 'a', 'b', 'c', 'd', 'e', 'f','A', 'B', 'C', 'D', 'E', 'F'};
                //md5�����㷨�ļ��ܶ���Ϊ�ַ����飬������Ϊ�˵õ����ܵĶ���
                byte[] b = s.getBytes();
                try {
                        MessageDigest md = MessageDigest.getInstance("MD5");
                        md.update(b);
                        byte[] b2 = md.digest();// ���м��ܲ������ַ�����
                        char str[] = new char[b2.length << 1];
                        int len = 0;
                        //���ַ�����ת����ʮ�����ƴ����γ����յ�����
                        for (int i = 0; i < b2.length; i++) {
                                byte val = b2[i];
                               str[len++] = hexChar[(val >>> 4) & 0xf];
                                str[len++] = hexChar[val & 0xf];
                        }
                        return new String(str);
                } catch (NoSuchAlgorithmException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                return null;
        }

        /**
         * AES ����
         * ��Կ��apiSecret ��ǰ16λ
         * ������apiSecret �ĺ�16λ
         * @param password
         * @param key
         * @param iv
         * @return
         * @throws Exception
         */
        public static String getAesEncrypt(String password,String apiSecret)throws Exception{
                String key = apiSecret.substring(0,16);
                String iv = apiSecret.substring(16);
                String md5Pass = getMd5(password);
                
                SecretKeySpec keyspec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes("UTF-8"));

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(md5Pass.getBytes("UTF-8"));
            
            return bytesToHexString(encrypted);
        }
         public static String bytesToHexString(byte[] bs) {  
                StringBuffer sb = new StringBuffer();  
                String hex = "";  
                for (int i = 0; i < bs.length; i++) {  
                    hex = Integer.toHexString(bs[i] & 0xFF);  
                    if (hex.length() == 1) {  
                        hex = '0' + hex;  
                    }  
                    sb.append(hex);  
                }  
                return sb.toString();  
            }  
}