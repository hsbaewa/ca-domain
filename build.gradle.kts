// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false

    // 참고 : https://cocoslime.github.io/blog/Android-Library-Maven-Central/
    alias(libs.plugins.maven.publish) apply false // 대체 플러그인

    // Testing
    alias(libs.plugins.junit5.robolectric) apply false
}