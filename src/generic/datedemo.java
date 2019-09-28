package generic;
import java.util.Date;

public class datedemo {

	public static void main(String[] args) {


		Date d = new Date();
		String curentdateandtime = d.toString();
		System.out.println(curentdateandtime);
		
		String replaceAll = curentdateandtime.replaceAll(":", "__");
		System.out.println(replaceAll);

	}

}
