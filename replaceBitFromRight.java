// Given an integer A.
// Swap the Bth and Cth bit from right in binary representation of A.
// Return the integer formed.
public class replaceBitFromRight {
    public static void main(String[] args) {
        int A = 2, B = 23, C = 14;
        B--; C--;
        int f1 = (A>>B)&1;
        int f2 = (A>>C)&1;
        A += (f1<<C) + (f2<<B) - (f1<<B) - (f2<<C);
        System.out.println(A);
        // String bits = Integer.toString(A, 2);
        // int mxBC = Math.max(B, C);
        // mxBC = mxBC > 8 ? 8 : mxBC;
        // String updatedBits = "";
        // if (mxBC > bits.length()) {
        //     int diff = Math.abs(mxBC - bits.length());
        //     for (int i = 0; i < diff; i++) {
        //         updatedBits = updatedBits + "0";
        //     }

        // }
        // updatedBits = updatedBits + bits;
        // System.out.println(bits);
        // System.out.println(updatedBits);
        // // char[] aray = updatedBits.isEmpty() ? bits.toCharArray():
        // // updatedBits.toCharArray();
        // char[] aray = updatedBits.toCharArray();
        // System.out.println(aray);

        // int araySize = aray.length;
        // if (B > 8 || C > 8) {

        // } else {
        //     if (aray[araySize - B] == '0') {
        //         aray[araySize - B] = '1';
        //     } else {
        //         aray[araySize - B] = '0';
        //     }
        //     if (aray[araySize - C] == '0') {
        //         aray[araySize - C] = '1';
        //     } else {
        //         aray[araySize - C] = '0';
        //     }
        // }

        // String newBits = new String(aray);
        // System.out.println(newBits);
        // int res = Integer.parseInt(newBits, 2);
        // System.out.println(res);
    }

}
