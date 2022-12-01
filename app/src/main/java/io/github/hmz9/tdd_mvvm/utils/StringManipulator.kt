package io.github.hmz9.tdd_mvvm.utils

class StringManipulator {

    fun reverseString(input: String): String{
        var reversedString = ""
        var currentIndex = input.length - 1

        if(input.isNotEmpty()){
            if(input.length == 1){
                reversedString = input
            }
            else{
                while (currentIndex >= 0){
                    reversedString = StringBuilder(reversedString).append(input[currentIndex]).toString()
                    currentIndex--
                }
            }
        }

        return reversedString
    }
}