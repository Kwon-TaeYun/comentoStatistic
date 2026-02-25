# 📊 서비스 통계 분석 백엔드 시스템

---

## 📝 1. 프로젝트 설명

서비스 이용 현황 분석을 위한 **통계 전용 백엔드 시스템**입니다.  
로그인, 요청, 게시글 활동 데이터를 기반으로 다양한 조건에서 집계·분석할 수 있도록 설계했습니다.

---

## 🎯 2. 프로젝트 목적

- 기간(연/월/일) 기준 통계 집계
- 부서 및 사용자 기준 세부 통계 제공
- 서비스 이용 패턴 분석을 위한 데이터 구조 설계
- 정확한 집계를 위한 데이터 정합성 검증

---

## 🛠 3. 기술 스택

### 💻 Backend
- Java
- Spring Boot
- Spring MVC
- JPA
- MyBatis

### 🗄 Database
- MariaDB

### 🌐 API
- RESTful API

### 🧰 Tools
- IntelliJ IDEA
- DBeaver
- Git

---

## 4. ER 다이어그램
<img width="1052" height="693" alt="image" src="https://github.com/user-attachments/assets/4a06d59f-32b3-4cda-bd2b-5ff68199d7f3" />

---

## 5. API 문서

| **버전** | **변경일** | **변경 사유** | **변경 내역** |
| --- | --- | --- | --- |
| 1.0 | 2026-01-03 | 최초 작성 | 최초 작성 |
| 2.0 | 2026-01-16 | API 명세서 내용 추가 | 변경중 |

## 5-1. 1차 API 문서

### 📌 1. 접속자 수 조회

### 🔹 [GET] /comento/users - 접속자 수 조회

설명  
서비스에 접속한 사용자 수를 조회하는 API

요청 정보  
- Method: GET  
- URL: http://localhost/comento/users  
- Headers: 없음  
- Body: 없음  

응답 예시 (200 OK)  
{
  "connectedUserCount": 128
}

에러 응답  
- 500 INTERNAL_SERVER_ERROR : 서버 오류

---

### 📌 2. 부서 별 접속자 수 조회

### 🔹 [GET] /comento/users/{department_id} - 부서 별 접속자 수 조회

설명  
부서별로 해당 서비스에 접속한 사용자 수를 조회하는 API

요청 정보  
- Method: GET  
- URL: http://localhost/comento/users/{department_id}  
- Headers: 없음  

Path Variable  
- department_id (Integer, 필수): 부서 ID  

응답 예시 (200 OK)  
{
  "department": {
    "id": 3,
    "name": "Engineering"
  },
  "connectedUserCount": 27
}

에러 응답  
- 404 : 존재하지 않는 부서입니다.  
- 500 INTERNAL_SERVER_ERROR : 서버 내부 오류  

---

### 📌 3. 해당 날짜 로그인 요청 수 조회

### 🔹 [GET] /comento/logins/count?date={login_date}

설명  
특정 날짜의 로그인 요청 수를 조회하는 API

요청 정보  
- Method: GET  
- URL: http://localhost/comento/logins/count  
- Headers: 없음  

Query Parameter  
- date (String, YYYY-MM-DD, 필수): 조회 날짜  

응답 예시 (200 OK)  
{
  "date": "2026-01-03",
  "loginCount": 342
}

에러 응답  
- 400 : 날짜 형식이 올바르지 않습니다.  
- 500 INTERNAL_SERVER_ERROR : 서버 내부 오류  

---

### 📌 4. 전체 로그인 요청 수 조회

### 🔹 [GET] /comento/logins/count

설명  
전체 로그인 요청 수를 조회하는 API

요청 정보  
- Method: GET  
- URL: http://localhost/comento/logins/count  
- Headers: 없음  

응답 예시 (200 OK)  
{
  "loginCount": 342
}

에러 응답  
- 500 INTERNAL_SERVER_ERROR : 서버 내부 오류  

---

### 📌 5. 게시글 작성 수 조회

