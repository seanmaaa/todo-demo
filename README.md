# Todo App

### 개발환경

- mac OS ventura v13.0.1
- openjdk version 17.0.1
- PostgreSQL 14.1

### Docker 이미지 생성 (로컬)

```sh
./gradlew jibDockerBuild

docker-compose up -d
```

주의사항: 첫 실행 시 Postgresql Database가 완전히 초기화되기 전까지 todo-api 앱이 정상적으로 구동되지 않음

### 사용기술

- Spring boot 3.0.1

### Remaining TODOs

- Secret, Environment를 사용한 설정파일 환경변수화
- 보드ID, 아이템ID를 Integer 형으로 변경
- TestContainers를 활용한 테스트 자동화
