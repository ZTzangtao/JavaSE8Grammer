package lambadaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.SecureRandom;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.naming.NamingException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
//import com.justep.baas.action.ActionContext;


//import platform.core.model.LocalBusinessException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * zjrs
 *
 * @author zangtao
 * @create 2019 - 06 -03 10:19
 */
public class zjrs {

    private static Map<String, String> serviceMap;
    private static Map<String, String> keysMap;
    private static Document document;
    private static Element data;
    public static String GGFWPT_254_188 = "GGFWPT_254_188";
    public static String GGFWPT_254_194 = "GGFWPT_254_194";
    public static String customCode = "W0002019";//客户代码
    public static String sysCodes = "I90025";//服务端代码
    public static String key = "MnuYbhGv";//des key
    public static String sender = "O90000";
    public static String reciver = "O90000";
    public static String ZJRSUrlTest = "http://222.186.79.178:16000/PublicServiceInterface/zjws/doServer.action";
    public static String ZJRSUrl = "http://222.186.79.178:16080/PublicServiceInterface/zjws/doServer.action";

    public static void main(String[] args) throws Exception {
        zjrs testService = new zjrs();
        gendata(testService);
        testService.doCall(zjrs.GGFWPT_254_188, customCode, "1111");
    }

    public zjrs() {
        serviceMap = new HashMap<String, String>();
        keysMap = new HashMap<String, String>();
        serviceMap.put(GGFWPT_254_188,ZJRSUrlTest);// 测试环境调用地址
        serviceMap.put(GGFWPT_254_194, ZJRSUrl);// 正式环境调用地址

        keysMap.put(customCode, key);// 配置客户代码和加密密钥信息,由信息中心统一提供

    }

    public static void gendata(zjrs testService) {
        //WS-A0001
        testService.initMessage(sysCodes, "WS-B0003", sender, reciver);
        testService.addData("aae135", "411302199212260814");//身份证号
        testService.addData("ext001", "0");//照片
    }

