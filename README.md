# 프로젝트 : DaEut
![logo_w (1)](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/927fa3b1-b3c3-4378-a5d9-838d4db9d9db)
<br>
(시연 영상 링크)

## 목차
**1. 프로젝트 개요**
<br>
- 프로젝트 주제
- 주제 선정 배경
- 기획 의도
- 활용방안 및 기대효과
      
**2. 프로젝트 구조**
<br>
- 주요 기능
- Menu Structure
- Project Structure
- Flow Chart
    
**3. 프로젝트 팀 구성 및 역할**
<br>

**4. 프로젝트 수행절차 및 방법**
<br>
- 수행 절차
- 수행 방법 
    
**5. 프로젝트 수행 경과**
<br>
- 요구사항 정의서
- 기능 정의서
- ERD
-  테이블 정의서
-  화면 설계서
- 프로젝트 실제 화면 UI
  
**6. 핵심기능 코드 리뷰**
<br>
- 기능 목표
- 실시간 채팅 구현 과정
- 개선할 점
     
**7. 자체 평가 의견**
<br>
- 개별 평가
- 종합 평가

# 1. 프로젝트 개요
## 1-1. 프로젝트 주제
- 1인 가구를 위한 종합 서비스 플랫폼
## 1-2. 주제 선정 배경
- 증가하는 1인 가구와 그에 따른 1인 가구를 위한 서비스의 수요 증가.
- 외부 활동과 집을 가꾸는 일을 전부 혼자 부담해야 하는 1인 가구를 위한 서비스를 제공.
- 따라서 청소 외의 방역, 빨래, 보안 등 1인 가구에게 필요한 서비스를 결합한 맞춤형 통합 플랫폼을 기획.
## 1-3. 기획 의도
- 청소 및 생활 서비스와 더불어 팁 게시판을 제공하여 사용자의 생활 품질을 향상시키고자 함.
- 현재 존재하는 청소 서비스와 차별점을 두기 위해 다양한 패키지 옵션과 팁 게시판 기능을 구현하여 활용도와 사용자의 만족도를 충족.
- 관리자에게는 효율적인 서비스 관리를 통해 서비스 품질을 높일 수 있도록 보조.
- 이를 통해 사용자는 더 나은 생활을 유지할 수 있으며, 플랫폼은 신뢰성과 지속성을 확보 가능.

# 2. 프로젝트 구조

# 3. 프로젝트 팀 구성 및 역할
## 팀원
- 인원 : 5명
- 반예진
    - 팁 게시판 구현 / 게시판 페이지 디자인
    - 게시판 기능 (등록 / 수정 / 삭제 / 목록 / 추천 / 조회수 / 댓글)
- 윤준호
    - 유저 페이지, 사이드 바, ERD 설계 / 유저 전체 페이지 디자인 및 구현 (정보 변경, 예약 조회, 리뷰 작성, 파트너 신청)
    - 유저 및 파트너 사이드 바 구현
    - 전체 DB 설계 및 테이블 정의서 작성
- 이종식
    - 메인 페이지, 예약, 결제, 장바구니 디자인 구성
    - 예약 게시글 목록, 등록, 수정, 삭제 구현
    - 장바구니 목록, 등록, 삭제 구현
    - 결제 및 예약 서비스 구현
    - 환불 처리 및 환불 승인 처리 구현
    - 채팅방 및 채팅 기능 구현
- 정다운
    - 로그인 기능(Security5를 통한 기능 구현 & 카카오 소셜 로그인 기능 구현), 이메일 인증, 관리자 페이지
    - 로그인, 회원가입, 관리자 페이지 디자인
    - 기존 팁 게시판에 관리자 권한을 부여하여 관리
    - 관리자의 회원, 파트너, 예약 관리 (목록 / 조회 / 수정 / 삭제)
    - 구글 이메일 인증을 통해 비밀번호 찾기 기능 구현 
- 황다정
    - 파트너 페이지의 정보 조회 수정, 리뷰 및 자신의 예약 보기 구현
    - Full Calendar API를 이용해 예약 게시글의 캘린더
    - 예약 세부 페이지의 세부 사항 구현(별점 및 리뷰 시스템 구현)
    - 채팅, 예약 게시글 목록, 예약 게시글 세부 페이지, 에러 페이지 디자인

