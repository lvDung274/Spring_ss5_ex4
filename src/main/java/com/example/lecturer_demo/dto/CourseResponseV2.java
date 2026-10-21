package com.example.lecturer_demo.dto;

import com.example.lecturer_demo.models.CourseStatus;

public record CourseResponseV2(
        Long id,
        String title,
        CourseStatus status
) {}