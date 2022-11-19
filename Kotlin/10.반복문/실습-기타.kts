val numbers = intArrayOf(5, 10, 15)

// 값만 필요할
for (number in numbers) { //foreach 와 동일
    println(number)
}
println("------------------")
// 값과 인덱스 모두 필요할 때
for ((index, value) in numbers.withIndex()) { //foreachindexed
    println(index)
    println(value)
}
println("------------------")
// 인덱스만 필요할 때
for (index in numbers.indices) {
    println(index)
}
println("------------------")
//본문에서 사용될 변수이름을 기본 제공으로 사용
numbers.forEachIndexed { index, i ->

}
//본문에서 사용될 변수이름을 변경해서 사용
numbers.forEachIndexed { index, value ->

}

// break
for (i in 1..3) {// i반복문
    println("i : " + i)
    for (j in 1..3) {//j반복문
        if (j == 2) break //구문1
        else println("j : " + j) //구문2
    }
}
// i1 -> j1/구문1 -> j1/구문2 -> j2/구문1 -> i2 -> j1/구문1 -> j1/구문2 -> j2/구문1 -> i3...
println("------------------------------")
// break + label
loop@ for (i in 1..3) {// i반복문
    println("i : " + i)
    for (j in 1..3) {//j반복문
        if (j == 2) break@loop //구문1
        else println("j : " + j) //구문2
    }
}
// i1 -> j1구문1 -> j1구문2 -> j2구문1 -> loop탈출(i반복문)
println("continue------------------------------")
// continue
for (i in 1..3) { //i반복문
    println("i : " + i)
    for (j in 1..3) {//j반복문
        if (j == 2) continue // 구문 1
        else println("j : " + j) // 구문2
    }
}
//i1 -> (j1/구문1 -> j1/구문2) -> (j2/구문1) -> (j3/구문1 -> j3->구문2) -> i2...
println("continue + label------------------------------")
// continue + label
loop@ for (i in 1..3) { //i반복문
    println("i : " + i)
    for (j in 1..3) {//j반복문
        if (j == 2) continue@loop // 구문 1
        else println("j : " + j) // 구문2
    }
}
// i1 -> j1/구문1 -> j1/구문2 -> j2/구문 -> i2 -> j1/구문1 -> j1/구문2 -> i3 -> -> j1/구문1 -> j1/구문2

println("------------------------------")
// return
fun returnFunction(): Unit {
    for (i in 1..3) { //i반복문
        println("i : " + i)
        for (j in 1..3) {//j반복문
            if (j == 2) return // 구문 1
            else println("j : " + j) // 구문2
        }
    }
}
// i1 -> j1/구문1 -> j1/구문2 -> j2/구문1
returnFunction()

// foreach + label
// foreach 는 continue와 break 사용 불가
println("foreach------------------------------")
listOf(1, 2, 3).forEach loop@{
    if (it == 2) return@loop
    else println(it)
}