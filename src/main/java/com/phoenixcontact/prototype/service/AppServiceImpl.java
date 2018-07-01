package com.phoenixcontact.prototype.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phoenixcontact.prototype.domain.App;
import com.phoenixcontact.prototype.repository.AppRepository;

@Service
public class AppServiceImpl implements AppService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private AppRepository appRepository;

    @Autowired
    public void setAppRepository(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    @Override
    public Iterable<App> listAllApps() {
        logger.debug("listAllApps called");
        return appRepository.findAll();
    }

    @Override
    public App getAppById(Long id) {
        logger.debug("getAppById called");
        return appRepository.findById(id).orElse(null);
    }

    @Override
    public App saveApp(App App) {
        logger.debug("saveApp called");
        return appRepository.save(App);
    }

    @Override
    public void deleteApp(Long id) {
        logger.debug("deleteApp called");
        appRepository.deleteById(id);
    }

    @Override
    public boolean existsAppById(Long id) {
        logger.debug("existsAppById called");
        return appRepository.existsById(id);
    }

}
