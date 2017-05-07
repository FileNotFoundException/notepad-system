package cn.com.notepad.proxy;

import org.junit.Test;

public class ProxyTest {
	
	@Test
	public void doTest() {
		IBusiness business = new BusinessImpl();
		CustomerProxy customerProxy = new CustomerProxy(business);
		business = (IBusiness) customerProxy.getProxy();
		business.doSomething();
	}

}
