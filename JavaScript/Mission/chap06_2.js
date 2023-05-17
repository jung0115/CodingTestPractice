/*
사용자 정보를 저장하는 User 클래스를 작성
- 사용자의 이름(name), 이메일(email), 연락처(phone)를 멤버 변수로 가짐
- 생성자와 정보를 출력하는 printInfo() 메서드를 작성
*/

// 사용자의 정보를 저장하는 User 클래스
class User {
  // 사용자의 이름, 이메일, 연락처를 멤버 변수로
  // 생성자
  constructor(name, email, phone) {
    this.name = name;
    this.email = email;
    this.phone = phone;
  }

  // 정보를 출력하는 printInfo() 메서드
  printInfo() {
    console.log("이름: " + this.name);
    console.log("이메일: " + this.email);
    console.log("연락처: " + this.phone);
  }
}

const sally = new User("샐리", "jung1234@test.com", "010-9999-9999");
sally.printInfo();