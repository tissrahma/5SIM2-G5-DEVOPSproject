package tn.esprit.devopsProject.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devopsProject.entities.ActivitySector;
import tn.esprit.devopsProject.services.Iservices.IActivitySector;

import java.util.List;

@RestController
@AllArgsConstructor
public class ActivitySectorController {

    IActivitySector activitySectorService;

    @GetMapping("/activitySector")
    List<ActivitySector> retrieveAllActivitySectors(){
        return activitySectorService.retrieveAllActivitySectors();
    }

    @PostMapping("/activitySector")
    ActivitySector addActivitySector(@RequestBody ActivitySector activitySector){
        return activitySectorService.addActivitySector(activitySector);
    }

    @DeleteMapping("/activitySector/{id}")
    void deleteActivitySector(@PathVariable Long id){
        activitySectorService.deleteActivitySector(id);
    }

    @PutMapping("/activitySector")
    ActivitySector updateActivitySector(@RequestBody ActivitySector activitySector){
        return activitySectorService.updateActivitySector(activitySector);
    }

    @GetMapping("/activitySector/{id}")
    ActivitySector retrieveActivitySector(@PathVariable Long id){
        return activitySectorService.retrieveActivitySector(id);
    }
}
