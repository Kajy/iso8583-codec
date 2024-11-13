package codec.types.field48.types

import cats.syntax.apply.*
import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.{ Codec, TransformSyntax }

import scala.math.pow

case class ReferenceConversionRate4839(rate: Double) extends PrivateData48XX

object ReferenceConversionRate4839 {

  val codec: Codec[ReferenceConversionRate4839] = LLVAR_N
    .xmap(
      rateStr =>
        if (rateStr.length != 8) 0d
        else {
          val decimalNumber = rateStr.head
          val numberStr     = rateStr.tail

          (decimalNumber.toString.toDoubleOption, numberStr.toDoubleOption)
            .mapN { case (decimalNb, nb) =>
              nb / pow(10, decimalNb)
            }
            .getOrElse(0d)
        },
      (nb: Double) => {
        val nbStr                   = nb.toString
        val Array(intNb, decimalNb) = nbStr.split('.')
        s"${decimalNb.length}$intNb$decimalNb"
      }
    )
    .as[ReferenceConversionRate4839]

}
