package ru.sber.io

import java.io.*
import java.nio.file.Files
import java.nio.file.Paths
import java.util.zip.ZipOutputStream
import java.util.zip.ZipInputStream
import java.util.zip.ZipEntry;

/**
 * Реализовать методы архивации и разархивации файла.
 * Для реализиации использовать ZipInputStream и ZipOutputStream.
 */
fun main() {
    val fileToZip = File("/Users/ramil/Desktop/Sprint-3/Sprint-3/io/logs/23.01.2001/23-01-2001-1.log")
    val fileToUnzip = File("/Users/ramil/Desktop/Sprint-3/Sprint-3/io/logs/23.01.2001/23-01-2001-1.zip")
    val archivator = Archivator()

    archivator.zipLogfile(fileToZip)
    archivator.unzipLogfile(fileToUnzip)
}

class Archivator {
    /**
     * Метод, который архивирует файл logfile.log в архив logfile.zip.
     * Архив должен располагаться в том же каталоге, что и исходной файл.
     */
    fun zipLogfile(file: File) {
        val zipFile = File(file.path.replace(".log", ".zip"))
        val zipFileName = file.name
        val zipOutputStream =
                ZipOutputStream(BufferedOutputStream(FileOutputStream(zipFile)))
        zipOutputStream.use { zstr ->
            val bufferedInputStream = BufferedInputStream(FileInputStream(file.path))
            bufferedInputStream.use { bstr ->
                zstr.putNextEntry(ZipEntry(zipFileName))
                bstr.copyTo(zstr, 1024)
            }
        }
    }

    /**
     * Метод, который извлекает файл из архива.
     * Извлечь из архива logfile.zip файл и сохарнить его в том же каталоге с именем unzippedLogfile.log
     */
    fun unzipLogfile(file: File) {
        val zipFile = file
        val pathFileOfUnzip = Paths.get(zipFile.parent)
        val zipInputStream =
                ZipInputStream(BufferedInputStream(FileInputStream(zipFile)))
        zipInputStream.use { zstr ->
            var zipEntry = zstr.nextEntry
            while (zipEntry != null) {
                val fileName = "unzipped".plus(zipEntry.name)
                val pathZipFile = pathFileOfUnzip.resolve(fileName)
                val byteBuffer = ByteArray(1024)
                val streamOfFile = Files.newOutputStream(pathZipFile)
                streamOfFile.use { fstr ->
                    var valueOfBuffer = zstr.read(byteBuffer)
                    while (valueOfBuffer >= 0) {
                        fstr.write(byteBuffer, 0, valueOfBuffer)
                        valueOfBuffer = zstr.read(byteBuffer)
                    }
                }
                zipEntry = zstr.nextEntry
            }
            zstr.closeEntry()
        }
    }
}

