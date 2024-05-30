package com.example.demo.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//가짜 저장소 만들기
public class MemberRepository {

//	회원 목록을 저장할 Map
	static Map<Integer, Member> store = new HashMap<>();
	
//	새로운 회원번호를 발급하기 위한 시퀀스
	static int sequence = 0;
	
	public Member save(Member member) {
		
		member.setNo(++sequence); // 중복되지 않기위해
		
		store.put(member.getNo(), member);
		
		return member;
		
		}
	
//		회원 단건 조회 메소드
	public Member findById(int no) { // pk 대신 식별자(key)
		
		return store.get(no);
	}
//		회원 목록 조회
	public List<Member> findAll() {
		
		return new ArrayList<>(store.values()); // Map => List로 형변환
	}
//		회원 전체 삭제
	public void clearStore() {
		store.clear();
	}
}
