plugins {
    id("com.android.library")
    id("me.xx2bab.gradle.lifecycle.build")
}

android {
    compileSdkVersion(28)
    defaultConfig {
        minSdkVersion(16)
        targetSdkVersion(28)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to arrayOf("*.jar"))))
    implementation("com.android.support:appcompat-v7:${Config.Versions.supportLibs}")
}
