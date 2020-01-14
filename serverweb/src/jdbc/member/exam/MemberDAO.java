package jdbc.member.exam;

import java.util.ArrayList;

public interface MemberDAO {
	int insert(MemberDTO user);	//사원등록
	int update(String id, String addr);	//사원정보수정
	int delete(String id); //사원탈퇴
	ArrayList<MemberDTO> memberList(); //2. 전체 사원목록 조회
	ArrayList<MemberDTO> findByAddr(String addr); //5. 주소로 사원 검색
	MemberDTO login(String id, String pass);
	 // boolean(로그인 성공/실패) - 로그인 후에 이름, 장바구니 등 여러가지 정보가 필요하다. 
}
