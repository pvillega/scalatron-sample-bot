package co.uk.hackthetower.commands.server

import cats.data.Validated.{Invalid, Valid}
import cats.data.ValidatedNel

/**
  * Represents a command sent by the server to the Bot
  * See: https://github.com/hackthetower-london-scalatron/scalatron/blob/master/Scalatron/doc/markdown/Scalatron%20Protocol.md
  */
trait ServerCommand

object ServerCommand {

  def hasExpectedKeys(input: Map[String, String], expected: List[String]): ValidatedNel[String, Boolean] =
    (if (expected.forall(input.keySet.contains)) Valid(true)
    else Invalid(s"Input with entries ${input.keySet} missing some keys from $expected")).toValidatedNel

  def isPresent(input: Map[String, String], key: String): ValidatedNel[String, String] =
    (if (input.contains(key)) Valid(input(key))
    else Invalid(s"Key $key not in input map")).toValidatedNel

  def isNumeric(input: Map[String, String], key: String): ValidatedNel[String, Int] =
    isPresent(input, key) andThen { str =>
      (if (isNumber(str)) Valid(str.toInt)
      else Invalid(s"Value $str is not an integer")).toValidatedNel
    }

  def isOptionalIntInt(input: Map[String, String], key: String): ValidatedNel[String, Option[(Int, Int)]] =
    isPresent(input, key).fold(
    fe => Valid(Option.empty),
    fa => {
      val split = fa.split(":")
      val a = split(0)
      val b = split(1)
      if(isNumber(a) && isNumber(b)) Valid(Some((a.toInt, b.toInt)))
      else Invalid(s"Value $fa can't be parsed into (Int,Int)")
    }).toValidatedNel

  protected def isNumber(s: String) = s.matches("""[+-]?((\d+(e\d+)?[lL]?)|(((\d+(\.\d*)?)|(\.\d+))(e\d+)?[fF]?))""")
}
