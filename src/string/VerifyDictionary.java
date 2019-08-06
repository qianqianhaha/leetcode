package string;

public class VerifyDictionary {

    public static void main(String[] args) {
        VerifyDictionary vd = new VerifyDictionary();
        String words[] = {"apple","app"};
        String order = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(vd.isAlienSorted(words,order));

    }

    public boolean isAlienSorted(String[] words, String order) {
        //boolean res = true;

        if(words.length<=1)
            return true;

        for(int i=0;i<words.length-1;i++){
            String str1 = words[i];
            String str2 = words[i+1];
            int index = 0;
            while(index<str1.length()&&index<str2.length()){
                if(str1.charAt(index)==str2.charAt(index)){
                    index++;
                    if(str1.length()>index && str2.length()==index)
                        return false;
                }else{
                    if(order.indexOf(String.valueOf(str1.charAt(index)))>order.indexOf(String.valueOf(str2.charAt(index)))){
                        return false;
                    }else{
                        break;
                    }
                }

            }

        }

        return true;
    }
}
