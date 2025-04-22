import java.net.InetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIpAddress {
  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.validIPAddress("192.168.1.1"));
    System.out.println(s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"));
    System.out.println(s.validIPAddress("256.256.256.256"));
    System.out.println(s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:"));
    System.out.println(s.validIPAddress("172.16.254.1"));
  }
}

class Solution {
  public String validIPAddress(String queryIP) {
    String chunkIPv4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])";
    Pattern patternIPV4 = Pattern.compile(
        "^(" + chunkIPv4 + "\\.){3}" + chunkIPv4 + "$"
    );
    String chunkIPv6 = "([0-9a-fA-F]{1,4})";
    Pattern pattenIPv6 = Pattern.compile("^(" + chunkIPv6 + "\\:){7}" + chunkIPv6 + "$");
    if(patternIPV4.matcher(queryIP).matches()) return "IPv4";
    if(pattenIPv6.matcher(queryIP).matches()) return "IPv6";
    return "Neither";
  }
}