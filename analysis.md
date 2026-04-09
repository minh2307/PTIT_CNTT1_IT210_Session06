# PHÂN TÍCH NGHIỆP VỤ MINI PROJECT: EDU-PATH

## 1. Giới thiệu ngắn về bài toán
Dự án EDU-PATH là hệ thống quản lý thông tin các khóa học tiếng Anh.  
Mục tiêu chính là hỗ trợ nhân viên học vụ thực hiện các thao tác cơ bản trên khóa học như:
- xem danh sách khóa học
- lọc khóa học theo điều kiện
- xem chi tiết khóa học
- cập nhật một số thông tin khóa học
- hủy khóa học theo điều kiện nghiệp vụ

Phần việc của Người 1 là chuẩn hóa phần phân tích nghiệp vụ và dữ liệu nền để các thành viên khác trong nhóm có thể bám theo khi làm code.

---

## 2. Bóc tách yêu cầu chức năng từ SRS

### Chức năng 1: Thiết lập Layout chung
Hệ thống sử dụng một layout chính để toàn bộ các trang con kế thừa.

**Thành phần của layout:**
- Header: logo trung tâm và slogan
- Navbar:
  - Danh sách khóa học
  - Đăng ký tư vấn
- Content:
  - vùng `layout:fragment="content"` để nhúng nội dung riêng của từng trang

**Ý nghĩa:**
- giúp giao diện thống nhất
- tránh lặp lại header, navbar, footer ở nhiều file

**Các trang phải kế thừa layout:**
- trang danh sách khóa học
- trang chi tiết khóa học
- trang form chỉnh sửa khóa học

---

### Chức năng 2: Danh sách và lọc khóa học
Hệ thống hiển thị danh sách khóa học theo dạng bảng hoặc dạng lưới.

**Điều kiện lọc:**
- `level`: trình độ khóa học
  - Beginner
  - Intermediate
  - Advanced
- `maxFee`: học phí tối đa

**Yêu cầu xử lý:**
- Controller nhận dữ liệu bằng `@RequestParam`
- Nếu người dùng không nhập thì dùng giá trị mặc định
- Nếu không có kết quả phù hợp thì hiển thị thông báo:
  - `Hiện chưa có lớp học phù hợp với trình độ này`

**Yêu cầu hiển thị:**
- Học phí cần được format bằng `#numbers.formatDecimal`

---

### Chức năng 3: Xem chi tiết khóa học
Người dùng xem thông tin chi tiết của một khóa học qua mã khóa học.

**URL mẫu:**
- `/course/detail/{courseCode}`

**Cách nhận dữ liệu:**
- dùng `@PathVariable`

**Thông tin cần hiển thị:**
- tên khóa học
- mô tả lộ trình học
- giảng viên
- thời lượng

**Logic hiển thị bổ sung:**
- nếu `isFull = true` thì hiển thị nhãn:
  - `HẾT CHỖ`

---

### Chức năng 4: Cập nhật thông tin khóa học
Hệ thống có form chỉnh sửa để cập nhật thông tin của khóa học.

**Dữ liệu được phép sửa:**
- `tuitionFee`
- `startDate`

**Yêu cầu kỹ thuật:**
- form dùng `th:object`
- submit bằng `@PostMapping`
- sau khi lưu thành công phải chuyển hướng:
  - `redirect:/course/list`

**Lý do dùng redirect:**
- áp dụng PRG Pattern
- tránh gửi lại form khi người dùng nhấn F5

---

### Chức năng 5: Hủy khóa học
Người dùng có thể hủy khóa học theo điều kiện nghiệp vụ.

**Route xử lý:**
- `POST /course/delete/{id}`

**Điều kiện được hủy:**
- chỉ được hủy khi `studentCount = 0`

**Thông báo lỗi nếu không hợp lệ:**
- `Không thể hủy khóa học đã có học viên đăng ký`

**Kết quả mong muốn:**
- nếu hủy thành công: thông báo thành công sau redirect
- nếu không hủy được: hiển thị thông báo lỗi nghiệp vụ

---

## 3. Danh sách Use Case

### UC01 - Xem danh sách khóa học
**Mô tả:**  
Nhân viên học vụ truy cập màn hình danh sách để xem toàn bộ khóa học hiện có.

**Tác nhân:**  
Nhân viên học vụ

**Input:**  
Không bắt buộc

**Output:**  
Danh sách các khóa học được hiển thị trên giao diện

---

### UC02 - Lọc khóa học theo trình độ và học phí
**Mô tả:**  
Nhân viên học vụ lọc danh sách khóa học theo trình độ và mức học phí tối đa.

**Tác nhân:**  
Nhân viên học vụ

