package string;



public class UTF8Validation {

    public static void main(String[] args) {
        UTF8Validation uv = new UTF8Validation();
        int[] data = {248,130,130,130};
        System.out.println(uv.validUtf8(data));
    }

    public boolean validUtf8(int[] data) {

        for(int i=0;i<data.length;i++){
            int bit=0;
            int n = 128;
            int num = data[i];
            for(int j=0;j<4;j++){
                if(num/n==0)
                    break;
                bit++;
                num = num-n;
                n = n>>1;
            }
            if(num/n!=0)
                return false;
            if(bit==1)
                return false;
            else if(bit>1){
                for(int k=0;k<bit-1;k++){
                    i++;
                    if(i>=data.length || !check(data[i]))
                        return false;

                }
            }


        }

        return true;
    }

    private boolean check(int n){
        return n/128==1 && (n-128)/64==0;
    }
}
