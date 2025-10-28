import java.nio.file.FileVisitOption
import java.nio.file.FileVisitResult
import java.nio.file.Files
import java.nio.file.SimpleFileVisitor
import kotlin.io.path.absolute

rootProject.name = "oauth2"

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

fun includeModule() {
    val entryPointName = "modules"
    val entryPoint = rootDir.resolve(entryPointName).toPath()
    val foundBuildScriptPaths = mutableListOf<java.nio.file.Path>()
    Files.walkFileTree(
        entryPoint,
        setOf(FileVisitOption.FOLLOW_LINKS),
        Integer.MAX_VALUE,
        FileVisitor("build.gradle.kts", foundBuildScriptPaths),
    )

    val modules =
        foundBuildScriptPaths
            .map { it.parent.absolute().toString() }
            .map { it.replace("${rootDir.toPath()}${File.separator}", "") }
            .map { it.replace(File.separator, ":") }
            .toList()

    include(*modules.toTypedArray())

    val moduleGroups =
        Files
            .list(entryPoint)
            .map { it.fileName.toString() }
            .map { "$entryPointName:$it" }
            .toList()

    include(*moduleGroups.toTypedArray())
}

class FileVisitor(
    private val fileNameToSearch: String,
    private val foundBuildScriptPaths: MutableList<java.nio.file.Path>,
) : SimpleFileVisitor<java.nio.file.Path>() {
    override fun visitFile(
        file: java.nio.file.Path,
        attrs: java.nio.file.attribute.BasicFileAttributes,
    ): FileVisitResult {
        if (file.fileName.toString() == fileNameToSearch) {
            foundBuildScriptPaths.add(file.toAbsolutePath())
        }
        return FileVisitResult.CONTINUE
    }

    override fun visitFileFailed(
        file: java.nio.file.Path,
        exc: java.io.IOException,
    ): FileVisitResult {
        // 에러 발생 시의 처리
        println("Error accessing file: $file - ${exc.message}")
        return FileVisitResult.CONTINUE
    }

    override fun postVisitDirectory(
        dir: java.nio.file.Path,
        exc: java.io.IOException?,
    ): FileVisitResult = FileVisitResult.CONTINUE

    override fun preVisitDirectory(
        dir: java.nio.file.Path,
        attrs: java.nio.file.attribute.BasicFileAttributes,
    ): FileVisitResult = FileVisitResult.CONTINUE
}

includeModule()
