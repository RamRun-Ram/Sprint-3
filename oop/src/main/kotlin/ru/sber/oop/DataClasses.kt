package ru.sber.oop
//      4. Исправьте class User так, чтобы функция equals выдавала правильный ответ.
data class User(val name: String, val age: Long,val city: String?=null) {

}

fun main() {

//       2.1  Изменяем город user1 на 'Omsk'
    val user1 = User("Alex", 13,"Omsk")

//      1.Создаем user2, изменив имя и используя функцию copy()
    val user2 = user1.copy("German")

//      2.2 Создайте копию user1 - user3, только с городом 'Tomsk'.
    val user3 = user1.copy(city = "Tomsk")

//      3.Сравниваем user1 и user3, используя функцию equals().
    print(user1.equals(user3))
}