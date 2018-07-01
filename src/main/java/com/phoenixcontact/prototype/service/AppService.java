package com.phoenixcontact.prototype.service;


import com.phoenixcontact.prototype.domain.App;

public interface AppService {
    Iterable<App> listAllApps();

    App getAppById(Long id);

    App saveApp(App app);

    void deleteApp(Long id);
    
    boolean existsAppById(Long id);
}
