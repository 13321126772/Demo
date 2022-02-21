package com.example.demo.Utils;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
@Component
public class JwtUtils {
//    加密算法
    public static final String ENCRYPT_ALGORITHM="RSA";
//    加密长度
    public static final int DEFAULT_KEY_SIZE=2048;
//   从文件中获取公钥
    public static PublicKey getPublickey(String fileName)throws Exception{
        byte[] bytes=readFile(fileName);
        return getPublicKey(bytes);
    }
//    从文件中获取私钥
    public static PrivateKey getPirvateKey(String fileName)throws Exception{
        byte[]bytes=readFile(fileName);
        return getPrivateKey(bytes);
    }
//    获取公钥
    private static PublicKey getPublicKey(byte[] bytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        bytes=Base64.getDecoder().decode(bytes);
        X509EncodedKeySpec spec=new X509EncodedKeySpec(bytes);
        KeyFactory instance = KeyFactory.getInstance(ENCRYPT_ALGORITHM);
        return instance.generatePublic(spec);
    }
    //    获取私钥
    private static PrivateKey getPrivateKey(byte[] bytes) throws NoSuchAlgorithmException, InvalidKeySpecException {
        bytes=Base64.getDecoder().decode(bytes);
        X509EncodedKeySpec spec=new X509EncodedKeySpec(bytes);
        KeyFactory instance = KeyFactory.getInstance(ENCRYPT_ALGORITHM);
        return instance.generatePrivate(spec);
    }
    /**
     * 根据密文，生成RSA公钥和密钥，并写入文件
     * @param publicKeyFilename     公钥文件路径
     * @param privateKeyFilename    私钥文件路径
     * @param secret                生成密钥的密文
     * @param keySize               指定密钥长度，如果比默认小则选择默认长度2048
     * @throws Exception
     */
    public static void generateKey(String publicKeyFilename, String privateKeyFilename, String secret, int keySize) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ENCRYPT_ALGORITHM);
        SecureRandom secureRandom = new SecureRandom(secret.getBytes());
        keyPairGenerator.initialize(Math.max(keySize, DEFAULT_KEY_SIZE), secureRandom);
        KeyPair keyPair = keyPairGenerator.genKeyPair();

        // 获取公钥并写出
        byte[] publicKeyBytes = keyPair.getPublic().getEncoded();
        publicKeyBytes = Base64.getEncoder().encode(publicKeyBytes);
        writeFile(publicKeyFilename, publicKeyBytes);

        // 获取私钥并写出
        byte[] privateKeyBytes = keyPair.getPrivate().getEncoded();
        privateKeyBytes = Base64.getEncoder().encode(privateKeyBytes);
        writeFile(privateKeyFilename, privateKeyBytes);
    }

    private static byte[] readFile(String filename) throws IOException {
        return Files.readAllBytes(new File(filename).toPath());
    }

    private static void writeFile(String filename, byte[] bytes) throws IOException {
        File file = new File(filename);
        File fileParent = file.getParentFile();
        if (!file.exists()) {
            if (!fileParent.exists()) {
                fileParent.mkdirs();
            }
            file.createNewFile();
        }
        Files.write(file.toPath(), bytes);
    }
}
