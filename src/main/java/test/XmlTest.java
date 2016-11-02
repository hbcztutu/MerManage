package test;

import java.util.HashMap;
import java.util.Map;

import org.dom4j.DocumentException;

import common.utils.XmlFormat;
import common.utils.XmlUtils;

public class XmlTest {
  public static void main(String[] args) {
    String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n "
        + "<TRAN_RESP>\n "
        + "<RESP_TYPE>S</RESP_TYPE>"
        + "  <RESP_CODE>000000</RESP_CODE>"
        + "  <RESP_MSG>交易成功</RESP_MSG>"
        + "  <MCHNT_CD>20151106D1SH01</MCHNT_CD>"
        + "  <TRAN_DATE>20151119</TRAN_DATE>"
        + "  <TRAN_TIME>155223</TRAN_TIME>"
        + "  <TRAN_ID>1915522301000000</TRAN_ID>"
        + "  <BANK_TRAN_ID>2015111905833458</BANK_TRAN_ID>"
        + "  <BANK_TRAN_DATE>20151119</BANK_TRAN_DATE>"
        + "  <BANK_TRAN_TIME>155224</BANK_TRAN_TIME>"
        + "  <CHARGE_FEE>0</CHARGE_FEE>"
        + "  <RESV>无</RESV>\n"
        + "</TRAN_RESP>";
    
    Map<String,Object > resmap = new HashMap<>();
    System.out.println(xml);
    try {
      System.out.println(XmlFormat.formatXml(xml));
      xml = XmlFormat.formatXml(xml);
    } catch (Exception e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    try {
      resmap = (Map<String, Object>) XmlUtils.Dom2Map(xml);
      String ss = (String) resmap.get("RESP_TYPE");
      System.out.println(ss);
    } catch (DocumentException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }
 
     
}
