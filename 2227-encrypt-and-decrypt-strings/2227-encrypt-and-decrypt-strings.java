class Encrypter {

    HashMap<Character,String> encryptMap;
     HashMap<String,Integer> decryptMap;
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        this.encryptMap = new HashMap<>();
        this.decryptMap = new HashMap<>();
        for(int i=0;i<keys.length;i++){
            encryptMap.put(keys[i],values[i]);
        }
        for(int i=0;i<dictionary.length;i++){
            String encryptWord = encrypt(dictionary[i]);
            decryptMap.put(encryptWord, decryptMap.getOrDefault(encryptWord,0)+1);
        }
    }
    
    public String encrypt(String word1) {
        StringBuilder str = new StringBuilder();
        for(int i=0;i<word1.length();i++){
            str.append(encryptMap.get(word1.charAt(i)));
        }
        return str.toString();
    }
    
    public int decrypt(String word2) {
        return decryptMap.getOrDefault(word2,0);
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */