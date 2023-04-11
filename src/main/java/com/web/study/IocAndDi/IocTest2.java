package com.web.study.IocAndDi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class IocTest2 {
	
	
	// 결합도를 낮추기 위해 외부에서 주입을 통해 코드 수정이 이루어져야 한다.
	@Qualifier("testC")
	@Autowired
	private Test test;
	
//	public IocTest(Test test) {
//		this.test = test;
//	}
	
	public void run() {
		test.printTest();
		System.out.println("IoCTest2 출력!");
	}
	

}
