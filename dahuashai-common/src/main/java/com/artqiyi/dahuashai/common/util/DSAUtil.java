package com.artqiyi.dahuashai.common.util;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;

/**
 * Created by wushuang on 2016/12/21.
 */
public class DSAUtil {
	public static final String DSA_ALGORITHM = "DSA";

	/**
	 * 默认密钥字节数
	 *
	 * <pre>
	 * DSA
	 * Default Keysize 1024
	 * Keysize must be a multiple of 64, ranging from 512 to 1024 (inclusive).
	 * </pre>
	 */
	private static final int DEFAULT_KEY_SIZE = 1024;

	/**
	 * 默认种子
	 */
	private static final String DEFAULT_SEED = "0j22507a10cchhh07a8b3082122966f9";

	private static final String PUBLIC_KEY = "DSAPublicKey";
	private static final String PRIVATE_KEY = "DSAPrivateKey";

	/**
	 * 
	 * 用私钥对信息生成数字签名
	 *
	 * @param  data - 要加密数据,字节数组
	 * @param  privateKey - 私钥字符串
	 * @return String - 数字签名字符串
	 * @throws Exception
	 */
	public static String sign(byte[] data, String privateKey) throws Exception {
		// 解密由base64编码的私钥
		byte[] keyBytes = Base64.decodeBase64(privateKey);

		// 构造PKCS8EncodedKeySpec对象
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);

		// KEY_ALGORITHM 指定的加密算法
		KeyFactory keyFactory = KeyFactory.getInstance(DSA_ALGORITHM);

		// 取私钥匙对象
		PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);

		// 用私钥对信息生成数字签名
		Signature signature = Signature.getInstance(keyFactory.getAlgorithm());
		signature.initSign(priKey);
		signature.update(data);

		return Base64.encodeBase64String(signature.sign());
	}

	/**
	 * 校验数字签名
	 *
	 * @param data - 要校验的源数据,字节数组
	 * @param publicKey - 公钥字符串
	 * @param sign - 数字签名. 客户端传过来的数字签名信息
	 * @return 校验成功返回true 失败返回false
	 * @throws Exception
	 */
	public static boolean verify(byte[] data, String publicKey, String sign)
			throws Exception {

		// 解密由base64编码的公钥
		byte[] keyBytes = decryptBASE64(publicKey);

		// 构造X509EncodedKeySpec对象
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);

		// ALGORITHM 指定的加密算法
		KeyFactory keyFactory = KeyFactory.getInstance(DSA_ALGORITHM);

		// 取公钥匙对象
		PublicKey pubKey = keyFactory.generatePublic(keySpec);

		Signature signature = Signature.getInstance(keyFactory.getAlgorithm());
		signature.initVerify(pubKey);
		signature.update(data);

		// 验证签名是否正常
		return signature.verify(decryptBASE64(sign));
	}

	/**
	 * 生成密钥对
	 *
	 * @param seed - 安全随机种子
	 * @return Map<String, Object> 密钥对
	 * @throws Exception
	 */
	public static Map<String, Object> initKey(String seed) throws Exception {
		KeyPairGenerator keygen = KeyPairGenerator.getInstance(DSA_ALGORITHM);
		// 初始化随机产生器
		SecureRandom secureRandom = new SecureRandom();
		secureRandom.setSeed(seed.getBytes());
		keygen.initialize(DEFAULT_KEY_SIZE, secureRandom);

		KeyPair keys = keygen.genKeyPair();

		DSAPublicKey publicKey = (DSAPublicKey) keys.getPublic();
		DSAPrivateKey privateKey = (DSAPrivateKey) keys.getPrivate();

		Map<String, Object> map = new HashMap<String, Object>(2);
		map.put(PUBLIC_KEY, publicKey);
		map.put(PRIVATE_KEY, privateKey);

		return map;
	}

	/**
	 * 生成密钥对
	 *
	 * @return Map<String, Object>
	 * @throws Exception
	 */
	public static Map<String, Object> initKey() throws Exception {
		return initKey(DEFAULT_SEED);
	}

	/**
	 * 取得私钥
	 *
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPrivateKey(Map<String, Object> keyMap)
			throws Exception {
		Key key = (Key) keyMap.get(PRIVATE_KEY);

		return encryptBASE64(key.getEncoded());
	}

	/**
	 * 取得公钥
	 *
	 * @param keyMap
	 * @return
	 * @throws Exception
	 */
	public static String getPublicKey(Map<String, Object> keyMap)
			throws Exception {
		Key key = (Key) keyMap.get(PUBLIC_KEY);

		return encryptBASE64(key.getEncoded());
	}

	/**
	 * 
	 * 把用BASE64加密成的字符串解密成byte[]数据
	 * 
	 * @param data
	 *            - String,用BASE64加密成的字符串
	 * @return byte[] - 解密成后byte[]数据
	 */
	public static byte[] decryptBASE64(String data) {
		return Base64.decodeBase64(data);
	}

	/**
	 * 
	 * 用BASE64把byte[]数据加密生成字符串
	 * 
	 * @param data
	 *            -byte[] 数据
	 * @return String
	 */
	public static String encryptBASE64(byte[] data) {
		return Base64.encodeBase64String(data);

	}
}
