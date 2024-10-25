package codec.types.field48.types

import codec.FieldCodecs.LLVAR_N
import codec.types.field48.PrivateData48XX
import scodec.{ Codec, TransformSyntax }

case class CreditCardFee4830(amount: String) extends PrivateData48XX

object CreditCardFee4830 {
  val codec: Codec[CreditCardFee4830] = LLVAR_N.as[CreditCardFee4830]
}
