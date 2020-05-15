package edu.northeastern.cs5200.daos;

import java.util.Collection;

import edu.northeastern.cs5200.models.Website;

public interface WebsiteImpl {
	void createWebsiteForDeveloper(int developerId, Website website);

    Collection<Website> findAllWebsite();

    Collection<Website> findWebsitesForDeveloper(int developerId);

    Website findWebsiteById(int WebsiteId);

    int updateWebsite(int websiteId, Website website);

    int deleteWebsite(int websiteId);
}
