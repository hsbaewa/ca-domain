import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)

    // maven publish
    alias(libs.plugins.maven.publish)
    id("signing") // GPG 서명을 위한 플러그인 추가
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation(libs.kotlinx.coroutines.core)
}

// Maven 그룹 및 버전 설정
group = "io.github.hsbaewa"
version = "0.0.1"

tasks.withType(Javadoc::class) {
    options {
        encoding = "UTF-8"
    }
}

signing {
    sign(publishing.publications)
    useGpgCmd() // 이거 있으면 signAllPublications() 필요 없음.
}

mavenPublishing {
//    signAllPublications() // Gpg 서명을 위한 설정
    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL) // 포탈로 등록 할거기 때문에 타입 추가

    coordinates("io.github.hsbaewa", "ca-domain", "0.0.1") // 네임 스페이스, 라이브러리 이름, 버전 순서로 작성

    // POM 설정
    pom {
        /**
        name = '[라이브러리 이름]'
        description = '[라이브러리 설명]'
        url = '[오픈소스 Repository Url]'
         */
        name = "ca-domain"
        description = "Clean Architecture Domain Library"
        url = "https://github.com/hsbaewa/ca-domain"
        inceptionYear = "2025"

        // 라이선스 정보
        licenses {
            license {
                name = "Apache License"
                url = "https://github.com/hsbaewa/ca-domain/blob/main/LICENSE"
            }
        }

        // 개발자 정보
        developers {
            developer {
                id = "hsbaewa"
                name = "Development guy"
                email = "hsbaewa@gmail.com"
            }
            // 다른 개발자 정보 추가 가능...
        }

        /**
        connection = 'scm:git:github.com/[Github 사용자명]/[오픈소스 Repository 이름].git'
        developerConnection = 'scm:git:ssh://github.com/[Github 사용자명]/[오픈소스 Repository 이름].git'
        url = '<https://github.com/>[Github 사용자명]/[오픈소스 Repository 이름]/tree/[배포 브랜치명]'
         */
        scm {
            connection = "scm:git:github.com/hsbaewa/ca-domain.git"
            developerConnection = "scm:git:ssh://github.com:hsbaewa/ca-domain.git"
            url = "https://github.com/hsbaewa/ca-domain/tree/main"
        }
    }
}
