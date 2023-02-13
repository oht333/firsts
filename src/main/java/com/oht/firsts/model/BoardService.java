package com.oht.firsts.model;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oht.firsts.vo.Board;

@Service
public class BoardService {

	@Autowired
	private BoardDAO boardDao;

	public ArrayList<Board> boardList() {
        return boardDao.boardList();
	}
	
	public Board detailBoard(Board board) {
		return boardDao.detailBoard(board);
	}
//	
//	public int writeBoard(Board board) {
//		return boardDao.writeBoard(board);
//		
//	}
}
