import com.alibaba.fastjson.JSON
import me.xx2bab.gradle.lifecycle.build.Lifecycle

Lifecycle.onEvaluatingSettingsScript("This message placed before and out of the buildscipt{} " +
        "block, But it STILL prints after the message that in buildscipt{} block.")

buildscript {
    println("[Lifecycle] >>> [onEvaluatingSettingsScript] >>> " +
            "Hi! Everybody! Let buildscript{} to be evaluated first! " +
            "Noticed that, here inside the buildscript{} can not invoke " +
            "`Lifecycle#onEvaluatingSettingsScript` that is from `buildSrc` component.")

    repositories {
        jcenter()
    }

    dependencies {
        classpath("com.alibaba:fastjson:1.2.51")
    }
}

Lifecycle.onEvaluatingSettingsScript("Of course, you can reference anything from buildSrc in " +
        "settings.gradle. For example, we can get the value of `targetSDK` from `Config.kt`: " +
        Config.Android.targetSDK)
Lifecycle.onEvaluatingSettingsScript("However, dependencies you defined above can only work " +
        "in this scripts, or classpath scope is limited. Here is a snippet shows the usage" +
        "of the lib `fastjson`: ${(JSON.parseObject("{\"setting\": 233}").getIntValue("setting"))}")



include(":app")

Lifecycle.onEvaluatingSettingsScript("Usually we write our scripts here after including modules.")

// println("rootProject.children.size: " + rootProject.children.size)

gradle.settingsEvaluated({
    Lifecycle.onSettingsEvaluated("Here you can refer all ProjectDescriptors, ex: ${this.project(":app").name}")
})

gradle.projectsLoaded({
    Lifecycle.onProjectsEvaluated("${this.rootProject.childProjects.size}")
    rootProject.beforeEvaluate({
        Lifecycle.beforeEvaluate(this.displayName)
    })

    rootProject.tasks.whenTaskAdded({
        Lifecycle.whenTaskAdded(rootProject.name + ":" + this.name)
    })
})

gradle.beforeProject({
    Lifecycle.beforeProject(this.displayName)
})

gradle.afterProject({
    Lifecycle.afterProject(this.displayName)
})

gradle.projectsEvaluated({
    Lifecycle.onProjectsEvaluated("")
})

gradle.taskGraph.whenReady({
    Lifecycle.whenTaskGraphIsReady("")
})

gradle.taskGraph.beforeTask({
    Lifecycle.beforeTask(this.name)
})

gradle.taskGraph.afterTask({
    Lifecycle.afterTask(this.name)
})

gradle.addListener(object: TaskActionListener {
    override fun beforeActions(task: Task) {
        Lifecycle.beforeAction(task.name)
    }

    override fun afterActions(task: Task) {
        Lifecycle.afterAction(task.name)
    }
})

gradle.buildFinished({
    Lifecycle.onBuildFinished("")
})