### 🔹 [GET] /comento/posts/count

설명  
게시글 작성 수를 조회하는 API

요청 정보  
- Method: GET  
- URL: http://localhost/comento/posts/count  
- Headers: 없음  

응답 예시 (200 OK)  
{
  "board": {
    "id": 3,
    "title": "자유게시판"
  },
  "postCount": 1
}

에러 응답  
- 500 INTERNAL_SERVER_ERROR : 서버 내부 오류  

---

## 작성 문서
- Word:: [API문서_코멘토_권태윤_260103.docx](https://github.com/user-attachments/files/24415496/API._._._260103.docx) 
- Notion: https://www.notion.so/API-2dd98cfebe1e80d68de2cbf9e0749274  

---
## 5-2. 2차 API 문서 (V2.0)

### 📌 1. 년도 별 접속자 수(로그인 수) 조회

### 🔹 [GET] `/api/v1/logins` - 년도 별 접속자 수(로그인 수) 조회

**설명**:

특정 년도의 서비스 접속자 수(로그인 수)를 조회하는 API

쿼리 파라미터로 “year”을 전달 받는다.

### ✅ 요청 정보

- **Method**: `GET`
- **URL**: `http://localhost:8031/api/v1/logins`
- **Headers**: 없음.
- **Query Parameter**

| 이름 | 값 | 설명 |
| --- | --- | --- |
| year | String | 조회할 년도(끝 2자리) |
- **Form Data**: 없음.

### 📥 응답 예시 (`200 OK`)

```json
{
  "success": true,
  "message": "22년 로그인 통계 조회 성공!",
  "data": {
    "year": "2022",
    "totCnt": 3
  }
}
```

### ❌ 에러 응답

| 코드 | 메시지 | 설명 |
| --- | --- | --- |
| 400 | year는 2자리 숫자여야 합니다. | year 파라미터 형식이 잘못된 경우 |
| 500 | INTERNAL_SERVER_ERROR | 서버 내부 오류 |
---

### 📌 2. 월별 접속자 수(로그인 수) 조회

### 🔹 [GET] `/api/v1/logins` - 월별 접속자 수(로그인 수) 조회

**설명**:

특정 월의 서비스 접속자 수(로그인 수)를 조회하는 API

쿼리 파라미터로 “year”과 “month”를 전달 받는다.

### ✅ 요청 정보

- **Method**: `GET`
- **URL**: `http://localhost:8031/api/v1/logins`
- **Headers**: 없음.
- **Query Parameter**

| 이름 | 값 | 설명 |
| --- | --- | --- |
| year | String | 조회할 년도(끝 2자리) |
| month | String  | 조회할 월 (01 ~ 12) |
- **Form Data**: 없음.

### 📥 응답 예시 (`200 OK`)

```json
{
  "success": true,
  "message": "24년 08월 로그인 통계 조회 성공!",
  "data": {
    "totCnt": 4,
    "year": "202408"
  }
}

```
### ❌ 에러 응답

| 코드 | 메시지 | 설명 |
| --- | --- | --- |
| 400 | `year 형식이 올바르지 않습니다.` | year 파라미터 형식이 잘못된 경우 |
| 400 | `month는 01~12 사이여야 합니다.` | month 파라미터 범위가 잘못된 경우 |
| 400 | `27년 08월의 로그인 데이터가 없습니다.` | 해당 년도, 월의 로그인 데이터가 없을 경우 |
| 500 | INTERNAL_SERVER_ERROR | 서버 내부 오류 |
---

### 📌 3. 일별 접속자 수(로그인 수) 조회

### 🔹 [GET] `/api/v1/logins` - 일별 접속자 수(로그인 수) 조회

**설명**:

특정 일의 서비스 접속자 수(로그인 수)를 조회하는 API

쿼리 파라미터로 “year”과 “month”, “day”를 전달 받는다.

### ✅ 요청 정보

- **Method**: `GET`
- **URL**: `http://localhost:8031/api/v1/logins`
- **Headers**: 없음.
- **Query Parameter**

| 이름 | 값 | 설명 |
| --- | --- | --- |
| year | String | 조회할 년도(끝 2자리) |
| month | String  | 조회할 월 (01 ~ 12) |
| day | String | 조회할 일 (01 ~ 31) |
- **Form Data**: 없음.

### 📥 응답 예시 (`200 OK`)

```json
{
  "success": true,
  "message": "24년 09월 04일 로그인 통계 조회 성공!",
  "data": {
    "yearMonthDay": "20240904",
    "totCnt": 1
  }
}

```

### ❌ 에러 응답

| 코드 | 메시지 | 설명 |
| --- | --- | --- |
| 400 | `year 형식이 올바르지 않습니다.` | year 파라미터 형식이 잘못된 경우 |
| 400 | `month는 01~12 사이여야 합니다.` | month 파라미터 범위가 잘못된 경우 |
| 400 | `day는 01~31 사이여야 합니다.` | day 파라미터 범위가 잘못된 경우 |
| 400 | `24년 09월 31일의 로그인 데이터가 없습니다.` | 해당 년도, 월, 일의 로그인 데이터가 없을 경우 |
| 500 | INTERNAL_SERVER_ERROR | 서버 내부 오류 |

---
### 📌 4. 전체 접속자 수(로그인 수) 조회

### 🔹 [GET] `/api/v1/logins` - 전체 접속자 수(로그인 수) 조회

**설명**:

전체 서비스 접속자 수(로그인 수)를 조회하는 API


### ✅ 요청 정보

- **Method**: `GET`
- **URL**: `http://localhost:8031/api/v1/logins`
- **Headers**: 없음.
- **Form Data**: 없음.

### 📥 응답 예시 (`200 OK`)

```json
{
  "success": true,
  "message": "전체 로그인 통계 조회 성공!",
  "data": {
    "totCnt": 14
  }
}

```
---

### 📌 5. 부서 별 접속자 수 조회

### 🔹 [GET] `/api/v1/logins/departments` - 부서 별 접속자 수 조회

**설명**:

부서 별로 해당 서비스에 접속한 수를 조회하는 API

### ✅ 요청 정보

- **Method**: `GET`
- **URL**: `http://localhost:8031/api/v1/logins/departments`
- **Headers**: 없음.
- **Query Parameter**

| 이름 | 값 | 설명 |
| --- | --- | --- |
| department | String | 부서 |
- **Form Data**: 없음.

### 📥 응답 예시 (`200 OK`)

```json
{
  "success": true,
  "message": "부서별 접속자 수 조회 성공",
  "data": {
    "department": "개발팀",
    "connectedUserCount": 2
  }
}

```
### ❌ 에러 응답

| 코드 | 메시지 | 설명 |
| --- | --- | --- |
| 400 | `존재하지 않는 부서입니다."` | 존재하지 않는 부서명 일 때 |
| 400 | `해당 부서의 접속자 수가 없습니다.` | 해당 부서의 접속자 수가 없을 때 |
| 500 | INTERNAL_SERVER_ERROR | 서버 내부 오류 |

---

### 📌 6. 부서 별 월 별 접속자 수 조회

### 🔹 [GET] `/api/v1/logins/departments` - 부서 별, 월 별 접속자 수 조회

**설명**:

부서 별 그리고 월 별로 해당 서비스에 접속한 수를 조회하는 API

### ✅ 요청 정보

- **Method**: `GET`
- **URL**: `http://localhost:8031/api/v1/logins/departments`
- **Headers**: 없음.
- **Query Parameter**

| 이름 | 값 | 설명 |
| --- | --- | --- |
| department | String | 부서 |
| year | String | 조회할 년도(끝 2자리) |
| month | String | 조회할 월 (01~12) |
- **Form Data**: 없음.

### 📥 응답 예시 (`200 OK`)

```json
{
  "success": true,
  "message": "24년 08월 개발팀 부서 로그인 통계 조회 성공",
  "data": {
    "department": "개발팀",
    "year": "24",
    "month": "08",
    "connectedUserCount": 1
  }
}

```
### ❌ 에러 응답

| 코드 | 메시지 | 설명 |
| --- | --- | --- |
| 400 | `존재하지 않는 부서입니다.` | 존재하지 않는 부서명 일 때 |
| 400 | `해당 부서의 접속자 수가 없습니다.` | 해당 년도/월에 대한 부서의 접속자 수가 없을 때 |
| 400 | `year는 2자리 숫자여야 합니다.` | year 파라미터 형식이 잘못된 경우 |
| 400 | `month는 01~12 사이여야 합니다.` | month 파라미터 형식이 잘못된 경우 |
| 500 | INTERNAL_SERVER_ERROR | 서버 내부 오류 |

---

### 📌 7. 평균 하루 접속자 수 조회

### 🔹 [GET] `/api/v1/logins/statistic/daily-average` - 평균 하루 접속자 수 조회

**설명**:

하루 해당 서비스에 접속한 수를 평균을 구해 보여주는 API

### ✅ 요청 정보

- **Method**: `GET`
- **URL**: `http://localhost:8031/api/v1/logins/statistic/daily-average`
- **Headers**: 없음.
- **Form Data**: 없음.

### 📥 응답 예시 (`200 OK`)

```java
{
  "success": true,
  "message": "일 평균 로그인 수 조회 성공",
  "data": {
    "averageDailyLoginCount": 1.08
  }
}
```

### ❌ 에러 응답

| 코드 | 메시지 | 설명 |
| --- | --- | --- |
| 500 | INTERNAL_SERVER_ERROR | 서버 내부 오류 |

---

### 📌 8. 휴일 제외 접속자 수 조회

### 🔹 [GET] `/api/v1/logins/statistic/exclude-holidays` - 휴일 제외 접속자 수 조회

휴일을 제외한 해당 서비스에 접속한 수를 보여주는 API

### ✅ 요청 정보

- **Method**: `GET`
- **URL**: `http://localhost:8031/api/v1/logins/statistic/exclude-holidays`
- **Headers**: 없음.
- **Form Data**: 없음.

### 📥 응답 예시 (`200 OK`)

```java
{
  "success": true,
  "message": "휴일 제외 로그인 수 조회 성공",
  "data": {
    "totCnt": 13
  }
}
```
### ❌ 에러 응답

| 코드 | 메시지 | 설명 |
| --- | --- | --- |
| 500 | INTERNAL_SERVER_ERROR | 서버 내부 오류 |

---

### 📌 9. 전체 로그인 요청 수 조회

### 🔹 [GET] `/api/v1/requests` - 전체 로그인 요청 수 조회

**설명**:

전체 로그인 요청 수를 조회하는 API

### ✅ 요청 정보

- **Method**: `GET`
- **URL**: `http://localhost:8031/api/v1/requests
- **Headers**: 없음.
- **Form Data**: 없음.

### 📥 응답 예시 (`200 OK`)
```json
{
  "success": true,
  "message": "전체 로그인 요청 수 조회 성공",
  "data": {
    "totCnt": 6
  }
}
```

### ❌ 에러 응답

| 코드 | 메시지 | 설명 |
| --- | --- | --- |
| 500 | INTERNAL_SERVER_ERROR | 서버 내부 오류 |

---

### 📌 10. 해당 날짜 로그인 요청 수 조회

### 🔹 [GET] `/api/v1/requests` - 해당 날짜 로그인 요청 수 조회

**설명**:

해당 날짜 로그인 요청 수를 조회하는 API


### ✅ 요청 정보

- **Method**: `GET`
- **URL**: `http://localhost/comento/logins/count?date={login_date}`
- **Headers**: 없음.
- **Form Data**: 없음.
- **Query Parameter:**

| 이름 | 값 | 설명 |
| --- | --- | --- |
| year | String | 조회할 년도(끝 2자리) |
| month | String  | 조회할 월 (01 ~ 12) |
| day | String | 조회할 일 (01 ~ 31) |


### 📥 응답 예시 (`200 OK`)

```json
{
  "success": true,
  "message": "24년 09월 01일 로그인 요청 수 조회 성공",
  "data": {
    "yearMonthDay": "240901",
    "totCnt": 2
  }
}
```

### ❌ 에러 응답

| 코드 | 메시지 | 설명 |
| --- | --- | --- |
| 400 | `year는 2자리(YY)여야 합니다.` | year 파라미터 형식이 잘못된 경우 |
| 400 | `month는 01~12 사이여야 합니다.` | month 파라미터 범위가 잘못된 경우 |
| 400 | `day는 01~31 사이여야 합니다.` | day 파라미터 범위가 잘못된 경우 |
| 400 | `year, month, day는 함께 전달되어야 합니다.` | 해당 년도, 월, 일이 한번에 전달하지 않은 경우 |
| 400 | `해당 날짜의 로그인 요청이 없습니다.` | 해당 년도, 월, 일의 로그인 데이터가 없을 경우 |
| 500 | INTERNAL_SERVER_ERROR | 서버 내부 오류 |

---

### 📌 11. 게시글 작성 수 조회

### 🔹 [GET] `/api/v1/boards` - 게시글 작성 수 조회

**설명**:

해당 사용자의 게시글 작성 수를 조회하는 API


### ✅ 요청 정보

- **Method**: `GET`
- **URL**: `http://localhost:8031/api/v1/boards`
- **Headers**: 없음.
- **Form Data**: 없음.
- **Query Parameter:**

| 이름 | 값 | 설명 |
| --- | --- | --- |
| userId | String | 조회할 사용자ID |


### 📥 응답 예시 (`200 OK`)

```json
{
  "userId": "AAA",
  "boardCount": 6,
  "boards": [
    {
      "id": 28,
      "title": "조직 개편"
    },
    {
      "id": 19,
      "title": "근태 공지"
    },
    {
      "id": 18,
      "title": "휴가 정책"
    },
    {
      "id": 13,
      "title": "채용 공고"
    },
    {
      "id": 12,
      "title": "인사 정책 변경"
    },
    {
      "id": 1,
      "title": "인사 공지"
    }
  ]
}

```

### ❌ 에러 응답

| 코드 | 메시지 | 설명 |
| --- | --- | --- |
| 400 | `해당 사용자가 작성한 게시글이 없습니다.` | 해당 사용자가 작성한 게시글이 없을 때 |
| 400 | `userId는 필수입니다.` | userId를 입력하지 않았을 때 |
| 500 | INTERNAL_SERVER_ERROR | 서버 내부 오류 |
---

### 작성 문서
- Notion: https://www.notion.so/API-2dd98cfebe1e800cb6aee4c130de4303?source=copy_link

---

## 📷 6. 실행 화면

### 📌 1. 년도별 접속자 수(로그인 수) 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/8c5e1a20-df1f-42bc-b879-fd64fc700537" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/4fa6fb89-8cfb-45f9-ba94-a2ad7b342ed5" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/487861cc-a6a5-4816-a783-ce39f594011b" />

### 📌 2. 월별 접속자 수(로그인 수) 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/d399eda7-745a-4f64-b7d6-bacb5b7b51ec" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/200f09ef-be48-4ff6-9393-d0d78f9213e8" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/38c92569-946c-49a8-9b02-5f4cf07c835c" />

### 📌 3. 일별 접속자 수(로그인 수) 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/07ebbb8c-1b68-411e-bb9f-fd3fd5670516" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/d85e7307-b2c6-4fe0-98ce-ff4c1be57fc4" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/b8748e49-3ac7-4e5e-9ca0-fb37bcf3df9f" />

### 📌 4. 전체 접속자 수(로그인 수) 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/4fb8d331-55c2-42e7-9164-437a8cb3f2de" />

### 📌 5. 부서별 접속자 수(로그인 수) 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/e6c467b6-57c9-4813-9103-dd2b4dc52436" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/d600a107-ace8-45ee-a340-86f9c8aed79c" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/2e2c3614-1933-43f6-8f40-073e7d282ac9" />

### 📌 6. 부서별 월 별 접속자 수(로그인 수) 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/28303df7-f1b1-4fc9-9d0e-61cd915042ee" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/23f3c193-1724-4561-ae98-f20f2dbab47e" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/e8204030-3c48-4750-9b62-8e518f34aacd" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/86ecabfa-49d6-4b3a-8fb2-6301b1b62902" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/18e0613d-e56e-47d2-998d-c7e7f144a4eb" />

### 📌 7. 평균 하루 접속자 수(로그인 수) 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/f2518bca-b7d5-4314-903f-8aa2bcaacae2" />

### 📌 8. 휴일 제외 접속자 수(로그인 수) 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/731a3fbc-32f9-4dc9-a44c-42f29175cf7a" />
<img width="496" height="440" alt="image" src="https://github.com/user-attachments/assets/db62696a-585f-4f7e-84fd-d19b3ace5986" />

### 📌 9. 전체 로그인 요청 수 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/97635a31-2d59-404f-a445-890682309ed2" />

### 📌 10. 해당 날짜 로그인 요청 수 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/13dcf3c2-debd-484d-9146-fa740b9e7790" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/f42c4da1-4627-45f2-be72-6800a14554a8" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/c2cfb946-774d-44fe-8d84-13e57ff36e35" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/338ecd3a-6434-4a6d-917d-8cd7e1ea9665" />

### 📌 11. 게시글 작성 수 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/cc38d398-6242-481b-a853-2adf4ef23861" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/13492e5e-3bc5-40c9-a729-b18b04c5f00d" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/61044259-4683-43e4-868c-0af5c387a00b" />

---
## 🧪 7. 테스트 전략
### 🧪 테스트
- JUnit 기반 서비스 레이어 테스트 작성
- 정상 케이스 / 예외 케이스 분리 검증
- Validation 로직 단위 테스트
<img width="1650" height="746" alt="image" src="https://github.com/user-attachments/assets/bcf3908d-5831-4be5-99fb-40946f0d06c2" />



---

## 🏗 8. 설계 의도 및 확장 과정

### 1️⃣ 통계 시스템을 별도 구조로 설계한 이유

단순 조회 API가 아닌,
서비스 이용 패턴을 분석하기 위한 통계 전용 백엔드 시스템으로 설계했습니다.

일반 CRUD와 분리하여 통계 로직을 독립시킴으로써,
추후 통계 항목이 추가되더라도 기존 서비스 로직에 영향을 주지 않도록 확장성을 고려했습니다.

---

### 2️⃣ V1 → V2 확장 배경

초기 버전(V1)은 단순 접속자 수 조회 기능만 제공했습니다.

그러나 실무 환경에서는
- 월별 트렌드 분석
- 특정 날짜 비교
- 부서 단위 성과 분석

과 같은 세부 통계 요구가 발생할 수 있다고 판단했습니다.

이에 따라 V2에서는
- 연/월/일 단위 필터링
- 부서 + 월 복합 조건 조회
- 평균/휴일 제외 통계 기능

을 추가하여 실무 활용성을 강화했습니다.

---

### 3️⃣ 데이터 정합성 보장 전략

통계 시스템에서 가장 중요한 요소는 **정확성**이라고 판단했습니다.

이를 위해 다음과 같은 방어 로직을 설계했습니다.

- year는 2자리 숫자(YY)만 허용
- month는 01~12 범위 검증
- day는 01~31 범위 검증
- year/month/day는 함께 전달되도록 강제
- 존재하지 않는 날짜 데이터 조회 시 명확한 예외 메시지 반환

단순 null 반환이 아닌,
의도된 예외 정책을 통해 잘못된 통계 요청을 사전에 차단하도록 설계했습니다.



