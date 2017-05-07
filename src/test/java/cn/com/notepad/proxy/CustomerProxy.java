package cn.com.notepad.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CustomerProxy implements InvocationHandler{
	// 目标对象   
    private Object target;
    
    public CustomerProxy(Object target) {  
        super();  
        this.target = target;  
    }  

	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//织入的代码
		System.out.println("------------------before------------------");  
		
		Object resultObject = method.invoke(target, args);
		
		//织入的代码
		System.out.println("-------------------after------------------");  
		
		return resultObject;
	}
	
	public Object getProxy() {  
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(), this);  
    } 
}
