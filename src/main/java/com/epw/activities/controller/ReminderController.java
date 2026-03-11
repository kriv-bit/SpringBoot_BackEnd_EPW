package com.epw.activities.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.epw.activities.dto.CreateReminderRequest;
import com.epw.activities.entity.Activity;
import com.epw.activities.entity.Reminder;
import com.epw.activities.exception.ResourceNotFoundException;
import com.epw.activities.repository.ActivityRepository;
import com.epw.activities.repository.ReminderRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/activities/{activityId}/reminders")
public class ReminderController {
    private final ActivityRepository activityRepository;
    private final ReminderRepository reminderRepository;

    public ReminderController(ActivityRepository activityRepository, ReminderRepository reminderRepository) {
        this.activityRepository = activityRepository;
        this.reminderRepository = reminderRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Reminder create(@PathVariable Long activityId,
            @Valid @RequestBody CreateReminderRequest request) {
        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new ResourceNotFoundException("Activity " + activityId + " not found"));
        Reminder reminder = new Reminder();
        reminder.setRemindAt(request.getRemindAt());
        reminder.setNote(request.getNote());
        reminder.setActivity(activity);
        return reminderRepository.save(reminder);
    }
}