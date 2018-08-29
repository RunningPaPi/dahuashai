/**
* COPYRIGHT. YYLive Inc. ALL RIGHTS RESERVED.
* Create On: 2016年12月21日 下午3:07:18
*/

package com.artqiyi.dahuashai.common.util;

import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

import com.artqiyi.dahuashai.common.util.DSAUtil;

/**
 * 类或接口作用描述
 * 
 * @author woosam
 * @since 2016年12月21日
 */
public class DSACoderTest {
	@Test  
    public void test() throws Exception {  
        String inputStr = "abc";  
        byte[] data = inputStr.getBytes();  
  
        // 构建密钥  
        Map<String, Object> keyMap = DSAUtil.initKey();  
  
        // 获得密钥  
        String publicKey = DSAUtil.getPublicKey(keyMap);  
        String privateKey = DSAUtil.getPrivateKey(keyMap);  
  
        System.err.println("公钥:\r" + publicKey);  
        System.err.println("私钥:\r" + privateKey);  
  
        // 产生签名  
        String sign = DSAUtil.sign(data, privateKey);  
        System.err.println("签名:\r" + sign);  
  
        // 验证签名  
        boolean status = DSAUtil.verify(data, publicKey, sign);  
        System.err.println("状态:\r" + status);  
        assertTrue(status);  
  
    }  
	@Test  
    public void test2() throws Exception {  
        //String inputStr = "abc";  
        String appkey="blacklist";
        String operator="wushaungyue5";
        Long uid=50016755l;
	    String sourceStr = String.format("%s%s%s", appkey, uid,operator);
        byte[] data = sourceStr.getBytes();  
  
        // 构建密钥  
        //Map<String, Object> keyMap = DSAUtil.initKey();  
  
        // 获得密钥  
//        String publicKey = DSAUtil.getPublicKey(keyMap);  
//        String privateKey = DSAUtil.getPrivateKey(keyMap);  
  
        String publicKey = "MIIBtzCCASwGByqGSM44BAEwggEfAoGBAP1/U4EddRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1AIlH7WT2NWPq/xfW6MPbLm1Vs14E7gB00b/JmYLdrmVClpJ+f6AR7ECLCT7up1/63xhv4O1fnxqimFQ8E+4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3RSAHHAhUAl2BQjxUjC8yykrmCouuEC/BYHPUCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoDgYQAAoGAQ8RGV7z2OLPho2q81236xgZa8Cx7irIk9JnLL3nvRb81wuSfyk5fYhqAup0WsaFUVOKGeIohF1Wbkku9VXw1Qw2N8k5tZa2K2BMbp7jF4y97qW3WfPHXycKWMPW2RfXPqs+d7FOIPA0Vlgir4RRPBTMRTn1tQZX8hsO5zQM15yo=";  
        String privateKey = "MIIBSwIBADCCASwGByqGSM44BAEwggEfAoGBAP1/U4EddRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1AIlH7WT2NWPq/xfW6MPbLm1Vs14E7gB00b/JmYLdrmVClpJ+f6AR7ECLCT7up1/63xhv4O1fnxqimFQ8E+4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3RSAHHAhUAl2BQjxUjC8yykrmCouuEC/BYHPUCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoEFgIUOkgKl4h8dAAxfolSBr0KE7zT0Jw=";  

        System.err.println("公钥:\r" + publicKey);  
        System.err.println("私钥:\r" + privateKey);  
  
        // 产生签名  
        String sign = DSAUtil.sign(data, privateKey);  
        System.err.println("签名:\r" + sign);  
  
        // 验证签名  
        //boolean status = DSAUtil.verify(data, publicKey, sign);
        //boolean status = DSAUtil.verify(data, publicKey, "MCwCFEKWubxfsSN+pIuXsbsfFqI/w6i/AhRGud+F9duTF2Q0ONFtUl+vcng35Q==");
        boolean status = DSAUtil.verify(data, publicKey, "MC0CFQCKOUYkUpQww+pOxdC6N2+Hiya0rAIUQQnppq/pJ9+WS1lITFXaHQIoXl9c=");
        System.err.println("状态:\r" + status);  
        assertTrue(status);  
  
    }  

	
	@Test  
    public void test3() throws Exception {  
        //String inputStr = "abc";  
        String appkey="star-photo";
        Long uid=546865085L;
        Long albumId=20280043L; 
	    String sourceStr = String.format("%s%s%s", appkey, uid,albumId);
	    
        System.err.println("sourceStr=" + sourceStr);
        
        byte[] data = sourceStr.getBytes();  
  
        // 构建密钥  
        Map<String, Object> keyMap = DSAUtil.initKey();  
  
        // 获得密钥  
        String publicKey = DSAUtil.getPublicKey(keyMap);  
        String privateKey = DSAUtil.getPrivateKey(keyMap);  
  
//        String publicKey = "MIIBtzCCASwGByqGSM44BAEwggEfAoGBAP1/U4EddRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1AIlH7WT2NWPq/xfW6MPbLm1Vs14E7gB00b/JmYLdrmVClpJ+f6AR7ECLCT7up1/63xhv4O1fnxqimFQ8E+4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3RSAHHAhUAl2BQjxUjC8yykrmCouuEC/BYHPUCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoDgYQAAoGAQ8RGV7z2OLPho2q81236xgZa8Cx7irIk9JnLL3nvRb81wuSfyk5fYhqAup0WsaFUVOKGeIohF1Wbkku9VXw1Qw2N8k5tZa2K2BMbp7jF4y97qW3WfPHXycKWMPW2RfXPqs+d7FOIPA0Vlgir4RRPBTMRTn1tQZX8hsO5zQM15yo=";  
//        String privateKey = "MIIBSwIBADCCASwGByqGSM44BAEwggEfAoGBAP1/U4EddRIpUt9KnC7s5Of2EbdSPO9EAMMeP4C2USZpRV1AIlH7WT2NWPq/xfW6MPbLm1Vs14E7gB00b/JmYLdrmVClpJ+f6AR7ECLCT7up1/63xhv4O1fnxqimFQ8E+4P208UewwI1VBNaFpEy9nXzrith1yrv8iIDGZ3RSAHHAhUAl2BQjxUjC8yykrmCouuEC/BYHPUCgYEA9+GghdabPd7LvKtcNrhXuXmUr7v6OuqC+VdMCz0HgmdRWVeOutRZT+ZxBxCBgLRJFnEj6EwoFhO3zwkyjMim4TwWeotUfI0o4KOuHiuzpnWRbqN/C/ohNWLx+2J6ASQ7zKTxvqhRkImog9/hWuWfBpKLZl6Ae1UlZAFMO/7PSSoEFgIUOkgKl4h8dAAxfolSBr0KE7zT0Jw=";  

        System.err.println("公钥:\r" + publicKey);  
        System.err.println("私钥:\r" + privateKey);  
  
        // 产生签名  
        String sign = DSAUtil.sign(data, privateKey);  
        System.err.println("签名:\r" + sign);  
  
        // 验证签名  
        //boolean status = DSAUtil.verify(data, publicKey, sign);
        //boolean status = DSAUtil.verify(data, publicKey, "MCwCFEKWubxfsSN+pIuXsbsfFqI/w6i/AhRGud+F9duTF2Q0ONFtUl+vcng35Q==");
        boolean status = DSAUtil.verify(data, publicKey, "MCwCFFu9VCcUBfI3y4e9pEXTH1ysrbdQAhR0nd+BJ4M/GdI90AVUzoqCBfItkQ==");
        System.err.println("状态:\r" + status);  
        assertTrue(status);  
  
    }  
}
