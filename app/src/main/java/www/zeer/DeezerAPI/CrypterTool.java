package www.zeer.DeezerAPI;

import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by root on 1/12/16.
 */
public class CrypterTool {
    public static String MD5(String stringToHash){
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(stringToHash.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String encryptWithAESKey(String stringToEncrypt){
        Log.e("encryptWithAESKey", stringToEncrypt);
        try {
            SecretKeySpec skeySpec = new SecretKeySpec("jo6aey6haid2Teih".getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            try {
                cipher.init(1, skeySpec);
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            }
            byte[] encrypted = cipher.doFinal(stringToEncrypt.getBytes("ISO-8859-1"));
            return encrypted.toString().toLowerCase();
            //return DatatypeConverter.printHexBinary(encrypted).toLowerCase();
        } catch (NoSuchAlgorithmException|NoSuchPaddingException|IllegalBlockSizeException|BadPaddingException|UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
