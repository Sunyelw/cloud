package com.springboot.eureka.provider.email.service;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class SmsHandleUtil {

    private static final String S_KEY = "1234567890123456";
    private static final String CHARSET = "UTF-8";
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static final String ENCRYPT_TYPE_AES = "AES";
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final String UNKNOWN = "unknown";

    /*public static void main(String[] args) throws Exception {
        String dateStr = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        System.out.println("date: " + dateStr);
        // 鍘熷鏄庢枃: 100001 -> anime-sms-sys00000000000001
        // 鍘熷鏄庢枃: 100002 -> anime-sms-sys00000000000002
        String encrypt = encryptAES("9a693e9333c615470690d73016cb312afea8f4d1f423f106642c0f75beaa10b9 " + dateStr);
        System.out.println("encryptAES: " + encrypt);
        String decrypt = decryptAES(encrypt);
        System.out.println("decryptAES: " + decrypt);

        // System.out.println(isInCIDRRange("192.168.1.127", "192.168.1.64/26"));
        // System.out.println(isInCIDRRange("192.168.1.2", "192.168.0.0/23"));
        // System.out.println(isInCIDRRange("192.168.0.1", "192.168.0.0/24"));
        // System.out.println(isInCIDRRange("192.168.0.0", "192.168.0.0/32"));
        // System.out.println(isInCIDRRange("192.168.202.54", "192.168.203.0/32"));
    }*/

    public static void main(String[] args) throws Exception{
        System.out.println(decryptAES("/h08GU/lmTduz3RxN5+MY2B21fMOYRcMr4Z9yjoXdv7zmHQ67nDHJVAPxA2bXGzAZAGv2iGAmvuwZWSVYN1WmdVFjSgnfLIYjoysqyitOcbxjMTyoiSUX2cr0pXIqns9"));
        System.out.println(encryptAES("9a693e9333c615470690d73016cb312afea8f4d1f423f106642c0f75beaa10b9 20190404175010"));
    }

    public static boolean isWhiteIpAddress(List<String> ipWhiteList) {
        return ipWhiteList.contains(getIpAddress());
    }

    public static String encryptAES(String plainText) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(S_KEY.getBytes("utf-8"), 0, 16, ENCRYPT_TYPE_AES);
        Cipher cipher = Cipher.getInstance(ALGORITHM);

        byte[] iv = new byte[16];
        SecureRandom rand = new SecureRandom();
        rand.nextBytes(iv);
        IvParameterSpec ivSpec = new IvParameterSpec(iv, 0, 16);
        cipher.init(1, keySpec, ivSpec);

        byte[] plainTextBytes = plainText.getBytes(CHARSET);
        byte[] encrypted = cipher.doFinal(plainTextBytes);

        byte[] encryptedWithIv = new byte[encrypted.length + 16];

        System.arraycopy(iv, 0, encryptedWithIv, 0, 16);
        System.arraycopy(encrypted, 0, encryptedWithIv, 16, encrypted.length);
        return Base64.encodeBase64String(encryptedWithIv);
    }

    private static byte[] decryptDataNew(byte[] cipherTextWithIv, byte[] key) throws Exception {
        byte[] iv = new byte[16];
        byte[] cipherText = new byte[cipherTextWithIv.length - 16];
        System.arraycopy(cipherTextWithIv, 0, iv, 0, 16);
        System.arraycopy(cipherTextWithIv, 16, cipherText, 0, cipherText.length);
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        SecretKeySpec keySpec = new SecretKeySpec(key, ENCRYPT_TYPE_AES);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(2, keySpec, ivSpec);

        return cipher.doFinal(cipherText);
    }

    private static byte[] decryptDataOld(byte[] cipherText, byte[] key) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(key, 0, 16, ENCRYPT_TYPE_AES);
        Cipher cipher = Cipher.getInstance(ALGORITHM);

        byte[] iv = new byte[16];
        IvParameterSpec ivSpec = new IvParameterSpec(iv, 0, 16);
        cipher.init(2, keySpec, ivSpec);

        byte[] original = cipher.doFinal(cipherText);
        byte[] plainText = new byte[original.length - 16];

        System.arraycopy(original, 16, plainText, 0, original.length - 16);
        return plainText;
    }

    /**
     * AES瑙ｅ瘑
     * 
     * @param cipherBase64
     *            瀵嗘枃
     * @return 瑙ｅ瘑鍚庣殑瀛楃涓�
     * @throws Exception
     *             鎶涘嚭寮傚父
     */
    public static String decryptAES(String cipherBase64) throws Exception {
        byte[] cipherText = Base64.decodeBase64(cipherBase64);
        byte[] plainText;
        try {
            plainText = decryptDataNew(cipherText, S_KEY.getBytes("utf-8"));
        } catch (Exception localException) {
            plainText = decryptDataOld(cipherText, S_KEY.getBytes("utf-8"));
        }
        return new String(plainText, CHARSET);
    }

    /**
     * 鑾峰彇瀹㈡埛绔痠p
     * 
     * @return 瀹㈡埛绔湡瀹瀒p
     */
    public static String getIpAddress() {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == ZERO || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == ZERO || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == ZERO || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == ZERO || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == ZERO || UNKNOWN.equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr().equals("0:0:0:0:0:0:0:1") ? "127.0.0.1" : request.getRemoteAddr();
        }
        return ip;
    }

    public static boolean isInCIDRRange(String ip, String cidr) {
        String[] ips = ip.split("\\.");
        int ipAddress = (Integer.parseInt(ips[0]) << 24) | (Integer.parseInt(ips[1]) << 16)
                | (Integer.parseInt(ips[2]) << 8) | Integer.parseInt(ips[3]);
        int type = Integer.parseInt(cidr.replaceAll(".*/", ""));
        int mask = 0xFFFFFFFF << (32 - type);
        String cidrIp = cidr.replaceAll("/.*", "");
        String[] cidrIps = cidrIp.split("\\.");
        int cidrIpAddr = (Integer.parseInt(cidrIps[0]) << 24) | (Integer.parseInt(cidrIps[1]) << 16)
                | (Integer.parseInt(cidrIps[2]) << 8) | Integer.parseInt(cidrIps[3]);

        return (ipAddress & mask) == (cidrIpAddr & mask);
    }

    public static int hourDiff(String format, String firstTime, String secondTime) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat(format);
        long time1 = dateFormat.parse(firstTime).getTime();
        long time2 = dateFormat.parse(secondTime).getTime();
        return (int) ((time2 - time1) / (1000 * 60 * 60));
    }

    /**
     * SHA256鍔犲瘑
     * 
     * @param str
     *            闇�瑕佸姞瀵嗙殑瀛楃涓�
     * @return 鍔犲瘑鍚庣殑瀛楃涓�
     */
    public static String encryptSHA256(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest messageDigest;
        messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(str.getBytes(CHARSET));
        return byte2Hex(messageDigest.digest());
    }

    private static String byte2Hex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        String temp;
        for (byte aByte : bytes) {
            temp = Integer.toHexString(aByte & 0xFF);
            if (temp.length() == ONE) {
                builder.append("0");
            }
            builder.append(temp);
        }
        return builder.toString();
    }
}
