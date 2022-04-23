public class Codec {
    
    HashMap<String,String> codeMap = new HashMap<>(), urlMap = new HashMap<>();
    public static final String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public String getCode(){
        char code[] = new char[6];
        for(int i=0;i<6;i++)
            code[i] = str.charAt((int)Math.random()*62);
        return "http://tinyurl.com/" + code.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(urlMap.containsKey(longUrl))
            return urlMap.get(longUrl);
        String code = getCode();
        while(codeMap.containsKey(code))
            code = getCode();
        codeMap.put(code,longUrl);
        urlMap.put(longUrl,code);
        
        return code;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return codeMap.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));