    public JSONObject getUserInfo(JSONObject params) throws SQLException, NamingException {
        serviceMap = new HashMap<String, String>();
        keysMap = new HashMap<String, String>();
        serviceMap.put(GGFWPT_254_188,ZJRSUrlTest);// 测试环境调用地址
        serviceMap.put(GGFWPT_254_194, ZJRSUrl);// 正式环境调用地址

        keysMap.put(customCode, key);// 配置客户代码和加密密钥信息,由信息中心统一提供

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        JSONObject rt = new JSONObject();
        //String district = params.getString("id");

        initMessage(sysCodes, "WS-A0001", sender, reciver);
        addData("aae135", "321101198210054052");
        addData("ext001", "0");

        String xml="";
        try{
            xml=doCall(GGFWPT_254_188, customCode, "1111");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
		/*
		JSONObject rt = new JSONObject();
		JSONArray coms = new JSONArray();
		while(rs.next()){
			JSONObject com = new JSONObject();
			com.put("fId", rs.getString("F_Id"));
			coms.add(com);
		}
		rt.put("coms", coms);*/
        rt.put("flag", 0);
        return rt;
    }

    public void initCall(String name) throws Exception {
    }

    public void initMessage(String sysCodeS, String busCodeS, String senderS, String reciverS) {
        String dateString = new SimpleDateFormat("yyyyMMddHHssmm").format(new Date());
        document = DocumentHelper.createDocument();
        Element root = document.addElement("tradeMsg");
        Element head = root.addElement("head");
        Element version = head.addElement("version");
        version.setText("1.0.0");
        Element ref = head.addElement("ref");
        ref.setText(senderS + dateString.substring(0, 8) + "00000001");
        Element sysCode = head.addElement("sysCode");
        sysCode.setText(sysCodeS);
        Element busCode = head.addElement("busCode");
        busCode.setText(busCodeS);
        Element tradeSrc = head.addElement("tradeSrc");
        tradeSrc.setText("O");
        Element sender = head.addElement("sender");
        sender.setText(senderS);
        Element reciver = head.addElement("reciver");
        reciver.setText(reciverS);
        Element reSnd = head.addElement("reSnd");
        reSnd.setText("N");
        Element date = head.addElement("date");
        date.setText(dateString.substring(0, 8));
        Element time = head.addElement("time");
        time.setText(dateString.substring(8));
        Element rst = head.addElement("rst");
        Element tradeCode = rst.addElement("tradeCode");
        tradeCode.setText("99");
        Element busiCode = rst.addElement("busiCode");
        busiCode.setText("9999");
        Element info = rst.addElement("info");
        info.setText("");
        data = root.addElement("data");
    }

    public Element addData(String name, String value) {
        Element element = data.addElement(name);
        element.setText(value);
        return element;
    }

    public void doCall(String urlkey, String customercode) throws Exception {
        doCall(urlkey, customercode, "1001");
    }

    public String doCall(String urlkey, String customercode, String showmsgflag) throws Exception {
        String xml = null;
        String url = "";
        String key = "";
        if (StringUtils.isNotBlank(keysMap.get(customercode))) {
            key = keysMap.get(customercode);
        }
        url = serviceMap.get(urlkey);
        System.out.println("请求地址：");
        System.out.println(url);
        System.out.println("-----------------------------------");
        System.out.println("客户代码：");
        System.out.println(customercode);
        System.out.println("-----------------------------------");
        System.out.println("加密密钥：");
        System.out.println(key);
        System.out.println("-----------------------------------");
        if (StringUtils.isBlank(showmsgflag) || showmsgflag.length() != 4) {
            showmsgflag = "0000";
        }
        Map<String, String> paramMap = null;
        try {
            String param = document.asXML();
            if ("1".equals(showmsgflag.substring(0, 1))) {
                System.out.println("请求明文：");
                System.out.println(param);
                System.out.println("-----------------------------------");
            }
            paramMap = new HashMap<String, String>();
            xml = encrypt(param, key);
            paramMap.put("customercode", customercode);
            paramMap.put("xml", xml);
            if ("1".equals(showmsgflag.substring(1, 2))) {
                System.out.println("请求秘文：");
                System.out.println("{\"customercode\":\"" + customercode + "\",\"xml\":\"" + xml + "\"}");
                System.out.println("-----------------------------------");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String remsg = doPost(url, paramMap, null, false);
        try {
            if ("1".equals(showmsgflag.substring(2, 3))) {
                System.out.println("返回秘文：");
                System.out.println(remsg);
                System.out.println("-----------------------------------");
            }
            remsg = decrypt(remsg, key);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if ("1".equals(showmsgflag.substring(3, 4))) {
            System.out.println("返回报文：");
            System.out.println(remsg);
        }
        return remsg;
    }

    public Element getData() {
        return data;
    }

    public void setData(Element data) {
        this.data = data;
    }

    public static String doPost(String url, Map<String, String> params, String charset, boolean pretty) {
        StringBuffer response = new StringBuffer();
        HttpClient client = new HttpClient();
        PostMethod method = new PostMethod(url);
        if (params != null) {
            NameValuePair[] param = new NameValuePair[params.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : params.entrySet()) {
                param[i] = new NameValuePair(entry.getKey(), entry.getValue());
                i++;
            }
            method.setRequestBody(param);
        }
        try {
            client.executeMethod(method);
            if (method.getStatusCode() == HttpStatus.SC_OK) {
                BufferedReader reader = null;
                reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), "UTF-8"));
                String line;
                while ((line = reader.readLine()) != null) {
                    if (pretty){
                        response.append(line).append(System.getProperty("line.separator"));
                    }

                    else{
                        response.append(line);
                    }

                }
                reader.close();
            }
        } catch (Exception e) {
            //throw new LocalBusinessException("http请求发送失败", e);
        } finally {
            method.releaseConnection();
        }
        return response.toString();
    }

    public static String encrypt(String data, String key) throws Exception {
        byte[] bt = encrypt(data.getBytes("utf-8"), key.getBytes());
        String strs = new BASE64Encoder().encode(bt);
        return strs;
    }

    public static String decrypt(String data, String key) throws IOException, Exception {
        if(data == null) {
            return null;
        }

        BASE64Decoder decoder = new BASE64Decoder();
        byte[] buf = decoder.decodeBuffer(data);
        byte[] bt = decrypt(buf, key.getBytes());
        return new String(bt, "utf-8");
    }

    private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }

    private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
        SecureRandom sr = new SecureRandom();
        DESKeySpec dks = new DESKeySpec(key);
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey securekey = keyFactory.generateSecret(dks);
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.DECRYPT_MODE, securekey, sr);
        return cipher.doFinal(data);
    }

}