import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Sniper on 2018/8/16.
 */
public class Kitchen {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        HashSet<String> set = new HashSet<String>();

        while(in.hasNext()){
            String str = in.nextLine();
            String arr[] = str.split(" ");
            for(int i=0; i<arr.length; i++){
                set.add(arr[i]);
            }
        }

        System.out.println(set.size());
        set.clear();
    }
}

/*
BUTTER FLOUR<br/>HONEY FLOUR EGG
* */
