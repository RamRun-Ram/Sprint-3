package ru.sber.nio

import java.io.File
import java.io.FileOutputStream
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

/**
 * Реализовать простой аналог утилиты grep с использованием калссов из пакета java.nio.
 */
fun main() {
    val grep = Grep()
    grep.find("22")
}

class Grep {

    /**
     * Метод должен выполнить поиск подстроки subString во всех файлах каталога logs.
     * Каталог logs размещен в данном проекте (io/logs) и внутри содержит другие каталоги.
     * Результатом работы метода должен быть файл в каталоге io(на том же уровне, что и каталог logs), с названием result.txt.
     * Формат содержимого файла result.txt следующий:
     * имя файла, в котором найдена подстрока : номер строки в файле : содержимое найденной строки
     * Результирующий файл должен содержать данные о найденной подстроке во всех файлах.
     * Пример для подстроки "22/Jan/2001:14:27:46":
     * 22-01-2001-1.log : 3 : 192.168.1.1 - - [22/Jan/2001:14:27:46 +0000] "POST /files HTTP/1.1" 200 - "-"
     */

    fun find(subString: String) {
        val pathsArray: ArrayList<Path> = ArrayList()
        val directory = Paths.get("/Users/ramil/Desktop/Sprint-3/Sprint-3/io/logs")
        Files.find(directory, 15, { i, _ -> i.toString().endsWith(".log") }).forEach {
            pathsArray.add(it)
        }
        for (path in pathsArray) {
            val file = path.toFile()
            val fileLines = file.readLines()
            for ((count, line) in fileLines.withIndex()) {
                if (line.contains(subString)) {
                    val fileOutputStream = FileOutputStream(
                            File("/Users/ramil/Desktop/Sprint-3/Sprint-3/io/logs/result.txt"), true)
                    fileOutputStream.use { fstr ->
                        fstr.write(file.name.plus(" : ".plus((count + 1).toString().plus(
                                " : ".plus(line).plus(System.lineSeparator())))).toByteArray()
                        )
                    }
                }
            }
        }
    }
}