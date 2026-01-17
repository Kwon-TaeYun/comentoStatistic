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


### ❌ 에러 응답

| 코드 | 메시지 | 설명 |
| --- | --- | --- |
| 400 | year는 2자리 숫자여야 합니다. | year 파라미터 형식이 잘못된 경우 |
| 500 | INTERNAL_SERVER_ERROR | 서버 내부 오류 |


## 작성 문서
- Word:: [API문서_코멘토_권태윤_260103.docx](https://github.com/user-attachments/files/24415496/API._._._260103.docx) 
- Notion: https://www.notion.so/API-2dd98cfebe1e80d68de2cbf9e0749274
---


# 2. 실행 화면

## 📌 1. 접속자 수 조회

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


