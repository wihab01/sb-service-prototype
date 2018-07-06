package com.phoenixcontact.appstore.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoenixcontact.appstore.domain.App;
import com.phoenixcontact.appstore.repository.AppRepository;

@Service
public class AppServiceImpl implements AppService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private AppRepository appRepository;
    
    @Autowired
    private EntityManager em;


    /**
     * 
     * @param appRepository
     */
    @Autowired
    public void setAppRepository(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    /**
     *
     * @return list of apps
     */
    @Override
    public Iterable<App> findAllApps() {
        logger.debug("findAllApps called");
        return findAppsByCriteria(null, null, null);
    }

    /**
     * 
     * @param id
     * @return app
     */
    @Override
    public App getAppById(Long id) {
    	App app = null;
        logger.debug("getAppById called");
		List<App> apps = findAppsByCriteria(id, null, null);
		if (apps != null) {
			app = apps.get(0);
		}
        return app;
    }

    /**
     *
     * param app
     * @return saved app
     */
    @Override
    public App saveApp(App app) {
        logger.debug("saveApp called");
        return appRepository.save(app);
    }

    /**
     * 
     * @param id
     */
    @Override
    public void deleteApp(Long id) {
        logger.debug("deleteApp called");
        appRepository.deleteById(id);
    }

    /**
     * 
     * @param id
     * @return true if app exist
     */
    @Override
    public boolean existsAppById(Long id) {
        logger.debug("existsAppById called");
        return appRepository.existsById(id);
    }

    /**
     * 
     * @param text
     * @param minRating
     * @return list of apps
     */
    @Override
	public Iterable<App> findApps(String text, Integer minRating) {
		return findAppsByCriteria(null, text, minRating);
	}

    /**
     * 
     * @param id
     * @param text
     * @param minRating
     * @return list of apps
     */
	private List<App> findAppsByCriteria(Long id, String text, Integer minRating) {
		String searchStr = text != null ? "%"+ text.toLowerCase() + "%" : null;
		String selectAppStr = "a.id, a.name, a.description, a.price, a.version, a.icon_url, a.active, a.user_uuid"; 
		String selectRatingStr = "avg(r.rating_value) as rating"; 
		String fromStr = "app a"; 
		String joinStr = " left outer join rating r on r.app_id = a.id"; 
		String joinTextStr = " join _user u on u.uuid = a.user_uuid"; 
		String whereStr = "";
		String whereIdStr = "a.id = :id";
		String whereTextStr = "(lower(a.name) like :searchStr or lower(a.description) like :searchStr or u.user_name like :searchStr) ";
		String havingStr = "having avg(r.rating_value) >= :minRating";
		if (id != null) {
			whereStr += (whereStr.length() > 0) ? " and " + whereIdStr : " where " + whereIdStr;
		}
		if (text != null) {
			joinStr += joinTextStr;
			whereStr += (whereStr.length() > 0) ? " and " + whereTextStr : " where " + whereTextStr;
		}
		String queryStr = "select " + selectAppStr + ", " + selectRatingStr + " from " + fromStr
				+ joinStr + whereStr + " group by " + selectAppStr;
		if (minRating != null) {
			queryStr += " having " + havingStr;
		}
		
		logger.info("queryStr = ", queryStr);
		Query sqlQuery = em.createNativeQuery(queryStr, App.class);
		if (id != null) {
			sqlQuery.setParameter("id", id);
		}    	
		if (text != null) {
			sqlQuery.setParameter("searchStr", searchStr);
		}    	
		if (minRating != null) {
			sqlQuery.setParameter("minRating", minRating);
		}

		@SuppressWarnings("unchecked")
		List<App> results = sqlQuery.getResultList();
        //TODO rating field not filled because of @Transient in entity class
		return results;
	}

}
