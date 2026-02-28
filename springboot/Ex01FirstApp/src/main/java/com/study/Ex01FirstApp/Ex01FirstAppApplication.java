package com.study.Ex01FirstApp;
// package : 폴더 경로를 다르게 함으로 동일한 클래스이름을 구분하는 것
//   com.study.MyClass : 클래스이름은 동일해도, 다른 패키지(폴드)에 있으므로
//  com.play.MyClass    동일 이름의 클래스를 사용하게 한다.
// 예) 서울 사는 김서방, 인천 사는 김서방

import org.springframework.boot.SpringApplication;
//autoconfigure : 라이브러리들의 디펜던시(버전 호환성 체크)
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ex01FirstAppApplication {

	public static void main(String[] args) {
		//String[] args : 프로그램 구동시 주는 파라미터
		//   예) 한컴오피스 hwp.exe  문서1.hwp  문서2.hwp
		//   예) java -version

		//SpringApplication.run : 스프링 앱 실행 함수
		//Ex01FirstAppApplication.class : 클래스 정보를 담은 객체
		SpringApplication.run(Ex01FirstAppApplication.class, args);
		System.out.println("메인 함수 실행됨.");
	}

}
