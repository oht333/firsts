package com.oht.firsts.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.oht.firsts.mapper.BoardMapper;
import com.oht.firsts.vo.Board;

@Repository
public class BoardDAO {

	@Autowired
	private BoardMapper boardMapper;
	
	public ArrayList<Board> boardList() {
		return boardMapper.boardList();
	}
	
	public Board detailBoard(Board board) {		
		return boardMapper.detailBoard(board);
	}
	
	public int writeBoard(Board board) {
		return boardMapper.writeBoard(board);
		
	}
	
	public void deleteBoard(Board board) {
		boardMapper.deleteBoard(board);
	}
	
	public int editBoard(Board board) { 
		return boardMapper.editBoard(board); 
	}
}
