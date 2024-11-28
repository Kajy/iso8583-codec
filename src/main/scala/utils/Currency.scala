package utils

import codec.FieldCodecs.N
import scodec.Codec

import java.util.Currency as JCurrency
import scala.jdk.CollectionConverters.*
import scala.util.{ Failure, Success, Try }
import scodec.TransformSyntax

final case class Currency(
    code: String,
    numericCodeAsString: String,
    precision: Int
) extends Product
    with Serializable {
  def asString: String = code
}

object Currency {

  val currencyMapping: Map[Int, JCurrency] =
    JCurrency.getAvailableCurrencies.asScala.map(c => c.getNumericCode -> c).toMap

  val EUR: Currency = unsafeFrom("978")

  def unsafeFrom(code: String): Currency =
    Try {
      val jCurrency = currencyMapping(code.toInt)
      Currency(
        code = jCurrency.getCurrencyCode,
        numericCodeAsString = jCurrency.getNumericCodeAsString,
        precision = jCurrency.getDefaultFractionDigits
      )
    } match {
      case Success(value) => value
      case Failure(exception) if exception.getMessage == null =>
        throw new IllegalArgumentException(
          s"Unable to find currency with code $code",
          exception
        )
      case Failure(exception) =>
        throw exception
    }

  def from(code: String): Either[String, Currency] = Try(unsafeFrom(code)) match {
    case Success(value) => Right(value)
    case Failure(e)     => Left(e.getMessage)
  }

  val codecN4: Codec[Currency] = N(4).xmapc(Currency.unsafeFrom)(c => String.format("%04d", c.numericCodeAsString.toInt)).as[Currency]
  val codecN3: Codec[Currency] = N(3).xmapc(Currency.unsafeFrom)(c => String.format("%03d", c.numericCodeAsString.toInt)).as[Currency]

}
