package com.jczubak.crm.service;

import com.jczubak.crm.entity.Activity;
import com.jczubak.crm.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository){
        this.activityRepository=activityRepository;
    }

    public void addActivity(Activity activity){
        activityRepository.save(activity);
    }

    public void removeActivity(Long id){
        activityRepository.deleteById(id);
    }

    public List<Activity> getListOdActivity(){
        return activityRepository.findAll();
    }


}
