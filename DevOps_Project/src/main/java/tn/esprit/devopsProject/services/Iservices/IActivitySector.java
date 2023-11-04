package tn.esprit.devopsProject.services.Iservices;

import tn.esprit.devopsProject.entities.ActivitySector;

import java.util.List;

public interface IActivitySector {
    List<ActivitySector> retrieveAllActivitySectors();

    ActivitySector addActivitySector(ActivitySector activitySector);

    void deleteActivitySector(Long id);

    ActivitySector updateActivitySector(ActivitySector activitySector);

    ActivitySector retrieveActivitySector(Long id);
}
