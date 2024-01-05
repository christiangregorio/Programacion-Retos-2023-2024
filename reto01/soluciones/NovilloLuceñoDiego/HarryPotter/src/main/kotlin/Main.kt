package org.example

import org.example.controller.Controller

fun playagain(input : String): Boolean {
    var editableinput = input.uppercase()
    var result = false
    do {
        if (!(editableinput == "Y" || editableinput == "N")){
            println("Not what i asked, try again (Y/N)")
            editableinput = readln()
        }
    }while (!(editableinput == "Y" || editableinput == "N"))

    if (editableinput == "Y"){
        result = true
    }

    return result
}

fun main() {
    var controller : Controller
    do {
        println("Game starts! Good luck beating Voldemort!!")
        controller = Controller.creategameinstance()
        do {
            controller.startround()
        }while (!controller.winningconditionsaremet())
        println("Congratulations! Harry collected all horrocruxes!!")
        controller.printstats()
        println("Do you want to play again? (Y/N)")

    }while (playagain(readln()))
}

