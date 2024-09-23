## 테스트 실행 방법

`@Transactional(readOnly = true)` 설정에 따라 서로 다른 데이터베이스를 사용하는지 확인하기 위한 레포지토리입니다.

### 1. 도커 컨테이너 실행

- `compose.yml` 파일이 위치한 디렉터리에서 다음 명령어를 실행하여 도커 컨테이너를 시작합니다:

```bash
docker compose up -d
```

### 2. DataSourceTest 실행

- `test/src/test/java/hello/test/DataSourceTest.java` 파일 경로에서 테스트를 실행하여 성공 여부를 확인합니다.

### 3. 도커 컨테이너 종료

- 도커 컨테이너가 필요 없을 때는, 다시 `compose.yml` 파일이 위치한 디렉터리에서 다음 명령어를 실행하여 종료합니다:

```bash
docker compose down
```
