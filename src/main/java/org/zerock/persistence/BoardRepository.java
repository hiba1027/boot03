package org.zerock.persistence;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.zerock.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long>{
	public List<Board> findBoardByTitle(String title);
	
	public Collection<Board> findByWriter(String writer);
	
	public Collection<Board> findByWriterContaining(String writer);
	
	public Collection<Board> findByWriterStartingWith(String writer);

	public Collection<Board> findByWriterEndingWith(String writer);
	
	public Collection<Board> findByTitleContainingAndWriterContaining(String title, String writer);
	
}
