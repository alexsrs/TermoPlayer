package termoplayer;

public class Gerenciador {

	public static String getUsers() {
		// TODO Auto-generated method stub
		if (System.getProperty("os.name").startsWith("Windows")) {
			 return "/Users/";
		}else if(System.getProperty("os.name").startsWith("Linux")){
		     return "/home/";
		}
		return null;
	}

}
