package com.example.lecturer_demo.repositories;

import com.example.lecturer_demo.dto.CourseResponseV2;
import com.example.lecturer_demo.models.Course;
import com.example.lecturer_demo.models.CourseStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    boolean existsByIdAndStatus(Long id, CourseStatus status);

    @Query("""
        SELECT new com.example.lecturer_demo.dto.CourseResponseV2(
            c.id,
            c.title,
            c.status
        )
        FROM Course c
        WHERE c.status = :status
    """)
    Page<CourseResponseV2> findAllByStatusV2(
            @Param("status") CourseStatus status,
            Pageable pageable
    );
}