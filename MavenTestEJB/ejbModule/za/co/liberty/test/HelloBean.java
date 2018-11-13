package za.co.liberty.test;

import javax.ejb.Local;
import javax.ejb.Stateless;

import za.co.liberty.test.view.HelloBeanLocal;

/**
 * Session Bean implementation class HelloBean
 */
@Stateless
@Local(HelloBeanLocal.class)
public class HelloBean implements HelloBeanLocal {


	public boolean testMe(String var) {
		System.out.println("testMe (" + var + ")");
		return true;
	}

}
