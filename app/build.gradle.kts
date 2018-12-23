import com.android.build.gradle.ProguardFiles.getDefaultProguardFile
import me.xx2bab.gradle.lifecycle.build.Lifecycle

plugins {
    id("com.android.application")
//    id("kotlin-android")
//    id("kotlin-android-extensions")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        applicationId = "me.xx2bab.gradle.lifecycle"
        minSdkVersion(16)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to arrayOf("*.jar"))))
    implementation("com.android.support:appcompat-v7:${Config.Versions.supportLibs}")
    implementation("com.android.support.constraint:constraint-layout:1.1.3")
}

