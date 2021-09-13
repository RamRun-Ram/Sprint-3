package ru.sber.oop

open class Room(val name: String, val size: Int) {
//  2.2 В классе ru.sber.oop.Room предоставить доступ к этой переменной только для наследников.
    protected open val dangerLevel = 5

//   4. Создайте в классе ru.sber.oop.Room вторичный конструктор, который бы инициализировал имя и задавал размер по умолчанию 100.
    constructor(_name: String): this (_name,100)

    fun description() = "Room: $name"

    open fun load(): String {
        return goblin.getSalutation()
    }
//    Добавьте в класс ru.sber.oop.Room поле типа Monster и инициализируйте его экземпляром класса Goblin.
    val goblin: Monster = Goblin("Halk","Человек-мутант","Ярость",500)
}
fun Monster.getSalutation(): String{
    return "Hi!!!I'm Monster.My name $name"
}
//   1.1 Создайте подкласс класса ru.sber.oop.Room - TownSquare c именем "Town Square" и размером 1000.
class TownSquare(name: String = "Town Square",size: Int = 1000): Room(name,size){

//   1.2 Переопределите в новом классе функцию load() (придумайте строку для загрузки).
//   3. Запретите возможность переопределения функции load() в классе TownSquare.
     final override fun load() = "Creating.."

//   2. Переопределите dangerLevel в TownSquare, так чтобы сделать уровень угрозы на 3 пункта меньше среднего.
         override val dangerLevel: Int
           get() = super.dangerLevel - 3
}
