import me.xx2bab.gradle.lifecycle.build.Lifecycle

buildscript {
    println("build.gradle.kts buildscript")

    // Just like what we mentioned in settings.gradle.kts, scripts inside the buildscript{} will
    // be evaluated first before anything you write in the gradle file. So if you want to make an
    // variable be accessed by both buildscript{} and other places in this file, you have to define
    // it here.
    project.extra["kotlin_version"] = "1.2.61"

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.2.1")
//        classpath("com.alibaba:fastjson:1.2.51")
    }
}



allprojects {
    repositories {
        google()
        jcenter()
    }
}

task("clean") {
    delete(rootProject.buildDir)
}

apply(from = "./another_script.gradle.kts")

//println("rootProject.allprojects.size: " + rootProject.allprojects.size)

//beforeEvaluate({
//    Lifecycle.beforeEvaluate(this.displayName)
//})

//afterEvaluate({
//    Lifecycle.afterEvaluate(this.displayName)
//})

allprojects {
    val proj = this

    this.beforeEvaluate({
        Lifecycle.beforeEvaluate(this.displayName)
    })

    this.afterEvaluate({
        Lifecycle.afterEvaluate(this.displayName)
    })

    this.tasks.whenTaskAdded({
        Lifecycle.whenTaskAdded(proj.name + ":" +  this.name)
    })
}