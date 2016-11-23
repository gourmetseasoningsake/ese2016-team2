package ch.unibe.ese.team1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.unibe.ese.team1.controller.pojos.forms.SearchForm;
import ch.unibe.ese.team1.controller.service.AdService;
import ch.unibe.ese.team1.controller.service.AuctionService;
import ch.unibe.ese.team1.model.Ad;
import ch.unibe.ese.team1.model.Advertisement;
import ch.unibe.ese.team1.model.Auction;

/** Handles all requests concerning the search for ads. */
@Controller
public class SearchController {

	@Autowired
	private AdService adService;

	@Autowired
	private AuctionService auctionService;

	/**
	 * The search form that is used for searching. It is saved between request
	 * so that users don't have to enter their search parameters multiple times.
	 */
	private SearchForm searchForm;

	/** Shows the search ad page. */
	@RequestMapping(value = "/searchAd", method = RequestMethod.GET)
	public ModelAndView searchAd() {
		ModelAndView model = new ModelAndView("searchAd");
		return model;
	}

	/**
	 * Gets the results when filtering the ads in the database by the parameters
	 * in the search form.
	 */
	@RequestMapping(value = "/results", method = RequestMethod.POST)
	public ModelAndView results(@Valid SearchForm searchForm, BindingResult result) {
		if (!result.hasErrors()) {
			ModelAndView model = new ModelAndView("results");

			List<Advertisement> results = new ArrayList<Advertisement>();
			List<Advertisement> premiumResults = new ArrayList<Advertisement>();
			Iterable<Ad> matchingAds;
			Iterable<Auction> matchingAuctions;
			if (searchForm.getBuyable()) {
				matchingAuctions = auctionService.queryResults(searchForm, false);
				for (Auction auction : matchingAuctions) {
					results.add(auction);
				}
				matchingAuctions = auctionService.queryResults(searchForm, true);
				for (Auction auction : matchingAuctions) {
					premiumResults.add(auction);
				}
			}
			matchingAds = adService.queryResults(searchForm, false);
			for (Ad ad : matchingAds) {
				results.add(ad);
			}
			matchingAds = adService.queryResults(searchForm, true);
			for (Ad ad : matchingAds) {
				premiumResults.add(ad);
			}
			model.addObject("results", results);
			model.addObject("premiumResults", premiumResults);
			return model;

		} else

		{
			// go back
			return searchAd();
		}
	}

	@ModelAttribute
	public SearchForm getSearchForm() {
		if (searchForm == null) {
			searchForm = new SearchForm();
		}
		return searchForm;
	}
}
