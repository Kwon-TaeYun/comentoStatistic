| **버전** | **변경일** | **변경 사유** | **변경 내역** |
| --- | --- | --- | --- |
| 1.0 | 2026-01-03 | 최초 작성 | 최초 작성 |
| 2.0 | 2026-01-16 | API 명세서 내용 추가 | 변경중 |

# 1. 2차 API 문서 (V2.0)

## 📌 1. 년도 별 접속자 수(로그인 수) 조회

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

## 📌 2. 월별 접속자 수(로그인 수) 조회

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

## 📌 3. 일별 접속자 수(로그인 수) 조회

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

## 📌 4. 전체 접속자 수(로그인 수) 조회

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

## 📌 5. 부서 별 접속자 수 조회

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

## 📌 6. 부서 별 월 별 접속자 수 조회

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

## 📌 7. 평균 하루 접속자 수 조회

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

## 📌 8. 휴일 제외 접속자 수 조회

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

## 📌 9. 전체 로그인 요청 수 조회

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

## 📌 10. 해당 날짜 로그인 요청 수 조회

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

## 📌 11. 게시글 작성 수 조회

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

## 작성 문서
- Notion: https://www.notion.so/API-2dd98cfebe1e800cb6aee4c130de4303?source=copy_link

---

# 2. 실행 화면

## 📌 1. 년도별 접속자 수(로그인 수) 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/8c5e1a20-df1f-42bc-b879-fd64fc700537" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/4fa6fb89-8cfb-45f9-ba94-a2ad7b342ed5" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/487861cc-a6a5-4816-a783-ce39f594011b" />

## 📌 2. 월별 접속자 수(로그인 수) 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/d399eda7-745a-4f64-b7d6-bacb5b7b51ec" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/200f09ef-be48-4ff6-9393-d0d78f9213e8" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/38c92569-946c-49a8-9b02-5f4cf07c835c" />

## 📌 3. 일별 접속자 수(로그인 수) 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/07ebbb8c-1b68-411e-bb9f-fd3fd5670516" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/d85e7307-b2c6-4fe0-98ce-ff4c1be57fc4" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/b8748e49-3ac7-4e5e-9ca0-fb37bcf3df9f" />

## 📌 4. 전체 접속자 수(로그인 수) 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/4fb8d331-55c2-42e7-9164-437a8cb3f2de" />

## 📌 5. 부서별 접속자 수(로그인 수) 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/e6c467b6-57c9-4813-9103-dd2b4dc52436" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/d600a107-ace8-45ee-a340-86f9c8aed79c" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/2e2c3614-1933-43f6-8f40-073e7d282ac9" />

## 📌 6. 부서별 월 별 접속자 수(로그인 수) 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/28303df7-f1b1-4fc9-9d0e-61cd915042ee" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/23f3c193-1724-4561-ae98-f20f2dbab47e" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/e8204030-3c48-4750-9b62-8e518f34aacd" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/86ecabfa-49d6-4b3a-8fb2-6301b1b62902" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/18e0613d-e56e-47d2-998d-c7e7f144a4eb" />

## 📌 7. 평균 하루 접속자 수(로그인 수) 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/f2518bca-b7d5-4314-903f-8aa2bcaacae2" />

## 📌 8. 휴일 제외 접속자 수(로그인 수) 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/731a3fbc-32f9-4dc9-a44c-42f29175cf7a" />
<img width="496" height="440" alt="image" src="https://github.com/user-attachments/assets/db62696a-585f-4f7e-84fd-d19b3ace5986" />

## 📌 9. 전체 로그인 요청 수 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/97635a31-2d59-404f-a445-890682309ed2" />

## 📌 10. 해당 날짜 로그인 요청 수 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/13dcf3c2-debd-484d-9146-fa740b9e7790" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/f42c4da1-4627-45f2-be72-6800a14554a8" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/c2cfb946-774d-44fe-8d84-13e57ff36e35" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/338ecd3a-6434-4a6d-917d-8cd7e1ea9665" />

## 📌 11. 게시글 작성 수 조회
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/cc38d398-6242-481b-a853-2adf4ef23861" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/13492e5e-3bc5-40c9-a729-b18b04c5f00d" />
<img width="637" height="511" alt="image" src="https://github.com/user-attachments/assets/61044259-4683-43e4-868c-0af5c387a00b" />

---


# 3. REST API

## 3-1. HTTP 통신이란?

HTTP(HyperText Transfer Protocol)는 클라이언트(브라우저, 앱)가 서버(웹 서버, API 서버)에 요청(Request)을 보내고 응답(Response)을 받기 위한 통신 규칙(프로토콜)이다.

HTTP 통신 구조  
HTTP는 요청(Request) → 응답(Response) 구조로 동작한다.

요청(Request) 구성 요소  
- 메서드 (GET, POST 등)  
- URL  
- Header  
- Body (선택)  

응답(Response) 구성 요소  
- 상태 코드  
- Header  
- Body  

HTTP 특징  
- 무상태성(Stateless): 서버는 이전 요청을 기억하지 않음 (쿠키, 세션, JWT로 보완)  
- 비연결성(Connectionless): 요청/응답 후 연결 종료 (HTTP/1.1 Keep-Alive)  
- 텍스트 기반 통신(JSON, HTML 등)  

HTTP 메서드  
- GET: 조회  
- POST: 생성  
- PUT: 전체 수정  
- PATCH: 일부 수정  
- DELETE: 삭제  

HTTP 상태 코드  
- 200 성공  
- 201 생성 성공  
- 400 잘못된 요청  
- 401 인증 필요  
- 403 권한 없음  
- 404 리소스 없음  
- 500 서버 오류  

HTTP vs HTTPS  
- HTTP: 평문 통신, 포트 80  
- HTTPS: SSL/TLS 암호화, 포트 443  

## 3-2. 브라우저에 URL 입력 후 요청/응답 과정

1. URL 입력  
2. DNS 조회 (Domain → IP)  
3. TCP 연결 (3-way handshake)  
4. TLS 핸드셰이크 (HTTPS)  
5. HTTP 요청 전송  
6. 서버 처리 (Filter → Interceptor → Controller → Service → DB)  
7. HTTP 응답 반환  
8. 브라우저 렌더링 (DOM → CSSOM → Render Tree → Layout → Paint)  
9. 추가 리소스 요청 (CSS, JS, Image)

전체 흐름 요약  
URL 입력 → DNS → TCP → TLS → HTTP 요청 → 서버 처리 → HTTP 응답 → 브라우저 렌더링


