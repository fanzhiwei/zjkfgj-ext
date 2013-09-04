import java.text.SimpleDateFormat;
import java.util.Date;


public class Test {
	public static void main(String[] args) {
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMM");
		String str = sd.format(new Date());
		System.out.println(str);
	}
}
