import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class test {
    int i;
    test(){
        System.out.println("not set");
    };
    test(int a){
        i = a;
    };
    public static void main(String[] args) {
        test t = new test();
        System.out.println(t.i);
    }
}
