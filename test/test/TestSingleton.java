package test;
import com.zszd.ai.tools.Singleton;


public class TestSingleton {

	/**
	 * @Title          main
	 * @Description    TODO
	 * @Tags           @param args   
	 * @Return         void   
	 * @throws
	 * @author           lizx
	 * @date           2018-2-11        下午10:41:30
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("singleton test()--------------------->" + Singleton.test());
        System.out.println("singleton getInstance()--------------------->" + Singleton.getInstance());
        System.out.println("singleton test()--------------------->" + Singleton.test());
        
	}

}
