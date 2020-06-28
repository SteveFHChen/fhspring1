package fhjunittest;

import org.junit.Test;
import org.mockito.Mockito;

import com.fh.forjunit.UserManager;

public class Test2MockTestVoidFunction {
	
	/**
	 * Reference:
	 * Mock测试出现的背景
	 * http://liuzhijun.iteye.com/blog/1512780
	 * Mock以及Mockito的使用
	 * http://blog.csdn.net/mao520741111/article/details/51462570
	 * 
	 * Mockito的使用
	 * 1. 验证方法调用，包括void方法内部的执行调用情况
	 * 2. 指定mock对象的某些方法的行为
	 */
	
    @Test
    public void testLogin() throws Exception {
        //验证LoginPresenter里面的mUserManager的performLogin()方法得到了调用，同时参数分别是“xiaochuang”、“xiaochuang‘s password”
        UserManager mockUserManager = Mockito.mock(UserManager.class);
        LoginPresenter loginPresenter = new LoginPresenter();
        loginPresenter.setUserManager(mockUserManager);  //<==

        loginPresenter.login("xiaochuang", "xiaochuang password");

        Mockito.verify(mockUserManager).performLogin("xiaochuang", "xiaochuang password");
//        Mockito.verify(mockUserManager, Mockito.times(2)).performLogin("xiaochuang", "xiaochuang password");
    }
    
}
