package com.oht.firsts.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.oht.firsts.vo.Board;

@Mapper
public interface BoardMapper {
	public ArrayList<Board> boardList();
	
	public Board detailBoard(Board board);
//	
//	public int writeBoard(Board board);
}
