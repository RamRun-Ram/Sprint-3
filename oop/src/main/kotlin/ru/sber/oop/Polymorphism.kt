package ru.sber.oop

import kotlin.random.Random

interface Fightable {
    val powerType: String
    var healthPoints: Int

//   1.Добавьте метод чтения по умолчанию для поля damageRoll, которое возвращает рандомное число.
    val damageRoll: Int
        get() = Random.nextInt(1,100)

    fun attack(opponent: Fightable): Int
}
//   2.Реализуйте класс Player, имплементирующий интерфейс ru.sber.oop.Fightable с дополнительным полем name (строка)
//   и isBlessed. attack уменьшает здоровье оппоненту на damageRoll, если isBlessed = false, и удвоенный damageRoll,
//   если isBlessed = true. Результат функции attack -
//   количество урона, которое нанес объект класса Player.
class Player(val name: String, var isBlessed: Boolean,
             override val powerType: String,
             override var healthPoints: Int,
             override val damageRoll: Int) : Fightable {

    override fun attack(opponent: Fightable): Int {
        if (isBlessed == false) {
            opponent.healthPoints -= damageRoll
            return damageRoll
        } else opponent.healthPoints -= (damageRoll * 2)
        return damageRoll * 2
    }
}
//    3.Реализуйте абстрактный класс Monster, имплементирующий интерфейс ru.sber.oop.Fightable со строковыми полями
//    name и description.
abstract class Monster(open val name: String, open val description: String,
                       override val powerType: String,
                       override var healthPoints: Int,
                       override val damageRoll: Int) : Fightable {
//    3.1 Логика функции attack, такая же как и в предыдущем пункте, только без учета флага isBlessed (которого у нас нет).
    override fun attack(opponent: Fightable): Int {
        opponent.healthPoints -= damageRoll
        return damageRoll
    }
}
//    4.Реализуйте наследника класса Monster - класс Goblin. Переопределите в нем метод чтения damageRoll (допустим,
//    он в два раза меньше сгененрированного рандомного значения).
class Goblin(override val name: String, override val description: String, override val powerType: String,
             override var healthPoints: Int) : Monster(name,description,powerType,healthPoints,Random.nextInt(1,100)) {

    override val damageRoll: Int
        get() = super.damageRoll / 2
}






