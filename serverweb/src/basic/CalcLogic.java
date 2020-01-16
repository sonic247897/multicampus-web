package basic;
//비지니스 로직(서버쪽에서 하고싶은 일 명시)
public class CalcLogic {
	public double calc(int num1, String method, int num2) {
		System.out.println("비지니스 메소드 호출....");
		double result =0.0; //계산결과를 저장할 변수
		switch(method) {
			case "+":
				result = num1+num2;
				break;
			case "-":
				result = num1-num2;
				break;
			case "*":
				result = num1*num2;
				break;
			case "/":
				result = (double)num1/num2;
				break;
					
		}
		return result;
	}
}
