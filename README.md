# Algorithm Testing

## Mô tả

Bài tập này bao gồm các thuật toán cơ bản về đồ thị, tìm kiếm, sắp xếp và chuỗi. Mục tiêu của bài tập là cài đặt các thuật toán này và viết các bài kiểm thử để đảm bảo chúng hoạt động chính xác trong nhiều tình huống khác nhau.

---

## Các phần của dự án

### 1. **Graph (Đồ thị)**

- **Dijkstra Algorithm**: Thuật toán Dijkstra tìm đường đi ngắn nhất từ một đỉnh đến tất cả các đỉnh còn lại trong đồ thị có trọng số không âm.
    - Thuật toán này yêu cầu đồ thị là một biểu diễn của các đỉnh và cạnh, với mỗi cạnh có một trọng số không âm.
    - Kiểm thử cho các tình huống như đồ thị rỗng, đồ thị có trọng số âm, và đồ thị không có đường đi đến đỉnh đích.

### 2. **Search (Tìm kiếm)**

- **Binary Search**: Thuật toán tìm kiếm nhị phân thực hiện tìm kiếm một phần tử trong một mảng đã được sắp xếp.
    - Tìm kiếm nhị phân cắt đôi mảng mỗi lần tìm kiếm, giúp tối ưu thời gian tìm kiếm.
    - Kiểm thử bao gồm các tình huống như tìm kiếm trong mảng rỗng, tìm kiếm một phần tử tại các vị trí đầu, giữa và cuối, cũng như khi phần tử không có trong mảng.

### 3. **Sorting (Sắp xếp)**

- **Quick Sort**: Thuật toán QuickSort sử dụng phương pháp phân chia và trị để sắp xếp mảng.
    - Thuật toán này chọn một phần tử làm pivot và chia mảng thành hai phần sao cho các phần tử nhỏ hơn pivot ở bên trái và các phần tử lớn hơn pivot ở bên phải. Sau đó, tiếp tục sắp xếp các phần tử trong các phần con.
    - Kiểm thử các tình huống như mảng rỗng, mảng có một phần tử, mảng giảm dần, mảng có các phần tử trùng lặp và mảng lớn.

### 4. **StringUtils (Tiện ích chuỗi)**

- **isPalindrome**: Hàm kiểm tra xem một chuỗi có phải là đối xứng (palindrome) hay không.
    - Một chuỗi đối xứng là chuỗi đọc từ trái sang phải giống như khi đọc từ phải sang trái.
    - Kiểm thử các tình huống như chuỗi rỗng, chuỗi một ký tự, chuỗi đối xứng, chuỗi không đối xứng.

---

**Kết quả**

![image](https://github.com/user-attachments/assets/ecbb1d10-1ee1-471b-8428-41c160ac265d)

Do chưa xử lý các đỉnh không có kết nối (không được thăm) trong thuật toán dijkstra.

**Độ coverage:**

![image](https://github.com/user-attachments/assets/333ed508-3851-4443-aeee-207a8669a786)

---

**Tham khảo**

[Chat GPT](https://chatgpt.com/share/6782abda-ef78-8005-9a5e-2c3489ecb672)


