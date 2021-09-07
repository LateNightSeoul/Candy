# 동기 부여 교육 앱 : Candy

![image](https://user-images.githubusercontent.com/60308568/132358449-42e6af8b-b8fe-48ba-9d91-2b08a70d06c0.png) 


## 개요
[비대면 교육으로 인한 아이들 교육의 어려움]

코로나로 인해 많은 교육 기관에서 비대면 교육을 실시하고 있습니다. 이로 인해 아이들의 교육 여건은 나빠지고 있습니다. 학부모들은 교육에 있어 자녀를 통제하고 동기 부여하는데 더 많은 어려움을 겪고 있는 실정입니다. 많은 교육 플랫폼과 툴이 등장하였지만 학습 편의를 위한 것일 뿐, 이를 통해 아이들의 학습 의욕을 고취하는 것은 역부족이었습니다.

[비대면으로도 아이들에게 직접적으로 동기 부여할 방법이 있지 않을까?]

이에 저희 팀에서는 아이들에게 직접적인 동기부여를 제공하는 교육 플랫폼 '캔디(Candy)'를 제안합니다.
'캔디'는 플랫폼의 화폐 단위를 뜻합니다. 플랫폼에서는 실시간으로 교육과 이에 해당하는 챌린지를 제공합니다. 학부모는 '캔디'를 충전한 뒤 이를 챌린지에 배정합니다. 아이가 이 챌린지를 완수할 경우 배정된 캔디 만큼의 보상을 받습니다. 아이들은 직접적인 보상이 존재하므로 더욱 열심히 교육에 참여할 것이고 학부모들은 목표 의식이 아직 부족한 아이들을 위해 필요한 교육을 선정하여 학습 방향을 설정할 수 있을 것입니다. '캔디' 플랫폼은 교육 기관, 강사, 일반 튜터 등과의 협업을 통해 무궁무진한 형태로 발전할 수 있을 것입니다.

## 개발 환경

서버
- IDE : IntelliJ IDEA
- Gradle
- Java 11
- Spring 2.5.2
- H2 Database 

```
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-mail'
    implementation("com.google.guava:guava:30.1.1-jre")
    implementation group: 'io.jsonwebtoken', name: 'jjwt-api', version: '0.11.2'
    implementation group: 'io.jsonwebtoken', name: 'jjwt-impl', version: '0.11.2'
    implementation group: 'io.jsonwebtoken', name: 'jjwt-jackson', version: '0.11.2'
    implementation 'com.github.gavlyukovskiy:p6spy-spring-boot-starter:1.6.2'
    implementation 'com.auth0:java-jwt:3.18.1'
    implementation group: 'io.springfox', name: 'springfox-swagger-ui', version: '2.9.2'
    implementation group: 'io.springfox', name: 'springfox-swagger2', version: '2.9.2'
    annotationProcessor group: 'org.springframework.boot', name: 'spring-boot-configuration-processor'
    // https://mvnrepository.com/artifact/org.apache.commons/commons-lang3
    implementation group: 'org.apache.commons', name: 'commons-lang3', version: '3.12.0'
    // https://mvnrepository.com/artifact/javax.validation/validation-api
    implementation 'javax.validation:validation-api:2.0.1.Final'
    implementation 'org.springframework.boot:spring-boot-starter-security'
    implementation 'org.json:json:20190722'
    compileOnly 'org.projectlombok:lombok'
    runtimeOnly 'com.h2database:h2'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'

    implementation "com.querydsl:querydsl-jpa:${queryDslVersion}"
    annotationProcessor(
            "javax.persistence:javax.persistence-api",
            "javax.annotation:javax.annotation-api",
            "com.querydsl:querydsl-apt:${queryDslVersion}:jpa")
}
```

안드로이드
- IDE : Android Studio
- Gradle
- Kotlin

## 시작하기

- 코드 내려받기

``` git
git clone "https://github.com/LateNightSeoul/Candy"
```

- 서버
Candy-Server\build\libs 의 jar 파일 실행
localhost:8080으로 접근 가능

  - DB 접속
    서버 실행 후 localhost:8080/h2-console
  - Api 문서 보기
    서버 실행 후 localhost:8080/swagger-ui.html
  
