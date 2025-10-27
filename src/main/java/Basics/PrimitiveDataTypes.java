package Basics;

public class PrimitiveDataTypes {

    public static void main(String[] args){
        byte byte1 = 127;
        byte byte2 = -126;

        System.out.println(byte1);
        System.out.println(byte2);

        byte[] byteArray = {20,10,5,-60};

        for (byte b:byteArray) {
            System.out.println("byteArray: "+b);
        }

        byte byteOverflow = 127;
        byteOverflow++;
        System.out.println("byteOverflow: "+ byteOverflow);

    }

}