**Input:**
- level
- maxFee

**Output:**
- danh sách khóa học phù hợp  
  hoặc
- thông báo không có kết quả phù hợp

---

### UC03 - Xem chi tiết khóa học
**Mô tả:**  
Nhân viên học vụ xem thông tin chi tiết của một khóa học thông qua `courseCode`.

**Tác nhân:**  
Nhân viên học vụ

**Input:**
- courseCode

**Output:**
- tên khóa học
- mô tả khóa học
- giảng viên
- thời lượng
- trạng thái đầy chỗ nếu có

---

### UC04 - Cập nhật khóa học
**Mô tả:**  
Nhân viên học vụ cập nhật học phí và ngày khai giảng của khóa học.

**Tác nhân:**  
Nhân viên học vụ

**Input:**
- id
- tuitionFee
- startDate

**Output:**
- cập nhật thành công
- hệ thống chuyển về trang danh sách khóa học

---

### UC05 - Hủy khóa học
**Mô tả:**  
Nhân viên học vụ hủy một khóa học nếu khóa học đó chưa có học viên đăng ký.

**Tác nhân:**  
Nhân viên học vụ

**Input:**
- id

**Điều kiện nghiệp vụ:**
- chỉ được xóa khi `studentCount = 0`

**Output:**
- nếu hợp lệ: hủy thành công
- nếu không hợp lệ: báo lỗi không thể hủy khóa học

---

## 4. Thiết kế lớp Course

Lớp `Course` là đối tượng dữ liệu trung tâm của mini project.  
Tất cả các thành viên trong nhóm cần thống nhất dùng chung cấu trúc này để tránh lệch dữ liệu.

### Danh sách thuộc tính của lớp Course

| STT | Tên thuộc tính | Ý nghĩa |
|-----|----------------|--------|
| 1 | id | Mã định danh nội bộ của khóa học |
| 2 | courseCode | Mã khóa học duy nhất, dùng để tra cứu và hiển thị trên URL |
| 3 | name | Tên khóa học |
| 4 | level | Trình độ khóa học |
| 5 | tuitionFee | Học phí |
| 6 | startDate | Ngày khai giảng |
| 7 | description | Mô tả lộ trình học |
| 8 | teacher | Tên giảng viên |
| 9 | duration | Thời lượng khóa học |
| 10 | studentCount | Số học viên đã đăng ký |
| 11 | isFull | Trạng thái khóa học đã đầy chỗ hay chưa |
| 12 | status | Trạng thái hiện tại của khóa học |

---

## 5. Quy ước dữ liệu thống nhất cho cả nhóm

### 5.1. Quy ước cho `level`
Chỉ sử dụng đúng 3 giá trị:
- `Beginner`
- `Intermediate`
- `Advanced`

### 5.2. Quy ước cho `status`
Đề xuất thống nhất 3 trạng thái:
- `OPEN` : khóa học đang mở đăng ký
- `FULL` : khóa học đã đủ chỗ
- `CANCELLED` : khóa học đã bị hủy

### 5.3. Quy ước cho `courseCode`
- ngắn gọn
- dễ đọc
- không trùng nhau
- có thể dùng trực tiếp trên URL

Ví dụ:
- `ENG-BAS-01`
- `IELTS-55`
- `TOEIC-650`

### 5.4. Quy ước cho `isFull`
- `true`: khóa học đã đủ học viên
- `false`: khóa học vẫn còn chỗ

### 5.5. Quy ước nghiệp vụ liên quan
- nếu `studentCount > 0` thì không được hủy khóa học
- nếu `isFull = true` thì trang chi tiết phải hiển thị nhãn `HẾT CHỖ`

---

## 6. Vai trò của bộ mock data
Bộ mock data được chuẩn hóa để cả nhóm dùng chung trong quá trình làm project.

**Mục đích sử dụng:**
- test chức năng danh sách khóa học
- test lọc theo `level`
- test lọc theo `maxFee`
- test chi tiết khóa học
- test hiển thị trạng thái `HẾT CHỖ`
- test nghiệp vụ xóa khóa học khi `studentCount > 0`

Bộ dữ liệu này được ghi chi tiết trong file `MOCK-DATA.md`.

---

## 7. Kết luận
Phần việc của Người 1 đã hoàn thành các nội dung chính sau:
- phân tích ngắn gọn các chức năng từ SRS
- viết danh sách use case
- chuẩn hóa cấu trúc lớp `Course`
- chuẩn hóa bộ mock data chung cho cả nhóm

Đây là cơ sở để các thành viên khác tiếp tục triển khai repository, service, controller và giao diện mà không bị lệch yêu cầu hoặc lệch cấu trúc dữ liệu.