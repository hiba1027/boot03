package org.zerock.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>, QuerydslPredicateExecutor<Board>{
	public List<Board> findBoardByTitle(String title);
	
	public Collection<Board> findByWriter(String writer);
	
	public Collection<Board> findByWriterContaining(String writer);
	
	public Collection<Board> findByWriterStartingWith(String writer);

	public Collection<Board> findByWriterEndingWith(String writer);
	
	public Collection<Board> findByTitleContainingAndWriterContaining(String title, String writer);
	
	public Collection<Board> findByTitleContainingAndBnoGreaterThan(String keyword, Long num);
	
	public Collection<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno);

	public List<Board> findByBnoGreaterThanOrderByBnoDesc(Long bno, Pageable paging);
	
//	public List<Board> findByBnoGreaterThan(Long bno, Pageable paging);

	public Page<Board> findByBnoGreaterThan(Long bno, Pageable paging);
	
	@Query("select b from Board b where b.title like %?1% and b.bno > 0 order by b.bno desc")
	public List<Board> findByTitle(String title);
}
