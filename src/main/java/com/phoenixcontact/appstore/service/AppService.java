package com.phoenixcontact.appstore.service;


import java.util.List;

import com.phoenixcontact.appstore.domain.App;

public interface AppService {
    App getAppById(Long id);

    App saveApp(App app);

    void deleteApp(Long id);
    
    boolean existsAppById(Long id);
   
    Iterable<App> findAllApps(); 
    
    Iterable<App> findApps(String text, Integer minRating); 
}
