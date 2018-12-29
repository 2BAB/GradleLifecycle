package me.xx2bab.gradle.lifecycle.build

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction
import org.gradle.kotlin.dsl.create

class TestPlugin : Plugin<Project> {

    companion object {
        val RELEASE_TASK_NAME: String = "deployRelease"
    }

    override fun apply(project: Project) {
        val testTask = project.tasks.create<TestTask>("testTask")

        testTask.doFirst({
            println("aaTestAction")
        })
        testTask.doFirst({
            println("bbTestAction")
        })
        testTask.doFirst({
            println("ccTestAction")
        })
        testTask.doFirst({
            println("ddTestAction")
        })

        testTask.doLast({
            println("aaaTestAction")
        })
        testTask.doLast({
            println("bbbTestAction")
        })
        testTask.doLast({
            println("cccTestAction")
        })
        testTask.doLast({
            println("dddTestAction")
        })
    }

    open class TestTask : DefaultTask() {

        @TaskAction
        fun eTestAction() {
            println("eTestAction")
        }

        @TaskAction
        fun dTestAction() {
            println("dTestAction")
        }

        @TaskAction
        fun bTestAction() {
            println("bTestAction")
        }

        @TaskAction
        fun cTestAction() {
            println("cTestAction")
        }

        @TaskAction
        fun aTestAction() {
            println("aTestAction")
        }

    }
}