# 4. 프로젝트 수행절차 및 방법
## 4-2. 수행방법
- 사용 언어 : <img src="https://camo.githubusercontent.com/e11bf98e7a9c4795e17eaede4499d4520ed924d9a0f3162a0b10820350b405fb/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6a6176612d3030373339363f7374796c653d666c6174266c6f676f3d6a617661266c6f676f436f6c6f723d7768697465" data-canonical-src="https://img.shields.io/badge/java-007396?style=flat&amp;logo=java&amp;logoColor=white" style="max-width: 100%;">
- 개발도구 : <img src="https://camo.githubusercontent.com/d625623d4b2669fff64435f7cfb76bc89822c7dbfa3cf869debf603df09457cd/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f76697375616c73747564696f636f64652d3030374143433f7374796c653d666c6174266c6f676f3d76697375616c73747564696f636f6465266c6f676f436f6c6f723d7768697465" data-canonical-src="https://img.shields.io/badge/visualstudiocode-007ACC?style=flat&amp;logo=visualstudiocode&amp;logoColor=white" style="max-width: 100%;">  
- 라이브러리 : 
- 사용 DB : 
- 참조 API : 
- 협업 Tools : <img src="https://camo.githubusercontent.com/cafe322517fa3cf031631e2e8b06992124186216aee8a1a8cc3aad086bcc6c1e/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f7472656c6c6f2d3030353243433f7374796c653d666c6174266c6f676f3d7472656c6c6f266c6f676f436f6c6f723d7768697465" data-canonical-src="https://img.shields.io/badge/trello-0052CC?style=flat&amp;logo=trello&amp;logoColor=white" style="max-width: 100%;"> <img src="https://camo.githubusercontent.com/18129633ca4fdac8b4cd138bca0bc454bb8d17637c4d186158773604a0dfedae/68747470733a2f2f696d672e736869656c64732e696f2f62616467652f6769746875622d3138313731373f7374796c653d666c6174266c6f676f3d676974687562266c6f676f436f6c6f723d7768697465" data-canonical-src="https://img.shields.io/badge/github-181717?style=flat&amp;logo=github&amp;logoColor=white" style="max-width: 100%;">
  
# 5. 프로젝트 수행 경과
## 5-1. 요구사항 정의서
<details>
    <summary>🧊요구사항 정의서</summary>

![요구사항정의서](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/a3fbe5a1-e714-48f1-9be0-5403b7d86da2)

</details>

## 5-2. 기능 정의서
<details>
    <summary>🧊기능 정의서</summary>

![기능정의서1](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/ec5b18fd-0cca-4b2a-a7de-6ed16b23eebf)
![기능정의서2](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/e143306b-da35-4760-affc-b6c81b7abff2)
![기능정의서3](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/ca51b062-97c3-4e45-828f-69f82c988bac)
![기능정의서4](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/96597457-bd5d-4d24-8210-ed9044299409)

</details>

## 5-3. ERD
<details>
    <summary>🧊ERD</summary>
      
![ERD](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/fd51df14-9a63-4f8e-ac67-ce2d318c5397)

</details>

## 5-4. 테이블 정의서
<details>
    <summary>🧊테이블 정의서</summary>

