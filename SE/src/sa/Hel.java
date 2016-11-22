package sa;

import java.text.SimpleDateFormat;
import java.util.Date;



public class Hel {

	public static void main(String[] args) {
		
		while(true){
		String Data=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		System.out.println(Data);
		}
		
	}

}
