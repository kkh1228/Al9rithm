package testal;
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());    
        
        int[] arr = new int[num];
        int sum = 1;
        
        for(int i=0; i<num; i++){

             
          arr[i] = Integer.parseInt(br.readLine());
        }
		int b = arr[num-1];
        for(int i=(num-1); i>=0; i--){
          if(i>=1){  
						if(b<arr[i-1])
            	{
             	sum++;
							b = arr[i-1];
							System.out.print("현재 b의값은"+b);
							System.out.print("현재 sum값은"+sum);
							
            	}
					}
        }
		 System.out.println(sum);
	}
}