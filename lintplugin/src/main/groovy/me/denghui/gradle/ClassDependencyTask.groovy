package me.denghui.gradle

import javassist.ClassPool
import javassist.CtClass
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

/**
 * 分析类的依赖
 */
public class ClassDependencyTask extends DefaultTask {
    static final def NAME = "makeDependency"
    static final def FILE_NAME = "dexknife_copy.txt"
    final List<String> TO_KEEP = new ArrayList<>()
    final String[] ENTRIES =  {
        ""
    }


    @TaskAction
    def main() {

    }

    def parseFileByJavassist() {
        List<String> entryClasses = new ArrayList<>(ENTRIES)

        for (String strClass in entryClasses) {
            if (!TO_KEEP.contains(strClass)) {
                // 直接的依赖
                TO_KEEP.add(strClass)
            }
            CtClass ctClass = ClassPool.getDefault().get(strClass)
        }
    }


    def addDependency(CtClass ctClass) {

    }
}