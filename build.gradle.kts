import me.xx2bab.gradle.lifecycle.build.Lifecycle
import org.gradle.internal.classloader.CachingClassLoader
import org.gradle.internal.classloader.MultiParentClassLoader
import org.gradle.internal.classloader.VisitableURLClassLoader

buildscript {
    println("build.gradle.kts buildscript")

    println("[Lifecycle] >>> [onEvaluatingRootBuildScript] >>> " +
            ">>> The classloader of buildscript is $classLoader.")
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
        classpath("com.android.tools.build:gradle:3.3.0")
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
Lifecycle.println("")
val urlClassloader = javaClass.classLoader as VisitableURLClassLoader
val parentParent = urlClassloader.parent.parent as MultiParentClassLoader
println("[Lifecycle] >>> [onEvaluatingRootBuildScript] >>> " +
        ">>> The classloader of build.gradle.kts is $urlClassloader," +
        " hashcode is ${urlClassloader.hashCode()}," +
        " parent is ${urlClassloader.parent}," +
        " parent.parent is ${urlClassloader.parent.parent}," +
        " parent.parent.parent is ${urlClassloader.parent.parent.parent}," +
        " parent.parents is ${parentParent.parents.joinToString()}," +
        " urls are ${urlClassloader.urLs.joinToString()}.")

allprojects {
    val proj = this

    this.beforeEvaluate({
        Lifecycle.beforeEvaluate(this.displayName)
    })

    this.afterEvaluate({
        Lifecycle.afterEvaluate(this.displayName)
    })

    this.tasks.whenTaskAdded({
        Lifecycle.whenTaskAdded(proj.name + ":" + this.name)
    })
}