# MOCK DATA KHÓA HỌC - EDU-PATH

## 1. Mục đích
File này dùng để chuẩn hóa dữ liệu mẫu cho toàn bộ nhóm.  
Tất cả thành viên nên bám theo đúng bộ dữ liệu này khi làm repository, service, controller và giao diện demo.

---

## 2. Danh sách 5 khóa học mẫu

| id | courseCode | name | level | tuitionFee | startDate | teacher | duration | studentCount | isFull | status |
|----|------------|------|-------|------------|-----------|---------|----------|--------------|--------|--------|
| 1 | ENG-BAS-01 | English Foundation | Beginner | 2500000 | 2026-05-10 | Nguyễn Minh Anh | 2 tháng | 0 | false | OPEN |
| 2 | ENG-COM-02 | English Communication | Intermediate | 3200000 | 2026-05-15 | Trần Thu Hà | 3 tháng | 18 | false | OPEN |
| 3 | IELTS-55 | IELTS Target 5.5 | Intermediate | 4800000 | 2026-05-20 | Lê Hoàng Nam | 3.5 tháng | 25 | true | FULL |
| 4 | TOEIC-650 | TOEIC Intensive 650+ | Advanced | 4200000 | 2026-06-01 | Phạm Quỳnh Chi | 3 tháng | 20 | false | OPEN |
| 5 | IELTS-65 | IELTS Master 6.5+ | Advanced | 5600000 | 2026-06-10 | Vũ Đức Long | 4 tháng | 30 | true | FULL |

---

## 3. Mô tả chi tiết từng khóa học

### 3.1. Khóa học 1
- **id:** 1
- **courseCode:** ENG-BAS-01
- **name:** English Foundation
- **level:** Beginner
- **tuitionFee:** 2500000
- **startDate:** 2026-05-10
- **description:** Khóa học nền tảng dành cho người mới bắt đầu, tập trung phát âm, từ vựng cơ bản, mẫu câu giao tiếp hằng ngày và phản xạ nghe nói đơn giản.
- **teacher:** Nguyễn Minh Anh
- **duration:** 2 tháng
- **studentCount:** 0
- **isFull:** false
- **status:** OPEN

### 3.2. Khóa học 2
- **id:** 2
- **courseCode:** ENG-COM-02
- **name:** English Communication
- **level:** Intermediate
- **tuitionFee:** 3200000
- **startDate:** 2026-05-15
- **description:** Khóa học giao tiếp giúp học viên luyện hội thoại theo chủ đề, cải thiện phản xạ nói và nâng cao khả năng sử dụng tiếng Anh trong học tập và công việc.
- **teacher:** Trần Thu Hà
- **duration:** 3 tháng
- **studentCount:** 18
- **isFull:** false
- **status:** OPEN

### 3.3. Khóa học 3
- **id:** 3
- **courseCode:** IELTS-55
- **name:** IELTS Target 5.5
- **level:** Intermediate
- **tuitionFee:** 4800000
- **startDate:** 2026-05-20
- **description:** Lộ trình học IELTS mục tiêu 5.5, tập trung củng cố ngữ pháp, từ vựng học thuật cơ bản và luyện đều 4 kỹ năng theo dạng đề thi.
- **teacher:** Lê Hoàng Nam
- **duration:** 3.5 tháng
- **studentCount:** 25
- **isFull:** true
- **status:** FULL

### 3.4. Khóa học 4
- **id:** 4
- **courseCode:** TOEIC-650
- **name:** TOEIC Intensive 650+
- **level:** Advanced
- **tuitionFee:** 4200000
- **startDate:** 2026-06-01
- **description:** Khóa luyện thi TOEIC hướng mục tiêu 650+, tập trung chiến lược làm bài, từ vựng thường gặp và kỹ năng xử lý câu hỏi nhanh, chính xác.
- **teacher:** Phạm Quỳnh Chi
- **duration:** 3 tháng
- **studentCount:** 20
- **isFull:** false
- **status:** OPEN

### 3.5. Khóa học 5
- **id:** 5
- **courseCode:** IELTS-65
- **name:** IELTS Master 6.5+
- **level:** Advanced
- **tuitionFee:** 5600000
- **startDate:** 2026-06-10
- **description:** Khóa học nâng cao dành cho học viên hướng đến IELTS 6.5+, tập trung kỹ năng viết học thuật, speaking phản biện và chiến lược tối ưu điểm số.
- **teacher:** Vũ Đức Long
- **duration:** 4 tháng
- **studentCount:** 30
- **isFull:** true
- **status:** FULL

---

## 4. Ý nghĩa của bộ dữ liệu mẫu đối với các chức năng

### Phục vụ chức năng danh sách
Có đủ 5 khóa học để hiển thị ra màn hình danh sách.

### Phục vụ chức năng lọc
Dữ liệu có đủ 3 mức trình độ:
- Beginner
- Intermediate
- Advanced

Dữ liệu cũng có nhiều mức học phí khác nhau để kiểm tra lọc theo `maxFee`.

### Phục vụ chức năng chi tiết
Mỗi khóa học đều có:
- tên khóa
- mô tả
- giảng viên
- thời lượng

nên có thể dùng để hiển thị đầy đủ trên trang chi tiết.

### Phục vụ chức năng hiển thị `HẾT CHỖ`
Có các khóa học:
- `IELTS-55`
- `IELTS-65`

với `isFull = true` để test điều kiện `th:if`.

### Phục vụ chức năng hủy khóa học
Có 2 kiểu dữ liệu:
- khóa học có `studentCount = 0` để test xóa thành công
- khóa học có `studentCount > 0` để test thông báo lỗi nghiệp vụ

---

## 5. Gợi ý dùng thống nhất trong nhóm
Khi các thành viên khác tạo repository hoặc service, nên giữ nguyên:
- tên thuộc tính
- giá trị mẫu
- courseCode
- trạng thái `isFull`
- trạng thái `status`

để toàn bộ project dùng chung một chuẩn dữ liệu, tránh lệch giữa backend và giao diện.