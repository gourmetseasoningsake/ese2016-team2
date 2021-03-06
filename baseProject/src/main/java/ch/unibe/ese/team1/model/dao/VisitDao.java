package ch.unibe.ese.team1.model.dao;

import org.springframework.data.repository.CrudRepository;

import ch.unibe.ese.team1.model.Ad;
import ch.unibe.ese.team1.model.Auction;
import ch.unibe.ese.team1.model.Visit;

public interface VisitDao extends CrudRepository<Visit, Long> {
	public Iterable<Visit> findByAdOrderByStartTimestampAsc(Ad ad);
	public Iterable<Visit> findByAuctionOrderByStartTimestampAsc(Auction auction);
}
