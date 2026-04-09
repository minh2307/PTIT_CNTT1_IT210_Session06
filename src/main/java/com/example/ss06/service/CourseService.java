import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Course getByCode(String code) {
        return repository.findByCode(code);
    }

    public List<Course> filterCourses(String level, Double maxFee) {
        List<Course> result = repository.findAll();
        if (level != null && !level.isEmpty()) {
            result = result.stream()
                    .filter(c -> c.getLevel().equalsIgnoreCase(level))
                    .toList();
        }
        if (maxFee != null && maxFee > 0) {
            result = result.stream()
                    .filter(c -> c.getFee() <= maxFee)
                    .toList();
        }
        return result;
    }

    public void updateCourse(Course course) {
        repository.update(course);
    }

    public String deleteCourse(Long id) {
        Course course = repository.findById(id);
        if (course == null) {
            return "Khóa học không tồn tại";
        }
        if (course.getStudentCount() > 0) {
            return "Không thể hủy khóa học đã có học viên đăng ký";
        }
        repository.delete(id);
        return "Xóa thành công";
    }
}