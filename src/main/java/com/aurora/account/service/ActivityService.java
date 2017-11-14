package com.aurora.account.service;

import com.aurora.account.model.Activity;
import com.aurora.account.repository.ActivityRepository;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository = new ActivityRepository();

    public void saveActivity(Activity activity){activityRepository.saveObj(activity);}

    public boolean checkActivated(String id){return activityRepository.checkAvailability(id);}

}
