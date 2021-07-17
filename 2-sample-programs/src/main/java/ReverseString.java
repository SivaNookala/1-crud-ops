public class ReverseString {
    public static void main(String[] args) {
        String str =  "Hyderabad";
        System.out.println("Initial String :" + str);
        char[] chars = str.toCharArray();
        StringBuilder reverseChars = new StringBuilder();
        for(int i=chars.length-1; i>=0; i--){
            reverseChars.append(chars[i]);
        }
        System.out.println("Reversed String :" + reverseChars);
    }
}