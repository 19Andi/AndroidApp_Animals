package com.example.tema1_titescuandrei.models

class Animal(
    val name: String,
    val continent: String,
){
    val color: Long = determineColor()

    private fun determineColor(): Long {
        return when (continent) {
            "Europe" -> 0xff008a00
            "Asia" -> 0xffe51300
            "Africa" -> 0xffe0c701
            "North America" -> 0xffa0522c
            "South America" -> 0xfffa6801
            "Australia" -> 0xff6a00ff
            "Antarctica" -> 0xff1ba0e1
            else -> 0xffffffff
        }
    }
}

