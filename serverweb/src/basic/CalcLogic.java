package basic;
//�����Ͻ� ����(�����ʿ��� �ϰ���� �� ���)
public class CalcLogic {
	public double calc(int num1, String method, int num2) {
		System.out.println("�����Ͻ� �޼ҵ� ȣ��....");
		double result =0.0; //������� ������ ����
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
