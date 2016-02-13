package co.uk.hackthetower.exercises

import co.uk.hackthetower.commands.server.{React, Welcome, Goodbye}
import org.scalatest.{Matchers, FlatSpec}

import scala.util.Random


class Ex1ValidateInputSpec extends FlatSpec with Matchers {

  "parseInput" should "return Valid if input contains a valid server command" in {
    val input = "Goodbye(energy=-1)"
    Ex1ValidateInput.parseInput(input).isValid should be(true)
  }

  it should "return Goodbye for a Goodbye input with negative energy" in {
    val input = "Goodbye(energy=-1)"
    Ex1ValidateInput.parseInput(input).getOrElse(Goodbye(Int.MinValue)) should be(Goodbye(-1))
  }

  it should "return Goodbye for a Goodbye input with positive energy" in {
    val input = "Goodbye(energy=100)"
    Ex1ValidateInput.parseInput(input).getOrElse(Goodbye(Int.MinValue)) should be(Goodbye(100))
  }

  it should "return Welcome for a valid Welcome entry" in {
    val input = "Welcome(name=John_Is,apocalypse=999,round=66,maxslaves=-3)"
    Ex1ValidateInput.parseInput(input).getOrElse(Goodbye(Int.MinValue)) should be(Welcome("John_Is", 999, 66, -3))
  }

  it should "return React for a valid React entry" in {
    val input = "React(generation=-77,name=HAHA,time=55,view=ME,energy=IX,master=9:10,collision=2:3,slaves=5,custom=2,custom2=HEHE)"
    Ex1ValidateInput.parseInput(input).getOrElse(Goodbye(Int.MinValue)) should be(React(-77, "HAHA", 55, "ME", "IX", (9, 10), (2, 3), 5, Map("custom" -> "2", "custom2" -> "HEHE")))
  }

  it should "return Invalid if input is empty" in {
    val input = ""
    Ex1ValidateInput.parseInput(input).isInvalid should be(true)
  }

  it should "return Invalid if input is nonsensical garbage" in {
    val input = Random.nextString(40)
    Ex1ValidateInput.parseInput(input).isInvalid should be(true)
  }

  it should "return Invalid if input doesn't match a server command" in {
    val input = "Log(text=this is a bot command not a server command!)"
    Ex1ValidateInput.parseInput(input).isInvalid should be(true)
  }

  it should "return Invalid if input contains multiple server commands" in {
    val input = "Goodbye(1)|Goodbye(4)"
    Ex1ValidateInput.parseInput(input).isInvalid should be(true)
  }

}
