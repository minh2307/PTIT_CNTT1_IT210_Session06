import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CourseRepository {
    private static List<Course> courses = new ArrayList<>();

    static {
        courses.add(new Course(1L, "IELTS-6.5", "IELTS 6.5", "Intermediate", 5000000, "2026-05-01", "3 months", "Mr. A", "Lộ trình IELTS 6.5", 10));
        courses.add(new Course(2L, "IELTS-7.0", "IELTS 7.0", "Advanced", 7000000, "2026-06-01", "4 months", "Ms. B", "Lộ trình IELTS 7.0", 0));
        courses.add(new Course(3L, "BASIC-ENG", "Basic English", "Beginner", 3000000, "2026-04-20", "2 months", "Mr. C", "Tiếng Anh cơ bản", 5));
        courses.add(new Course(4L, "COMM-ENG", "Communication", "Intermediate", 4000000, "2026-05-15", "2.5 months", "Ms. D", "Giao tiếp", 0));
        courses.add(new Course(5L, "ADV-GRAM", "Advanced Grammar", "Advanced", 6000000,  "2026-06-10", "3 months", "Mr. E", "Ngữ pháp nâng cao", 2));
    }

    public List<Course> findAll() {
        return courses;
    }

    public Course findByCode(String code) {
        return courses.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }

    public List<Course> findByLevel(String level) {
        return courses.stream()
                .filter(c -> c.getLevel().equalsIgnoreCase(level))
                .collect(Collectors.toList());
    }

    public List<Course> findByMaxFee(double maxFee) {
        return courses.stream()
                .filter(c -> c.getFee() <= maxFee)
                .collect(Collectors.toList());
    }

    public void update(Course updatedCourse) {
        for (Course c : courses) {
            if (c.getId().equals(updatedCourse.getId())) {
                c.setFee(updatedCourse.getFee());
                c.setStartDate(updatedCourse.getStartDate());
                break;
            }
        }
    }

    public void delete(Long id) {
        courses.removeIf(c -> c.getId().equals(id));
    }

    public Course findById(Long id) {
        return courses.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}