![테이블정의서1](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/eef4772e-d57c-480f-a02d-bda8aa960432)
![테이블정의서2](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/58f48755-6f59-4552-92d5-e32cd2f34b2d)
![테이블정의서3](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/106d60af-d743-4801-be90-906f5c6806b3)
![테이블정의서4](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/c1a9e28b-1728-45fa-aa97-7d2e0ba40a04)
![테이블정의서5](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/70cbd362-cddb-4ff9-aaeb-b5a793be32dc)
![테이블정의서6](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/2bc0ac02-79bc-4e52-958a-a0b8dcf23fef)
![테이블정의서7](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/c862e741-ade5-4737-81a0-fa21b2302ce6)
![테이블정의서8](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/62bacddd-82a1-4ef9-b41c-3892c27a7cc6)
![테이블정의서9](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/da3e9d6e-41c5-467c-848b-490f65bc5d06)
![테이블정의서10](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/2f247665-5f20-4ab2-829c-9cb1a85e5308)
![테이블정의서11](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/57e929d6-bb40-442c-8731-cc78eb9332a4)
![테이블정의서12](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/568bb83e-589e-4416-9f98-02f5eb7c9734)
![테이블정의서13](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/cd3471d7-652b-4110-af5c-116de87d9b43)
![테이블정의서14](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/b0cea7bc-4e6e-4287-a1cf-fb0f0f40d90c)
![테이블정의서15](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/5df47404-f4ef-4476-b58b-76f083159b2c)
![테이블정의서16](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/de409ace-efc5-450e-91a3-13a2ff6d6ec7)
![테이블정의서17](https://github.com/JongsikLEE01/MSA5_MainProject/assets/160221884/ff533ac0-d700-4b83-a807-48ef43d5193c)


</details>

## 5-5. 화면 설계서
<details>
    <summary>🧊화면 설계서</summary>



</details>

## 5-6. 실제 화면
<details>
    <summary>🧊실제 화면</summary>



</details>

# 6. 핵심기능 코드 리뷰

# 7. 자체 평가 의견
## 7-1. 개별 평가
- 반예진
    - 화면 설계 단계의 중요성을 크게 느꼈으며 제가 구현할 기능에서 쓰이는 게 무엇인지 정확히 알고 적용하는 게 중요하다고 느꼈습니다. 평소에 배운 것을 응용하는 부분에서 어려움이 많이 있었는데 이번 프로젝트를 계기로 응용하는 방법에 대해 조금 더 배우는 시간이 되었습니다.
- 윤준호
    - 중간에 DB를 바꿀 일이 많아서 기능 구현에 어려움이 많았고, 시간이 부족하여 뺀 기능도 많아서 아쉬웠습니다. 다음부터는 예시로 쓸 페이지를 참고하여, 미리 DB가 쓰이는 부분을 체크하고 작성하는 것이 좋을 것 같습니다. 또한 Spring Security를 사용하여 작성하며 CRUD 구조와 MVC 패턴에 대해 더 자세히 알게 된 것 같습니다.
- 이종식
    - 여러 api를 이용해서 기능을 구현하는 것이  재미있었고 portone을 이용해서 주문과 결제를 구현하는 것과 WebSocket을 사용해서 실시간 채팅을 구현하는 것이 가장 기억에 남았습니다. 기술적인 어려운 부분도 많았고 기간 내에 원하던 기능을 모두 구현하지 못해 아쉬운 부분도 있었지만 이런 과정들 속에서 네트워크와 WebSocket에 대해서 더 공부를 하게 되고 기간 내에 끝낼 수 있는 능력을 기를 수 있다고 생각합니다.
- 정다운
    - 사용자가 파트너로 등록되기 위해서는 단순히 권한을 부여하는 것이 아니라 사용자가 파트너 신청을 하고, 관리자가 이를 승인함으로써 파트너로 등록되는 시스템을 구현하는 것이었습니다. 이러한 방식은 조금 복잡할 수 있지만, 테스트를 통해 구현되는 과정을 보며 즐거웠습니다. 초기에는 각자가 구현한 부분을 소통 없이 통합하다 보니 문제가 생기기도 했지만, 서로의 피드백을 주고 받으며 소통의 중요성을 깨달았고, 시간이 지날수록 이에 적응해 나갔습니다. 처음에는 기능을 구현하는 것에 대한 염려도 있었지만, 반복하면서 점점 자신감을 갖게 되었습니다. 또한, 소셜 로그인을 완벽하게 구현하지 못해 아쉬웠고 개발하는데 시간 분배의 중요성도 알게 되었습니다. 
- 황다정
    - 래퍼런스와 사이트들을 보며 프로젝트의 방향을 설계하고 페이지를 구성하는 일이 즐거웠습니다. 캘린더 기능이 쉽게 되지 않아 생각보다 오래 붙잡고 있었던 부분이 아쉽습니다. Spring을 사용한 프로젝트를 통해 많은 공부를 하게 되었습니다. 또한 예약 세부 페이지 구현 시 날짜를 클릭하면 캘린더가 새롭게 뜨는 스크립트와 CSS 구현을 하지 못한 부분이 아쉬웠습니다. 다음 기회에 부족한 부분을 채우고 더 정진하여 팀 프로젝트에 도움이 되고 싶습니다.
  
## 7-2. 팀 평가
### 한계점
- 서비스 예약, 실시간 채팅, 게시판과 같은 필수 기능은 모두 구현하였으나 유저의 내가 좋아하는 게시글을 모아 볼 수 있는 옵션 기능을 구현하지 못하였다.소셜 로그인 기능을 자세히 구현하지 못해 팁게시판 댓글 작성을 하지 못하고 파트너 신청이 불가하는 등 여러 제약이 걸렸다.
### 개선점
- static과 같은 공통적으로 사용하는 파일 및코드와 팀원들이 개별적으로 사용하는 파일을 제대로 분리하지 않아 시간이 필요했지만, 적절한 관리를 통해서 모두 같은 개발 환경에서 프로젝트를 진행하도록 한다.
### 문제 해결 방법
- 프로젝트를 설계할 때, 시간이 오래 걸려도 프로젝트 기간을 생각해 목표를 철저히 세우고 중간에 변경이 될 수 있는 부분을 최소화해야 한다고 생각하며, 틈틈이 깃허브를 통해 파일을 합치고 팀원과 소통을 원활히 할 수 있도록 하여 오류를 줄인다. 또한, 기능 구현을 위한 시간 및 역할 분배를 잘 하여 원하는 기능을 최대한 할 수 있도록 한다.


## 버전
- MySQL
- Java 17
- SpringBoot 3.x.x




