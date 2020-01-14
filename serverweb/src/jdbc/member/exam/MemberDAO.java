package jdbc.member.exam;

import java.util.ArrayList;

public interface MemberDAO {
	int insert(MemberDTO user);	//������
	int update(String id, String addr);	//�����������
	int delete(String id); //���Ż��
	ArrayList<MemberDTO> memberList(); //2. ��ü ������ ��ȸ
	ArrayList<MemberDTO> findByAddr(String addr); //5. �ּҷ� ��� �˻�
	MemberDTO login(String id, String pass);
	 // boolean(�α��� ����/����) - �α��� �Ŀ� �̸�, ��ٱ��� �� �������� ������ �ʿ��ϴ�. 
}
