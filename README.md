# 🚌 Bus Ticket Booking System (Full-Stack)

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.1-brightgreen)](https://spring.io/projects/spring-boot)
[![React](https://img.shields.io/badge/React-Vite-61DAFB)](https://reactjs.org/)
[![Vite](https://img.shields.io/badge/Vite-latest-646CFF)](https://vitejs.dev/)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1)](https://www.mysql.com/)
[![JWT](https://img.shields.io/badge/JWT-RS256-000000)](https://jwt.io/)

Một hệ thống quản lý và đặt vé xe khách hiện đại, được xây dựng với kiến trúc Microservices-ready, tập trung vào hiệu năng, bảo mật và trải nghiệm người dùng. Dự án bao gồm hệ thống Backend mạnh mẽ và hai giao diện Frontend riêng biệt cho Khách hàng và Quản trị viên.

---

## 🌟 Tính Năng Nổi Bật (Highlights)

Dự án này vượt xa các tính năng CRUD cơ bản bằng cách tích hợp các giải pháp thực tế:

-   **Hệ Thống Đặt Vé Thông Minh & Concurrency Control**: Sử dụng `Pessimistic Locking` để đảm bảo không bao giờ xảy ra tình trạng đặt trùng ghế (double booking) trong môi trường đa người dùng.
-   **Tích Hợp Vận Chuyển Hàng Hóa (Cargo Management)**: Cho phép khách hàng gửi kèm hàng hóa khi đặt vé, tự động tính toán khối lượng và chi phí tích hợp vào hóa đơn.
-   **Chương Trình Khách Hàng Thân Thiết (Loyalty Points)**: Hệ thống tự động tích lũy điểm thưởng dựa trên giá trị hóa đơn (0.5%) và cho phép dùng điểm để giảm giá trực tiếp cho các lần đặt tiếp theo.
-   **Hệ Thống Thông Báo Đa Kênh**: 
    -   Tự động gửi **Email xác nhận** ngay khi đặt vé thành công hoặc hoàn tiền.
    -   Tích hợp **Twilio SMS** cho các thông báo khẩn cấp.
    -   Thông báo nội bộ (In-app notifications) với tính năng Soft-delete và đánh dấu đã đọc.
-   **Bảo Mật Nâng Cao**: Triển khai **Spring Security** với **JWT (RS256/HS256)**, hỗ trợ phân quyền chi tiết (RBAC), Logout/Revoke token và bảo vệ các Endpoint nhạy cảm.
-   **Báo Cáo & Thống Kê (Reporting)**: Hệ thống sinh báo cáo doanh thu, sản lượng và hiệu suất chuyến đi cho nhà quản lý.
-   **Tối Ưu Hiệu Năng**: Sử dụng `@Cacheable` (Spring Cache) để tăng tốc độ truy vấn cho các dữ liệu ít thay đổi như danh sách chuyến đi, địa điểm.

---

## 🛠 Công Nghệ Sử Dụng (Tech Stack)

### **Backend**
-   **Framework**: Spring Boot 3.4.1 (Java 17)
-   **Data Access**: Spring Data JPA (Hibernate)
-   **Database**: MySQL 8.0
-   **Security**: Spring Security, JWT (JJWT)
-   **Messaging/Communication**: Spring Mail, Twilio SMS API
-   **API Documentation**: Swagger/OpenAPI (SpringDoc)
-   **Real-time & Tasks**: Spring WebSocket, Spring Task Scheduling (Cron jobs)
-   **Build Tool**: Maven

### **Frontend**
-   **Library**: React.js (Vite)
-   **Styling**: CSS Modern (Responsive Design)
-   **State Management**: Context API / Hooks
-   **HTTP Client**: Axios

---

## 📊 Mô Hình Dữ Liệu (Database Schema)

Hệ thống được thiết kế với hơn 15 bảng quan hệ chặt chẽ:

-   **Identity & Users**: `User`, `Role`, `UserPermission`, `Token`.
-   **Core Booking**: `Booking`, `BookingCargo`, `Cargo`, `Discount`, `PaymentHistory`.
-   **Operations**: `Trip`, `Coach` (Nhà xe), `Driver`, `TripLog`.
-   **Geography**: `Province`, `Location` (Điểm đón/trả).
-   **Engagement**: `Review`, `LoyaltyTransaction`, `Notification`, `UserNotification`.

---

## 🚀 Hướng Dẫn Cài Đặt (Setup)

### **Yêu cầu hệ thống**
-   JDK 17 trở lên.
-   Node.js (LTS).
-   MySQL Server.

### **Các bước thực hiện**
1.  **Clone dự án**:
    ```bash
    git clone https://github.com/HungThichCodee/BusTicketBooking.git
    ```
2.  **Cấu hình Backend**:
    -   Tạo database MySQL tên `BusTicketBooking`.
    -   Copy `BusTicketBookingSystem/src/main/resources/application.properties.example` thành `application.properties`.
    -   Cập nhật thông tin Database và Gmail App Password của bạn.
3.  **Chạy Backend**:
    ```bash
    cd BusTicketBookingSystem
    ./mvnw spring-boot:run
    ```
4.  **Chạy Frontend**:
    -   Mở 2 terminal mới cho Admin và Customer:
    ```bash
    cd busticketbookingsystem_FE/BusTicketBooking-Admin-main
    npm install && npm run dev
    
    cd ../BusTicketBooking-Customer-main
    npm install && npm run dev
    ```

---

## 👨‍💻 Tác Giả và những người bạn
**HungThichCodee**
-   Email: danhcaolamhung9122004@gmail.com
-   LinkedIn: [Your LinkedIn Profile]

---
*Dự án này được xây dựng với mục tiêu cung cấp giải pháp chuyển đổi số toàn diện cho ngành vận tải hành khách.*